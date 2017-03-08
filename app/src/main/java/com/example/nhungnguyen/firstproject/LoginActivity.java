package com.example.nhungnguyen.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText user,pass;
    Button lgbt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user=(EditText) findViewById(R.id.user);
        pass=(EditText)findViewById(R.id.pass);
        lgbt=(Button)findViewById(R.id.login);
        lgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "User: "+user.getText().toString()+" \n Pass: "+pass.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
