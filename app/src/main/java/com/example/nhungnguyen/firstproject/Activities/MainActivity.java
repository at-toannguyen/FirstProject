package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.example.nhungnguyen.firstproject.R;

// TODO: 3/9/17  
public class MainActivity extends AppCompatActivity {
    //Khai bao bien
    private Button mBtnTest1,mBtnTest2,mBtnTest3,mBtnTest4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTest1=(Button)findViewById(R.id.btnTest1);
        mBtnTest2=(Button)findViewById(R.id.btnTest2);
        mBtnTest3=(Button)findViewById(R.id.btnTest3);
        mBtnTest4=(Button) findViewById(R.id.btnTest4);
        mBtnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
        mBtnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,TestLayoutActivity.class);
                startActivity(i);
            }
        });
        mBtnTest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,PhoneCallActivity.class));
            }
        });
        mBtnTest4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ItentActivity.class));
            }
        });
    }
}
