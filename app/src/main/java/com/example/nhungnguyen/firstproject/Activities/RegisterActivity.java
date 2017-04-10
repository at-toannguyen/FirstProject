package com.example.nhungnguyen.firstproject.Activities;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
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

import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
@EActivity(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {
    @ViewById
    Button ChkRegister;
    private Button mBtn;
    private EditText mUser;
    private EditText mPass;
    private RadioButton mMale;
    private RadioButton mFemale;
    private RadioGroup mRag;
    private CheckBox mChk1;
    private CheckBox mChk2;
    private CheckBox mChk3;
    private CheckBox mChk4;
    private CheckBox mChk5;
    private CheckBox mChk6;
    private ImageView mImgEye;
    private Button mBtnLogOut;
    private void initVariable() {
        mBtn = (Button) findViewById(R.id.chkRegister);
        mUser = (EditText) findViewById(R.id.edUser);
        mPass = (EditText) findViewById(R.id.edPass);
        mMale = (RadioButton) findViewById(R.id.rbgMale);
        mFemale = (RadioButton) findViewById(R.id.rbFemale);
        mRag = (RadioGroup) findViewById(R.id.rbgSex);
        mChk1 = (CheckBox) findViewById(R.id.cbkReadBook);
        mChk2 = (CheckBox) findViewById(R.id.ckPlaySoccer);
        mChk3 = (CheckBox) findViewById(R.id.chkListen_music);
        mChk4 = (CheckBox) findViewById(R.id.chkPlayGame);
        mChk5 = (CheckBox) findViewById(R.id.chkSwimming);
        mChk6 = (CheckBox) findViewById(R.id.chkPlayBasketball);
        mImgEye = (ImageView) findViewById(R.id.imgEye);
        mBtnLogOut=(Button) findViewById(R.id.btnLogOut);
    }

    // TODO: 3/9/17  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initVariable();
        // Set check cho cac radio button
        int isChecked = mRag.getCheckedRadioButtonId();
        switch (isChecked) {
            case R.id.rbgMale:
                break;
            case R.id.rbFemale:
                break;
        }
        // Set onClick cho button
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "\n User: " + mUser.getText().toString() + " \n Pass: " + mPass.getText().toString() + " \n sex: " + setSex() + " \n Hobby: " + getTextCheckBox(), Toast.LENGTH_SHORT).show();
            }
        });
        // Set hide/show password
        mImgEye.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mPass.setInputType(InputType.TYPE_CLASS_TEXT);
                        Log.v("Test", "down");
                        break;
                    case MotionEvent.ACTION_UP:
                        mPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        Log.v("test", "up");
                        break;
                }
                return true;
            }
        });
        mBtnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                builder.setMessage("Do U want exit?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                SharedPreferences preferences=getSharedPreferences("mydata",MODE_PRIVATE);
                                SharedPreferences.Editor editor=preferences.edit();
                                editor.clear();
                                editor.commit();
                                finish();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog
                            }
                        });
                builder.create();
                builder.show();
            }
        });
    }


    /**
     * GET Text Checkbox of Uer
     *
     * @return String Text
     */
    private String getTextCheckBox() {
        String text = "";
        List<CheckBox> items = new ArrayList<>();
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

    /**
     * GET Text RadioButton of User
     *
     * @return String Text
     */
    private CharSequence setSex() {

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
