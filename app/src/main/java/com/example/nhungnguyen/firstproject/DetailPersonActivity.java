package com.example.nhungnguyen.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailPersonActivity extends AppCompatActivity {
    private TextView mTvPerson,mTvAge,mTvContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);
        mTvPerson=(TextView) findViewById(R.id.tvDetail1);
        mTvAge=(TextView) findViewById(R.id.tvDetail2);
        mTvContent=(TextView) findViewById(R.id.tvDetail3);
        Bundle bundle=getIntent().getExtras();
        String person=bundle.getString("user");
        String age=bundle.getString("age");
        String content=bundle.getString("content");
        mTvPerson.setText(person);
        mTvAge.setText(age);
        mTvContent.setText(content);
    }
}
