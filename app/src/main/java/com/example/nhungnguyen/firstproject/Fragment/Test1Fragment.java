package com.example.nhungnguyen.firstproject.Fragment;


import android.os.Bundle;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.nhungnguyen.firstproject.Adapters.ViewPagerFragmentAdapter;
import com.example.nhungnguyen.firstproject.R;

import java.util.ArrayList;
import java.util.List;


public class Test1Fragment extends android.support.v4.app.Fragment {
    ViewPager viewPager;
    ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.test1_fragment,container,false);
        viewPager=(ViewPager) view.findViewById(R.id.vPagerTest);
        viewPagerFragmentAdapter=new ViewPagerFragmentAdapter(getFragmentManager());
        viewPager.setAdapter(viewPagerFragmentAdapter);
        return view;
    }


}
