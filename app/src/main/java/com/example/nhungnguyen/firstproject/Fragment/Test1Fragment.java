package com.example.nhungnguyen.firstproject.Fragment;


import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.nhungnguyen.firstproject.Adapters.TestAdapterViewpager;
import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;

import java.util.ArrayList;
import java.util.List;


public class Test1Fragment extends android.support.v4.app.Fragment {
    private List<UserItem> mData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test1_fragment, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.vPagerTest);
        mData = loadData();
        TestAdapterViewpager mAdapter = new TestAdapterViewpager(view.getContext(), mData);
        viewPager.setAdapter(mAdapter);
        return view;
    }

    private List<UserItem> loadData() {
        String id;
        String name;
        String age;
        String content;
        for (int i = 1; i <= 20; i++) {
            id = "" + i;
            name = "person " + i;
            age = "Age: " + i;
            if (i % 2 == 0) {
                content = "Hello";
            } else {
                content = "Hi";
            }
            String URL = "http://hinhnendepnhat.net/wp-content/uploads/2016/09/hinh-nen-girl-dep.jpg";
            mData.add(new UserItem(id, name, age, content, URL));
        }
        return mData;
    }

}
