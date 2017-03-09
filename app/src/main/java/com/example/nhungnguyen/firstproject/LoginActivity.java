package com.example.nhungnguyen.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mUser, mPass;
    private Button mBtnLg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUser =(EditText) findViewById(R.id.edUser);
        mPass =(EditText)findViewById(R.id.edPass);
        mBtnLg =(Button)findViewById(R.id.btnLogin);
        mBtnLg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "User: "+ mUser.getText().toString()+" \n Pass: "+ mPass.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
