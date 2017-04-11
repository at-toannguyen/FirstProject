package com.example.nhungnguyen.firstproject.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.LongClick;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_phone_call)
public class PhoneCallActivity extends AppCompatActivity {
    @ViewById(R.id.edtPhoneCall)
    EditText mEdtNumCall;
    @ViewById(R.id.tvNum0)
    TextView mTvNum0;
    @ViewById(R.id.tvNum1)
    TextView mTvNum1;
    @ViewById(R.id.tvNum2)
    TextView mTvNum2;
    @ViewById(R.id.tvNum3)
    TextView mTvNum3;
    @ViewById(R.id.tvNum4)
    TextView mTvNum4;
    @ViewById(R.id.tvNum5)
    TextView mTvNum5;
    @ViewById(R.id.tvNum6)
    TextView mTvNum6;
    @ViewById(R.id.tvNum7)
    TextView mTvNum7;
    @ViewById(R.id.tvNum8)
    TextView mTvNum8;
    @ViewById(R.id.tvNum9)
    TextView mTvNum9;
    @ViewById(R.id.tvSao)
    TextView mTvAsterisk;
    @ViewById(R.id.tvThang)
    TextView mTvPound;
    @Click(R.id.tvNum0)
    void onClickNum0() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum0.getText().toString());
    }
    @Click(R.id.tvNum1)
    void onClickNum1() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum1.getText().toString());
    }
    @Click(R.id.tvNum2)
    void onClickNum2() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum2.getText().toString());
    }
    @Click(R.id.tvNum3)
    void onClickNum3() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum3.getText().toString());
    }
    @Click(R.id.tvNum4)
    void onClickNum4() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum4.getText().toString());
    }
    @Click(R.id.tvNum5)
    void onClickNum5() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum5.getText().toString());
    }
    @Click(R.id.tvNum6)
    void onClickNum6() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum6.getText().toString());
    }
    @Click(R.id.tvNum7)
    void onClickNum7() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum7.getText().toString());
    }
    @Click(R.id.tvNum8)
    void onClickNum8() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum8.getText().toString());
    }
    @Click(R.id.tvNum9)
    void onClickNum9() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum9.getText().toString());
    }
    @Click(R.id.tvSao)
    void onClickSao() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvAsterisk.getText().toString());
    }
    @Click(R.id.tvThang)
    void onClickThang() {
        mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvPound.getText().toString());
    }
    @Click(R.id.imgDelNumber)
    void onCLickDel(){
        BaseInputConnection del = new BaseInputConnection(mEdtNumCall, true);
        del.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
    }
    @Click(R.id.imgCall)
    void onClickCall(){
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel: " + mEdtNumCall.getText().toString()));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
            return;
        }
        startActivity(call);
    }
    @LongClick(R.id.imgDelNumber)
    void onLongClickDel(){
        mEdtNumCall.getText().clear();
    }
    @AfterTextChange(R.id.edtPhoneCall)
    void textchange(){
        mEdtNumCall.setSelection(mEdtNumCall.getText().length());
    }
}
