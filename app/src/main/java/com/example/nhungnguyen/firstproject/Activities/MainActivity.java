package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    private static final String TEST = "com.example.nhungnguyen.firstproject.TestSendData";
    private static final String TEST1 = "com.example.nhungnguyen.firstproject.Receive";
    @Click(R.id.btnTest1)
    void onClickBtn1() {
        startActivity(new Intent(MainActivity.this, LoginActivity_.class));
    }

    @Click(R.id.btnTest2)
    void onClickBtn2() {
        startActivity(new Intent(MainActivity.this, TestLayoutActivity_.class));
    }

    @Click(R.id.btnTest3)
    void onClickBtn3() {
        startActivity(new Intent(MainActivity.this, PhoneCallActivity_.class));
    }

    @Click(R.id.btnTest4)
    void onClickBtn4() {
        startActivity(new Intent(MainActivity.this, ItentActivity_.class));
    }

    @Click(R.id.btnTest5)
    void onClickBtn5() {
        startActivity(new Intent(MainActivity.this, TestFragmentActivity_.class));
    }

    @Click(R.id.btnTest6)
    void onClickBtn6() {
        startActivity(new Intent(MainActivity.this, TestFragmentViewPagerActivity_.class));
    }

    @Click(R.id.btnTest7)
    void onClickBtn7() {
        startActivity(new Intent(this, BroadcastActivity111_.class));
    }

    @Click(R.id.btnSendData)
    void onClickBtnSendData() {
        Intent intent = new Intent();
        intent.setAction(TEST);
        intent.putExtra("testing", "Hello");
        sendBroadcast(intent);
    }

    @Click(R.id.btnSendReceive)
    void onClickBtnSendReceive() {
        Intent intent1 = new Intent();
        intent1.setAction(TEST1);
        intent1.putExtra("send", "Send success");
        sendBroadcast(intent1);
    }

    @Click(R.id.btnTest10)
    void onClickBtn10() {
        startActivity(new Intent(this, TestDay19Activity_.class));
    }

    @Click(R.id.btnGGMap)
    void onClickBtnGGMap() {
        startActivity(new Intent(this, GGMapActivity_.class));
    }

    @Click(R.id.btnAsync)
    void onClickBtnAsync() {
        startActivity(new Intent(this, AsyncTaskActivity_.class));
    }

    @Click(R.id.btnAPI)
    void onClickBtnAPI() {
        startActivity(new Intent(this, APIActivity_.class));
    }
}
