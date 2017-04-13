package com.example.nhungnguyen.firstproject.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


import com.example.nhungnguyen.firstproject.Activities.DetailPersonActivity_;
import com.example.nhungnguyen.firstproject.Adapters.TestLayoutRecyclerAdapter;
import com.example.nhungnguyen.firstproject.Models.ItemList;

import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;
@EFragment(R.layout.fragment_recyclerview_layout)
public class RecyclerViewFragment extends Fragment implements TestLayoutRecyclerAdapter.onItemClickListener {
    private LinearLayoutManager mLinearLayoutManager;
    private TestLayoutRecyclerAdapter mAdapter;
    private final List<ItemList> mData = new ArrayList<>();
    private final android.os.Handler mHandler = new android.os.Handler();
    private static final String URL = "http://hinhnendepnhat.net/wp-content/uploads/2016/09/hinh-nen-girl-dep.jpg";
    private static final int REQUESTCODE=3;
    @ViewById(R.id.recycleViewPersonalFrgm)
    RecyclerView mRecyclerView;
    @ViewById(R.id.progressBarUserFrgm)
    ProgressBar mProgressBar;
    @AfterViews
    void init(){
        mRecyclerView.setHasFixedSize(true);
        mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        createData();
        mAdapter = new TestLayoutRecyclerAdapter(mData, this, getActivity());
        mRecyclerView.setAdapter(mAdapter);
        loadMore();
    }

    private void createData() {
        String id;
        String person;
        String age;
        String content;
        for (int i = 1; i <= 20; i++) {
            id = "" + i;
            person = "person " + i;
            age = "Age: " + i;
            if (i % 2 == 0) {
                content = "Hello";
            } else {
                content = "Hi";
            }

            mData.add(new UserItem(id, person, age, content, URL));
        }

    }

    private void loadMore() {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int mLastVisibleItem = mLinearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (mLastVisibleItem == mData.size() - 1) {
                    mProgressBar.setVisibility(View.VISIBLE);
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("131", "run: ");
                            int start = mData.size();
                            int end = start + 20;
                            String id;
                            String person;
                            String age;
                            String content;
                            for (int i = start + 1; i <= end; i++) {
                                id = "" + i;
                                person = "person " + i;
                                age = "Age: " + i;
                                if (i % 2 == 0) {
                                    content = "Hello";
                                } else {
                                    content = "Hi";
                                }
                                mData.add(new UserItem(id, person, age, content, URL));
                            }
                            mAdapter.notifyItemInserted(mData.size());
                            mProgressBar.setVisibility(View.GONE);
                            mAdapter.notifyDataSetChanged();
                        }

                    }, 3000);
                }
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        DetailPersonActivity_.intent(getContext()).mPosition(position).mData((UserItem) mData.get(position)).startForResult(REQUESTCODE);
        }



    @Override
    public void onItemLongClick(int position) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 3) {
            if (resultCode == Activity.RESULT_OK) {
                Log.d("result", "onActivityResult: ");
                UserItem test = data.getParcelableExtra("favor");

                int position = data.getIntExtra("positionFavorite", -1);
                Log.d("poi", "onActivityResult: " + position);
                if (position != -1) {
                    mData.set(position, test);
                    mAdapter.notifyDataSetChanged();
                }
            }
        }
    }

}
