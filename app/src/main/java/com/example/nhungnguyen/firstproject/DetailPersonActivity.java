package com.example.nhungnguyen.firstproject;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailPersonActivity extends AppCompatActivity {
    private TextView mTvPerson,mTvAge,mTvContent;
    private ImageView mfavorite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);
        mTvPerson=(TextView) findViewById(R.id.tvDetail1);
        mTvAge=(TextView) findViewById(R.id.tvDetail2);
        mTvContent=(TextView) findViewById(R.id.tvDetail3);
        mfavorite=(ImageView)findViewById(R.id.imgFavorite);
        DataItemTestLayout data=getIntent().getBundleExtra("key").getParcelable("para");
        mTvPerson.setText(data.getTvUser());
        mTvAge.setText(data.getTvAge());
        mTvContent.setText(data.getTvContent());
        mfavorite.setBackgroundResource(data.getFavorite());
    }
}
