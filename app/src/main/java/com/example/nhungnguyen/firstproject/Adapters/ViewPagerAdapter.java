package com.example.nhungnguyen.firstproject.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nhungnguyen.firstproject.Fragment.Test1Fragment;
import com.example.nhungnguyen.firstproject.Fragment.Test2Fragment;
import com.example.nhungnguyen.firstproject.Fragment.Test3Fragment;



public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String tab[]=new String[]{"tab1","tab2","tab3"};
//    private int tab[]=new int[]{R.drawable.ic_favorite_brown_300_18dp,R.drawable.ic_home,R.drawable.ic_lock_brown_300_18dp};
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Test1Fragment();
            case 1:
                return new Test2Fragment();
            case 2:
                return new Test3Fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tab[position];
    }
}
