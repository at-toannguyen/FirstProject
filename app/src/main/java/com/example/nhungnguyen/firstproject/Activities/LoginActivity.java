package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {
    @ViewById
    EditText edUser;
    @ViewById
    EditText edPass;
    @ViewById
    Button btnLogin;
    @ViewById
    TextView tvCra;

    @Click(R.id.btnLogin)
    void setClickBtn() {
        if (edUser.getText().toString().equalsIgnoreCase("abcd") && edPass.getText().toString().equalsIgnoreCase("1234")) {
            SharedPreferences preferences = getSharedPreferences("mydata", MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("user", edUser.getText().toString());
            editor.putString("pass", edPass.getText().toString());
            editor.commit();
            startActivity(new Intent(this, RegisterActivity_.class));
            finish();
        }
    }

    @Click(R.id.tvCra)
    void onCLickTv() {
        startActivity(new Intent(this, RegisterActivity_.class));
    }

    @AfterViews
    void init() {
        boolean rs = checkLogin();
        if (rs) {
            startActivity(new Intent(this, RegisterActivity_.class));
            finish();
        }
    }

    private boolean checkLogin() {
        boolean rs = false;
        SharedPreferences share = getSharedPreferences("mydata", MODE_PRIVATE);
        //Lấy chuỗi String trong file SharedPreferences thông qua tên URName và URPass
        String name = share.getString("user", "");
        String pass = share.getString("pass", "");
        if (name.equalsIgnoreCase("abcd") && pass.equalsIgnoreCase("1234")) {
            rs = true;
        }
        return rs;
    }
}
