package com.example.nhungnguyen.firstproject.Activities;

import android.support.v7.app.AppCompatActivity;

import com.example.nhungnguyen.firstproject.Fragment.MapsFragment_;
import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_ggmap)
public class GGMapActivity extends AppCompatActivity {
    @AfterViews
    void init(){
        getFragmentManager().beginTransaction().add(R.id.frameContainer1, MapsFragment_.builder().build()).commit();
    }
}
