package com.example.nhungnguyen.firstproject.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.support.v4.view.ViewPager;

import com.example.nhungnguyen.firstproject.Adapters.ViewPagerAdapter;
import com.example.nhungnguyen.firstproject.R;

public class TestFragmentViewPagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        init();

    }

    public void init() {
        mViewPager = (ViewPager) findViewById(R.id.vPager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mTabs = (TabLayout) findViewById(R.id.tabs);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabs.setupWithViewPager(mViewPager);
    }
}
