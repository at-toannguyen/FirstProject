package com.example.nhungnguyen.firstproject.Adapters;

import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhungnguyen.firstproject.Models.UserItem;

import java.util.ArrayList;
import java.util.List;


public class TestAdapterViewpager extends PagerAdapter {
    private List<UserItem> mData=new ArrayList<>();

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        mData.set(position,mData.get(position));
        return super.instantiateItem(container, position);
    }
}
