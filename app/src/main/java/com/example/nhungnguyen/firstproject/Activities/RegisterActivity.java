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

import com.example.nhungnguyen.firstproject.Interface.Mypre_;
import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Touch;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {
    @Pref
    Mypre_ mypre;
    @ViewById
    Button btnRegister;
    @ViewById
    EditText edUser;
    @ViewById
    EditText edPass;
    @ViewById
    RadioButton rbgMale;
    @ViewById
    RadioButton rbFemale;
    @ViewById
    RadioGroup rbgSex;
    @ViewById
    CheckBox cbkReadBook;
    @ViewById
    CheckBox ckPlaySoccer;
    @ViewById
    CheckBox chkListen_music;
    @ViewById
    CheckBox chkPlayGame;
    @ViewById
    CheckBox chkSwimming;
    @ViewById
    CheckBox chkPlayBasketball;
    @ViewById
    ImageView imgEye;
    @ViewById
    Button btnLogOut;

    @Click(R.id.btnRegister)
    void onClickBtnRegister() {
        Toast.makeText(RegisterActivity.this, "\n User: " + edUser.getText().toString() + " \n Pass: " +
                edPass.getText().toString() + " \n sex: " + setSex() + " \n Hobby: " + getTextCheckBox(), Toast.LENGTH_SHORT).show();
    }

    @Touch(R.id.imgEye)
    void onClickImgEyes(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                edPass.setInputType(InputType.TYPE_CLASS_TEXT);
                Log.v("Test", "down");
                break;
            case MotionEvent.ACTION_UP:
                edPass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                Log.v("test", "up");
                break;
        }
    }

    @Click(R.id.btnLogOut)
    void onClickLogout() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        builder.setMessage("Do U want exit?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mypre.edit().user().remove().apply();
                        mypre.edit().pass().remove().apply();
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

    /**
     * GET Text Checkbox of Uer
     *
     * @return String Text
     */
    private String getTextCheckBox() {
        String text = "";
        List<CheckBox> items = new ArrayList<>();
        items.add(cbkReadBook);
        items.add(ckPlaySoccer);
        items.add(chkListen_music);
        items.add(chkPlayGame);
        items.add(chkSwimming);
        items.add(chkPlayBasketball);
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

        if (rbgMale.isChecked()) {
            return rbgMale.getText().toString();
        } else {
            if (rbFemale.isChecked()) {
                return rbFemale.getText().toString();
            } else {
                return null;
            }
        }
    }
}
