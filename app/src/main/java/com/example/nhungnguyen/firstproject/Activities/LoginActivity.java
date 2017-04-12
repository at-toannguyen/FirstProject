package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.Interface.Mypre;
import com.example.nhungnguyen.firstproject.Interface.Mypre_;
import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.DefaultString;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.androidannotations.annotations.sharedpreferences.SharedPref;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {
    @Pref
    Mypre_ mypre;
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
        mypre.edit().user().put(edUser.getText().toString()).apply();
        mypre.edit().pass().put(edPass.getText().toString()).apply();
        RegisterActivity_.intent(this).start();
    }

    @Click(R.id.tvCra)
    void onCLickTv() {
        startActivity(new Intent(this, RegisterActivity_.class));
    }

    @AfterViews
    void init() {
        if (mypre.user().exists()) {
            startActivity(new Intent(this, RegisterActivity_.class));
            finish();
        }
    }

}
