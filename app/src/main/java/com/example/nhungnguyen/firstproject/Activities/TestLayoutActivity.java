package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.nhungnguyen.firstproject.Adapters.TestLayoutRecyclerAdapter;
import com.example.nhungnguyen.firstproject.Models.ItemList;
import com.example.nhungnguyen.firstproject.Models.TitleItem;
import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;

import java.util.ArrayList;
import java.util.List;

public class TestLayoutActivity extends AppCompatActivity implements TestLayoutRecyclerAdapter.onItemClickListner {
    private RecyclerView mRecyclerViewTestLayout;
    private List<ItemList> mData;
    private ImageView imgBack;
    private TestLayoutRecyclerAdapter mTestLayoutRecyclerAdapter;
    private android.os.Handler mHandler;
    private LinearLayoutManager mLayoutManager;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mData = new ArrayList<>();
        //---------
        mHandler = new android.os.Handler();
        //----------
        mRecyclerViewTestLayout = (RecyclerView) findViewById(R.id.recycleViewPersonal);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBarUser);
        mTestLayoutRecyclerAdapter = new TestLayoutRecyclerAdapter(mData, this);
        createData();
        mRecyclerViewTestLayout.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewTestLayout.setLayoutManager(mLayoutManager);
        mRecyclerViewTestLayout.setAdapter(mTestLayoutRecyclerAdapter);
        //----------
        imgBack = (ImageView) findViewById(R.id.imgBack);

        //-------------
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
                int mLastVisibleItem = mLayoutManager.findLastCompletelyVisibleItemPosition();
                if (mLastVisibleItem == mData.size() - 1) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("131", "run: ");
                            int start = mData.size();
                            int end = start + 20;
                            String person = "";
                            String age = "";
                            String content = "";
                            for (int i = start + 1; i < end; i++) {
                                person = "person " + i;
                                age = "Age: " + i;
                                if (i % 2 == 0) {
                                    content = "Hello";
                                } else {
                                    content = "Hi";
                                }
                                if (i%3==0 || i==1 ){
                                    mData.add(new TitleItem("Group A"));
                                }else {if (i%5==0){
                                    mData.add(new TitleItem("Group B"));
                                }
                                }
                                mData.add(new UserItem(person, age, content,R.drawable.img_person_male));
                            }
                            mTestLayoutRecyclerAdapter.notifyItemInserted(mData.size());
                            mProgressBar.setVisibility(View.GONE);
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
        String person = "";
        String age = "";
        String content = "";
        for (int i = 1; i <= 20; i++) {
            person = "person " + i;
            age = "Age: " + i;
            if (i % 2 == 0) {
                content = "Hello";
            } else {
                content = "Hi";
            }
            if (i%3==0 || i==1 ){
                mData.add(new TitleItem("Group A"));
            }else {if (i%5==0){
                mData.add(new TitleItem("Group B"));
            }
            }
            mData.add(new UserItem(person, age, content,R.drawable.img_person_male));
        }

        mTestLayoutRecyclerAdapter.notifyDataSetChanged();
    }


    @Override
    public void onItemClick(int poisision) {
        Bundle b = new Bundle();
        b.putInt("poin", poisision);
        Intent i = new Intent(TestLayoutActivity.this, DetailPersonActivity.class);
        b.putParcelable("para", mData.get(poisision));
        i.putExtras(b);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Log.d("result", "onActivityResult: ");
                UserItem test = data.getParcelableExtra("favor");

                int poisision = data.getIntExtra("poinfavor", -1);
                Log.d("poi", "onActivityResult: " + poisision);
                if (poisision != -1) {
                    mData.set(poisision, test);
                    mTestLayoutRecyclerAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}