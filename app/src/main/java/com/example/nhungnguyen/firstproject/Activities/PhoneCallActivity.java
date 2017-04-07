package com.example.nhungnguyen.firstproject.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;

public class PhoneCallActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTvNum1;
    private TextView mTvNum2;
    private TextView mTvNum3;
    private TextView mTvNum4;
    private TextView mTvNum5;
    private TextView mTvNum6;
    private TextView mTvNum7;
    private TextView mTvNum8;
    private TextView mTvNum9;
    private TextView mTvNum0;
    private TextView mTvAsterisk;
    private TextView mTvPound;
    private ImageView mImgCall;
    private ImageView mImgDel;
    private EditText mEdtNumCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_call);
        initVariable();
        setOnClick();
        mImgDel.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mEdtNumCall.getText().clear();
                return true;
            }
        });
        mEdtNumCall.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mEdtNumCall.setSelection(mEdtNumCall.getText().length());
            }
        });
    }

    private void initVariable() {
        mTvNum1 = (TextView) findViewById(R.id.tvNum1);
        mTvNum2 = (TextView) findViewById(R.id.tvNum2);
        mTvNum3 = (TextView) findViewById(R.id.tvNum3);
        mTvNum4 = (TextView) findViewById(R.id.tvNum4);
        mTvNum5 = (TextView) findViewById(R.id.tvNum5);
        mTvNum6 = (TextView) findViewById(R.id.tvNum6);
        mTvNum7 = (TextView) findViewById(R.id.tvNum7);
        mTvNum8 = (TextView) findViewById(R.id.tvNum8);
        mTvNum9 = (TextView) findViewById(R.id.tvNum9);
        mTvNum0 = (TextView) findViewById(R.id.tvNum0);
        mTvAsterisk = (TextView) findViewById(R.id.tvSao);
        mTvPound = (TextView) findViewById(R.id.tvThang);
        mImgCall = (ImageView) findViewById(R.id.imgCall);
        mImgDel = (ImageView) findViewById(R.id.imgDelNumber);
        mEdtNumCall = (EditText) findViewById(R.id.edtPhoneCall);
    }

    private void setOnClick() {
        mTvNum0.setOnClickListener(this);
        mTvNum1.setOnClickListener(this);
        mTvNum2.setOnClickListener(this);
        mTvNum3.setOnClickListener(this);
        mTvNum4.setOnClickListener(this);
        mTvNum5.setOnClickListener(this);
        mTvNum6.setOnClickListener(this);
        mTvNum7.setOnClickListener(this);
        mTvNum8.setOnClickListener(this);
        mTvNum9.setOnClickListener(this);
        mTvAsterisk.setOnClickListener(this);
        mTvPound.setOnClickListener(this);
        mImgDel.setOnClickListener(this);
        mImgCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvNum0:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum0.getText().toString());
                break;
            case R.id.tvNum1:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum1.getText().toString());
                break;
            case R.id.tvNum2:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum2.getText().toString());
                break;
            case R.id.tvNum3:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum3.getText().toString());
                break;
            case R.id.tvNum4:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum4.getText().toString());
                break;
            case R.id.tvNum5:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum5.getText().toString());
                break;
            case R.id.tvNum6:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum6.getText().toString());
                break;
            case R.id.tvNum7:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum7.getText().toString());
                break;
            case R.id.tvNum8:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum8.getText().toString());
                break;
            case R.id.tvNum9:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvNum9.getText().toString());
                break;
            case R.id.tvSao:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvAsterisk.getText().toString());
                break;
            case R.id.tvThang:
                mEdtNumCall.setText(mEdtNumCall.getText().toString() + mTvPound.getText().toString());
                break;
            case R.id.imgDelNumber:
                BaseInputConnection del = new BaseInputConnection(mEdtNumCall, true);
                del.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.imgCall:
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " + mEdtNumCall.getText().toString()));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                    return;
                }
                startActivity(call);
        }
    }
}
