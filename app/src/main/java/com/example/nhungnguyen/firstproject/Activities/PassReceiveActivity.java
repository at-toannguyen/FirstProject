package com.example.nhungnguyen.firstproject.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;

public class PassReceiveActivity extends AppCompatActivity {
    private TextView mTvPassReceive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_receive);
        mTvPassReceive=(TextView) findViewById(R.id.tvPassReceive);
        mTvPassReceive.setText(getIntent().getStringExtra("from"));
    }
}
