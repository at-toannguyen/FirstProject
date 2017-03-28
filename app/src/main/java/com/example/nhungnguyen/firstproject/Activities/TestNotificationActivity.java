package com.example.nhungnguyen.firstproject.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;

public class TestNotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_notification);
        TextView tvTest = (TextView) findViewById(R.id.tvTest1);
        String bundle = getIntent().getStringExtra("data");
        tvTest.setText("Note: " + bundle);
    }
}
