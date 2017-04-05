package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.example.nhungnguyen.firstproject.R;

// TODO: 3/9/17  
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnTest1;
    private Button mBtnTest2;
    private Button mBtnTest3;
    private Button mBtnTest4;
    private Button mBtnTest5;
    private Button mBtnTest6;
    private Button mBtnTest7;
    private Button mBtnTest8;
    private Button mBtnTest9;
    private Button mBtnTest10;
    private Button mBtnTest11;
    private Button mBtnTest12;
    private Button mBtnTest13;
    private static final String TEST="com.example.nhungnguyen.firstproject.TestSendData";
    private static final String TEST1="com.example.nhungnguyen.firstproject.Receive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
        setOnClick();
    }

    private void initVariable() {
        mBtnTest1 = (Button) findViewById(R.id.btnTest1);
        mBtnTest2 = (Button) findViewById(R.id.btnTest2);
        mBtnTest3 = (Button) findViewById(R.id.btnTest3);
        mBtnTest4 = (Button) findViewById(R.id.btnTest4);
        mBtnTest5 = (Button) findViewById(R.id.btnTest5);
        mBtnTest6 = (Button) findViewById(R.id.btnTest6);
        mBtnTest7 = (Button) findViewById(R.id.btnTest7);
        mBtnTest8 = (Button) findViewById(R.id.btnSendData);
        mBtnTest9 = (Button) findViewById(R.id.btnSendReceive);
        mBtnTest10 = (Button) findViewById(R.id.btnTest10);
        mBtnTest11 = (Button) findViewById(R.id.btnGGMap);
        mBtnTest12 = (Button) findViewById(R.id.btnAsync);
        mBtnTest13 = (Button) findViewById(R.id.btnAPI);
    }

    private void setOnClick() {
        mBtnTest1.setOnClickListener(this);
        mBtnTest2.setOnClickListener(this);
        mBtnTest3.setOnClickListener(this);
        mBtnTest4.setOnClickListener(this);
        mBtnTest5.setOnClickListener(this);
        mBtnTest6.setOnClickListener(this);
        mBtnTest7.setOnClickListener(this);
        mBtnTest8.setOnClickListener(this);
        mBtnTest9.setOnClickListener(this);
        mBtnTest10.setOnClickListener(this);
        mBtnTest11.setOnClickListener(this);
        mBtnTest12.setOnClickListener(this);
        mBtnTest13.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnTest1:
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                break;
            case R.id.btnTest2:
                startActivity(new Intent(MainActivity.this, TestLayoutActivity.class));
                break;
            case R.id.btnTest3:
                startActivity(new Intent(MainActivity.this, PhoneCallActivity.class));
                break;
            case R.id.btnTest4:
                startActivity(new Intent(MainActivity.this, ItentActivity.class));
                break;
            case R.id.btnTest5:
                startActivity(new Intent(MainActivity.this, TestFragmentActivity.class));
                break;
            case R.id.btnTest6:
                startActivity(new Intent(MainActivity.this, TestFragmentViewPagerActivity.class));
                break;
            case R.id.btnTest7:
                startActivity(new Intent(this, BroadcastActivity111.class));
                break;
            case R.id.btnSendData:
                Intent intent=new Intent();
                intent.setAction(TEST);
                intent.putExtra("testing","Hello");
                sendBroadcast(intent);
                break;
            case R.id.btnSendReceive:
                Intent intent1=new Intent();
                intent1.setAction(TEST1);
                intent1.putExtra("send","Send success");
                sendBroadcast(intent1);
                break;
            case R.id.btnTest10:
                startActivity(new Intent(this,TestDay19Activity.class));
                break;
            case R.id.btnGGMap:
                startActivity(new Intent(this,GGMapActivity.class));
                break;
            case  R.id.btnAsync:
                startActivity(new Intent(this,AsyncTaskActivity.class));
                break;
            case R.id.btnAPI:
                startActivity(new Intent(this,APIActivity.class));
                break;
        }
    }
}
