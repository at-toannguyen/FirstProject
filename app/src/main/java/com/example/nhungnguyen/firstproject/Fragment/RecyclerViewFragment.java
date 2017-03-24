package com.example.nhungnguyen.firstproject.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ProgressBar;

import com.example.nhungnguyen.firstproject.Activities.DetailPersonActivity;
import com.example.nhungnguyen.firstproject.Adapters.TestLayoutRecyclerAdapter;
import com.example.nhungnguyen.firstproject.Models.ItemList;
import com.example.nhungnguyen.firstproject.Models.TitleItem;
import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment implements TestLayoutRecyclerAdapter.onItemClickListener {
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mRecyclerView;
    private TestLayoutRecyclerAdapter mAdapter;
    private final List<ItemList> mData = new ArrayList<>();
    private final android.os.Handler mHandler = new android.os.Handler();
    private ProgressBar mProgressBar;
    private static final String URL = "http://hinhnendepnhat.net/wp-content/uploads/2016/09/hinh-nen-girl-dep.jpg";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recyclerview_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycleViewPersonalFrgm);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBarUserFrgm);
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
            if (i % 3 == 0 || i == 1) {
                mData.add(new TitleItem("Group A"));
            } else {
                if (i % 5 == 0) {
                    mData.add(new TitleItem("Group B"));
                }
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
                                if (i % 3 == 0 || i == 1) {
                                    mData.add(new TitleItem("Group A"));
                                } else {
                                    if (i % 5 == 0) {
                                        mData.add(new TitleItem("Group B"));
                                    }
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
        Bundle b = new Bundle();
        b.putInt("position", position);
        Intent i = new Intent(getActivity(), DetailPersonActivity.class);
        b.putParcelable("para", mData.get(position));
        i.putExtras(b);
        getActivity().startActivityForResult(i, 3);
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
