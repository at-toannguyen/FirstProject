package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;
import com.squareup.picasso.Picasso;


public class DetailPersonActivity extends AppCompatActivity {
    private TextView mTvPerson;
    private TextView mTvAge;
    private TextView mTvContent;
    private ImageView mFavorite;
    private ImageView mImgPerson;
    private UserItem mData;
    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_person);
        init();
        Bundle bundle = getIntent().getExtras();
        mData = bundle.getParcelable("para");
        mPosition = bundle.getInt("position");
        mTvPerson.setText(mData.getTvUser());
        mTvAge.setText(mData.getTvAge());
        mTvContent.setText(mData.getTvContent());
//        mImgPerson.setBackgroundResource(mData.getImgPerson());
        Picasso.with(this).load(mData.getImgPerson()).into(mImgPerson);
        mFavorite.setSelected(mData.isFavorite());

        mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFavorite.setSelected(!mData.isFavorite());
                mData.setFavorite(!mData.isFavorite());

            }
        });
    }

    private void init() {
        mTvPerson = (TextView) findViewById(R.id.tvDetail1);
        mTvAge = (TextView) findViewById(R.id.tvDetail2);
        mTvContent = (TextView) findViewById(R.id.tvDetail3);
        mFavorite = (ImageView) findViewById(R.id.imgFavoriteDetail);
        mImgPerson = (ImageView) findViewById(R.id.imgDetail);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("favor", mData);
        i.putExtra("positionFavorite", mPosition);
        setResult(RESULT_OK, i);
        finish();
    }
}
