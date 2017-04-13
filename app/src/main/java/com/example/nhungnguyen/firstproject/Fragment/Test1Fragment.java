package com.example.nhungnguyen.firstproject.Fragment;


import android.content.Intent;

import android.support.v4.view.ViewPager;
import android.util.Log;
import com.example.nhungnguyen.firstproject.Activities.DetailPersonActivity_;
import com.example.nhungnguyen.firstproject.Adapters.TestAdapterViewpager;
import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.test1_fragment)
public class Test1Fragment extends android.support.v4.app.Fragment implements TestAdapterViewpager.OnClickItemViewpager {
    private List<UserItem> mData = new ArrayList<>();
    private TestAdapterViewpager mAdapter;
    @ViewById(R.id.vPagerTest)
    ViewPager viewPager;
    @AfterViews
    void init(){
        mData = loadData();
        mAdapter = new TestAdapterViewpager(getContext(), mData, this);
        viewPager.setAdapter(mAdapter);
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
    @Override
    public void onClick(int position) {
        DetailPersonActivity_.intent(getContext()).mPosition(position).mData(mData.get(position)).startForResult(4);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==4){
            if(resultCode==getActivity().RESULT_OK){
                Log.d("result", "onActivityResult: ");
                UserItem test = data.getParcelableExtra("favor");
                int position = data.getIntExtra("positionFavorite", -1);
                Log.d("poi", "onActivityResult: " + position);
                if (position != -1) {
                    mData.set(position, test);
                    mAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
