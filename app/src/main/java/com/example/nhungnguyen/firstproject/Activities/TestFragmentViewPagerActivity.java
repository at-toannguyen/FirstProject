package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import android.support.v4.view.ViewPager;

import com.example.nhungnguyen.firstproject.Adapters.ViewPagerAdapter;
import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.PageSelected;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_test_fragment)
public class TestFragmentViewPagerActivity extends FragmentActivity implements TabLayout.OnTabSelectedListener {
    @ViewById(R.id.vPager)
    ViewPager mViewPager;
    @ViewById(R.id.tabs)
    TabLayout mTabs;
     TabLayout.Tab tab1 ;
     TabLayout.Tab tab2;
     TabLayout.Tab tab3 ;
    @AfterViews
    void init() {
        mTabs.setOnTabSelectedListener(this);
        mTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);
        tab1=mTabs.newTab();
        tab2=mTabs.newTab();
        tab3=mTabs.newTab();
        tab1.setIcon(R.drawable.ic_home_red);
        tab1.setText("Home");
        tab2.setIcon(R.drawable.ic_favorite_brown_300_18dp);
        tab2.setText("Favorite");
        tab3.setIcon(R.drawable.ic_lock_brown_300_18dp);
        tab3.setText("Personal");
        mTabs.addTab(tab1);
        mTabs.addTab(tab2);
        mTabs.addTab(tab3);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabs));
    }
    @PageSelected(R.id.vPager)
    void onPageSelected(int position) {
        switch (position) {
            case 0:
                tab1.setIcon(R.drawable.ic_home_red);
                tab2.setIcon(R.drawable.ic_favorite_brown_300_18dp);
                tab3.setIcon(R.drawable.ic_lock_brown_300_18dp);
                break;
            case 1:
                tab2.setIcon(R.drawable.ic_favorite_red);
                tab3.setIcon(R.drawable.ic_lock_brown_300_18dp);
                tab1.setIcon(R.drawable.ic_home);
                break;
            case 2:
                tab3.setIcon(R.drawable.ic_lock_red);
                tab2.setIcon(R.drawable.ic_favorite_brown_300_18dp);
                tab1.setIcon(R.drawable.ic_home);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}

