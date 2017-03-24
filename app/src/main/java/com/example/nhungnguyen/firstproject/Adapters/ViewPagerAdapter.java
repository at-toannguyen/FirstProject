package com.example.nhungnguyen.firstproject.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nhungnguyen.firstproject.Fragment.RecyclerViewFragment;
import com.example.nhungnguyen.firstproject.Fragment.Test1Fragment;
import com.example.nhungnguyen.firstproject.Fragment.Test3Fragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Test1Fragment();
            case 1:
                return new RecyclerViewFragment();
            case 2:
                return new Test3Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
