package com.example.nhungnguyen.firstproject.Activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_pass_receive)
public class PassReceiveActivity extends AppCompatActivity {
    @ViewById(R.id.tvPassReceive)
    TextView mTvPassReceive;
    @AfterViews
    void init(){
        mTvPassReceive.setText(getIntent().getStringExtra("from"));
    }
}
