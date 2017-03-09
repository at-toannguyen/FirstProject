package com.example.nhungnguyen.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //Khai bao bien
    private Button mBtn;
    private EditText mUser, mPass;
    private RadioButton mMale, mFemale;
    private RadioGroup mRbgr;
    private CheckBox mChk1, mChk2, mChk3, mChk4, mChk5, mChk6;
    private ImageView mImgEye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //khoi tao
        mBtn = (Button) findViewById(R.id.chkRegister);
        mUser = (EditText) findViewById(R.id.edUser);
        mPass = (EditText) findViewById(R.id.edPass);
        mRbgr = (RadioGroup) findViewById(R.id.rbgSex);
        mMale = (RadioButton) findViewById(R.id.rbgMale);
        mFemale = (RadioButton) findViewById(R.id.rbFemale);
        mChk1 = (CheckBox) findViewById(R.id.cbkReadBook);
        mChk2 = (CheckBox) findViewById(R.id.ckPlaySoccer);
        mChk3 = (CheckBox) findViewById(R.id.chkListen_music);
        mChk4 = (CheckBox) findViewById(R.id.chkPlayGame);
        mChk5 = (CheckBox) findViewById(R.id.chkSwimming);
        mChk6 = (CheckBox) findViewById(R.id.chkPlayBasketball);
        mImgEye = (ImageView) findViewById(R.id.imgEye);
        //set check cho cac radio button
        int idchecked = mRbgr.getCheckedRadioButtonId();
        switch (idchecked) {
            case R.id.rbgMale:
                break;
            case R.id.rbFemale:
                break;
        }
        // set onClick cho button
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gettext cac checkbox
//                String text = "";
//                List<CheckBox> items = new ArrayList<CheckBox>();
//                items.add(mChk1);
//                items.add(mChk2);
//                items.add(mChk3);
//                items.add(mChk4);
//                items.add(mChk5);
//                items.add(mChk6);
//                for (CheckBox item : items) {
//                    if (item.isChecked()) {
//                        text += item.getText().toString() + " ";
//                    }
//                }
                Toast.makeText(MainActivity.this, "\n User: " + mUser.getText().toString() + " \n Pass: " + mPass.getText().toString() + " \n sex: " + setSex() + " \n Hobby: " + getTextCheckBox(), Toast.LENGTH_SHORT).show();
                //chuyen sang activity
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        //set hide/show password
        mImgEye.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int x = Math.round(motionEvent.getX());
                int y = Math.round(motionEvent.getY());
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mPass.setInputType(InputType.TYPE_CLASS_TEXT);
                        Log.v("Test", "dơwn");
                        break;
                    case MotionEvent.ACTION_UP:
                        mPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        Log.v("test", "up");
                        break;
                }
                return true;
            }
        });
    }
    //ham getText checkbox
    public String getTextCheckBox(){
        String text = "";
        List<CheckBox> items = new ArrayList<CheckBox>();
        items.add(mChk1);
        items.add(mChk2);
        items.add(mChk3);
        items.add(mChk4);
        items.add(mChk5);
        items.add(mChk6);
        for (CheckBox item : items) {
            if (item.isChecked()) {
                text += item.getText().toString() + " ";
            }
        }
        return text;
    }
    //ham gettext radiobutton
    public CharSequence setSex() {

        if (mMale.isChecked()) {
            return mMale.getText().toString();
        } else {
            if (mFemale.isChecked()) {
                return mFemale.getText().toString();
            } else {
                return null;
            }
        }
    }
}
