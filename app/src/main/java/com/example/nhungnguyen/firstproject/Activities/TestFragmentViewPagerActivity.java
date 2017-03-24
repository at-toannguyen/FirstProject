package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.support.v4.view.ViewPager;

import com.example.nhungnguyen.firstproject.Adapters.ViewPagerAdapter;
import com.example.nhungnguyen.firstproject.R;

public class TestFragmentViewPagerActivity extends FragmentActivity implements TabLayout.OnTabSelectedListener {
    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;
    private TabLayout mTabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);
        init();
        createTab();
        mTabs.setOnTabSelectedListener(this);
        mTabs.setTabGravity(TabLayout.GRAVITY_FILL);
        mViewPager.setAdapter(mViewPagerAdapter);

    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.vPager);
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mTabs = (TabLayout) findViewById(R.id.tabs);
    }

    private void createTab() {
        final TabLayout.Tab tab1 = mTabs.newTab();
        final TabLayout.Tab tab2 = mTabs.newTab();
        final TabLayout.Tab tab3 = mTabs.newTab();
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
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
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
            public void onPageScrollStateChanged(int state) {

            }
        });
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

