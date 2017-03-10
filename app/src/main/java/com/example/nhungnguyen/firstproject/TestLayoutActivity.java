package com.example.nhungnguyen.firstproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nhungnguyen.firstproject.Adapter.TestLayoutRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

// TODO: 3/9/17
public class TestLayoutActivity extends AppCompatActivity {
    private Context mContext;
    private RecyclerView mRecyclerViewTestLayout;
    private List<DataItemTestLayout> mData = new ArrayList<>();
    private ImageView imgBack;
    private TestLayoutRecyclerAdapter mTestLayoutRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
        mRecyclerViewTestLayout = (RecyclerView) findViewById(R.id.recycleViewPersonal);
        mTestLayoutRecyclerAdapter = new TestLayoutRecyclerAdapter(createData());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerViewTestLayout.setLayoutManager(layoutManager);
        mRecyclerViewTestLayout.setAdapter(mTestLayoutRecyclerAdapter);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**Create Data for RecycleView
     *
     * @return Data
     */
    private List<DataItemTestLayout> createData() {
        mData.add(new DataItemTestLayout("sdfqweqwe", "dfsqweqwe", "fafqweqwe", getResources().getDrawable(R.mipmap.img_person)));
        mData.add(new DataItemTestLayout("sdfqweqwe", "dfsqweqwe", "fafqweqwe", getResources().getDrawable(R.mipmap.img_person)));
        mData.add(new DataItemTestLayout("sdfqweqwe", "dfsqweqwe", "fafqweqwe", getResources().getDrawable(R.mipmap.img_person)));
        mData.add(new DataItemTestLayout("sdfqweqwe", "dfsqweqwe", "fafqweqwe", getResources().getDrawable(R.mipmap.img_person)));
        mData.add(new DataItemTestLayout("sdfqweqwe", "dfsqweqwe", "fafqweqwe", getResources().getDrawable(R.mipmap.img_person)));
        mData.add(new DataItemTestLayout("sdfqweqwe", "dfsqweqwe", "fafqweqwe", getResources().getDrawable(R.mipmap.img_person)));
        mData.add(new DataItemTestLayout("sdfqweqwe", "dfsqweqwe", "fafqweqwe", getResources().getDrawable(R.mipmap.img_person)));
        mData.add(new DataItemTestLayout("sdfqweqwe", "dfsqweqwe", "fafqweqwe", getResources().getDrawable(R.mipmap.img_person)));
        return mData;
    }
}
