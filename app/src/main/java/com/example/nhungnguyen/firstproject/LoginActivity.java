package com.example.nhungnguyen.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

// TODO: 3/9/17
public class LoginActivity extends AppCompatActivity {
    private EditText mUser, mPass;
    private Button mBtnLg;
    private TextView mTvCra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mUser =(EditText) findViewById(R.id.edUser);
        mPass =(EditText)findViewById(R.id.edPass);
        mBtnLg =(Button)findViewById(R.id.btnLogin);
        mTvCra=(TextView)findViewById(R.id.tvCra);
        mBtnLg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "User: "+ mUser.getText().toString()+" \n Pass: "+ mPass.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        mTvCra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }
}
