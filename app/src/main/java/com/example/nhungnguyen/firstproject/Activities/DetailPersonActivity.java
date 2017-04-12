package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.io.File;

@EActivity(R.layout.activity_detail_person)
public class DetailPersonActivity extends AppCompatActivity {

    @Extra
    UserItem mData;
    @Extra
    int mPosition;
    @ViewById(R.id.tvDetail1)
    TextView mTvPerson;
    @ViewById(R.id.tvDetail2)
    TextView mTvAge;
    @ViewById(R.id.tvDetail3)
    TextView mTvContent;
    @ViewById(R.id.imgFavoriteDetail)
    ImageView mFavorite;
    @ViewById(R.id.imgDetail)
    ImageView mImgPerson;
    @AfterViews
    void init(){
        mTvPerson.setText(mData.getTvUser());
        mTvAge.setText(mData.getTvAge());
        mTvContent.setText(mData.getTvContent());
        if (!TextUtils.isEmpty(mData.getImgPerson())) {
            Picasso.with(this).load(new File(mData.getImgPerson())).centerCrop().fit().error(R.drawable.img_person1).into(mImgPerson);
        }
        mFavorite.setSelected(mData.isFavorite());
    }
    @Click(R.id.imgFavoriteDetail)
    void onClickFavoriteDetail(){
        mFavorite.setSelected(!mData.isFavorite());
        mData.setFavorite(!mData.isFavorite());
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("favor", mData);
        i.putExtra("positionFavorite", mPosition);
        Log.d("pos", "onBackPressed: "+mData.isFavorite());
        setResult(RESULT_OK, i);
        finish();
    }
}
