package com.example.nhungnguyen.firstproject.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.example.nhungnguyen.firstproject.Fragment.RecyclerViewFragment;
import com.example.nhungnguyen.firstproject.R;


public class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {


    public ViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new RecyclerViewFragment();
    }

    @Override
    public int getCount() {
        return 1;
    }
}
