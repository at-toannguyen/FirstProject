package com.example.nhungnguyen.firstproject.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhungnguyen.firstproject.Adapters.TestLayoutRecyclerAdapter;
import com.example.nhungnguyen.firstproject.Models.ItemList;
import com.example.nhungnguyen.firstproject.R;

import java.util.ArrayList;
import java.util.List;


public class Test1Fragment extends android.support.v4.app.Fragment implements TestLayoutRecyclerAdapter.onItemClickListener {
    private LinearLayoutManager mLinearLayoutManager;
    private RecyclerView mRecyclerView;
    private TestLayoutRecyclerAdapter mAdapter;
    private List<ItemList> mData=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.test1_fragment,container,false);
//        mRecyclerView=(RecyclerView) view.findViewById(R.id.recycleViewPersonal);
//        mLinearLayoutManager=new LinearLayoutManager(this.getActivity());
//        mRecyclerView.setLayoutManager(mLinearLayoutManager);
//        mAdapter= new TestLayoutRecyclerAdapter(mData,this,getActivity());
//        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
    private void init(){

    }
    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onItemLongClick(int poisition) {

    }
}
