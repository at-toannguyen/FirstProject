package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;

public class SharedReferencesActivity extends AppCompatActivity {
    private TextView mTvMess;
    private Button mBtnExit;
    private CheckBox c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_references);
        mTvMess=(TextView) findViewById(R.id.tvMess);
        mBtnExit=(Button) findViewById(R.id.btnOut);
        c=(CheckBox) findViewById(R.id.chkSave);
        mBtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent i=getIntent();
        mTvMess.setText("Chào tài khoản: "+i.getStringExtra("user"));
    }
}
