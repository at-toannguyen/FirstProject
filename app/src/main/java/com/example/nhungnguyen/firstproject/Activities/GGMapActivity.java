package com.example.nhungnguyen.firstproject.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.nhungnguyen.firstproject.Fragment.MapsFragment;
import com.example.nhungnguyen.firstproject.R;

public class GGMapActivity extends AppCompatActivity {
    private MapsFragment mFragment = new MapsFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ggmap);
        Log.d("eeeee2", "onCreate: ");
        mFragment.setArguments(getIntent().getExtras());
        getFragmentManager().beginTransaction().add(R.id.frameContainer1, mFragment).commit();
    }

}
