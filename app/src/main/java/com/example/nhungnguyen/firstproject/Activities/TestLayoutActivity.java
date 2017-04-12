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
import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;
import com.example.nhungnguyen.firstproject.SQLite.DataBaseHelper;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_user)
public class TestLayoutActivity extends AppCompatActivity implements TestLayoutRecyclerAdapter.onItemClickListener {
    private List<ItemList> mData;
    private TestLayoutRecyclerAdapter mTestLayoutRecyclerAdapter;
    private LinearLayoutManager mLayoutManager;
    private DataBaseHelper mDataBaseHealper;
    private static final String URL = "https://www.shareicon.net/data/48x48/2015/09/18/103158_user_512x512.png";
    private static final int REQUESTCODE1 = 1;
    private static final int REQUESTCODE2 = 2;


    @ViewById(R.id.recycleViewPersonal)
    RecyclerView mRecyclerViewTestLayout;

    @Click(R.id.imgBack)
    void onClickBack() {
        finish();
    }

    @Click(R.id.imgAdd)
    void onClickAddUser() {
        ChangeDbActivity_.intent(this).key("String").start();
    }

    @AfterViews
    void init() {
        mData = new ArrayList<>();
        mTestLayoutRecyclerAdapter = new TestLayoutRecyclerAdapter(mData, this, this);
        mRecyclerViewTestLayout.setAdapter(mTestLayoutRecyclerAdapter);
        mDataBaseHealper = new DataBaseHelper(this);
        mData.addAll(mDataBaseHealper.getAllUsers());
        mTestLayoutRecyclerAdapter.notifyDataSetChanged();
        mRecyclerViewTestLayout.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerViewTestLayout.setLayoutManager(mLayoutManager);
    }

    @Override
    public void onItemClick(int position) {
        DetailPersonActivity_.intent(this).mPosition(position)
                .mData((UserItem) mData.get(position))
                .startForResult(REQUESTCODE1);
    }

    @Override
    public void onItemLongClick(int position) {
        ChangeDbActivity_.intent(this)
                .key(String.valueOf(position))
                .mData((UserItem) mData.get(position))
                .startForResult(REQUESTCODE2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUESTCODE1) {
            if (resultCode == RESULT_OK) {
                Log.d("result", "onActivityResult: ");
                UserItem test = data.getParcelableExtra("favor");

                int position = data.getIntExtra("positionFavorite", -1);
                Log.d("poi", "onActivityResult: " + position);
                if (position != -1) {
                    mData.set(position, test);
                    mTestLayoutRecyclerAdapter.notifyDataSetChanged();
                }
            }
        }
        if (requestCode == REQUESTCODE2) {
            if (resultCode == RESULT_OK) {
                UserItem changeDB = data.getParcelableExtra("db");
                int poisition1 = data.getIntExtra("poisitiondb", -1);
                mData.set(poisition1, changeDB);
                mData = mDataBaseHealper.getAllUsers();
                mRecyclerViewTestLayout.setAdapter(new TestLayoutRecyclerAdapter(mData, this, this));
                mTestLayoutRecyclerAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mData = mDataBaseHealper.getAllUsers();
        mRecyclerViewTestLayout.setAdapter(new TestLayoutRecyclerAdapter(mData, this, this));
        mTestLayoutRecyclerAdapter.notifyDataSetChanged();
    }
}
