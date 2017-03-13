package com.example.nhungnguyen.firstproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nhungnguyen.firstproject.Adapter.TestLayoutRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

// TODO: 3/9/17
public class TestLayoutActivity extends AppCompatActivity implements TestLayoutRecyclerAdapter.onItemClickListner {
    private Context mContext;
    private RecyclerView mRecyclerViewTestLayout;
    private List<DataItemTestLayout> mData = new ArrayList<>();
    private ImageView imgBack, favorite;
    private TestLayoutRecyclerAdapter mTestLayoutRecyclerAdapter;
    private android.os.Handler mHandler;
    private LinearLayoutManager mLayoutManager;
    private boolean mIsLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
        //---------
        mHandler = new android.os.Handler();
        //----------
        mRecyclerViewTestLayout = (RecyclerView) findViewById(R.id.recycleViewPersonal);
        mTestLayoutRecyclerAdapter = new TestLayoutRecyclerAdapter(mData, this, this, mRecyclerViewTestLayout);
        createData();

        mRecyclerViewTestLayout.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewTestLayout.setLayoutManager(mLayoutManager);
        mRecyclerViewTestLayout.setAdapter(mTestLayoutRecyclerAdapter);
        mTestLayoutRecyclerAdapter.notifyDataSetChanged();
        //----------
        imgBack = (ImageView) findViewById(R.id.imgBack);
        //--------------
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRecyclerViewTestLayout.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastPos = mLayoutManager.findLastCompletelyVisibleItemPosition();
                if (lastPos == mData.size() - 1) {
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("131", "run: ");
                            // remove progress item
                            if (mIsLoading) {
                                return;
                            }
                            createData();
                        }
                    }, 3000);
                }
            }
        });
    }
    /**
     * Create Data for RecycleView
     *
     * @return Data
     */
    private void createData() {
        mIsLoading = true;
        String person = "";
        String age = "";
        String content = "";
        ImageView favor;
        for (int i = 1; i <= 20; i++) {
            person = "person " + i;
            age = "Age: " + i;
            if (i % 2 == 0) {
                content = "Hello";
            } else {
                content = "Hi";
            }
            mData.add(new DataItemTestLayout(person, age, content));
        }
        mTestLayoutRecyclerAdapter.notifyDataSetChanged();
        mIsLoading = false;
    }


    @Override
    public void onItemClick(int poisision, DataItemTestLayout ob) {
        Bundle b = new Bundle();
        Intent i = new Intent(TestLayoutActivity.this, DetailPersonActivity.class);
        b.putParcelable("para", ob);
        i.putExtra("key", b);
//        i.putExtra("age",age);
//        i.putExtra("content",content);
        startActivity(i);
    }
}
