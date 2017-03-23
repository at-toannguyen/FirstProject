package com.example.nhungnguyen.firstproject.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.nhungnguyen.firstproject.Fragment.RecyclerViewFragment;
import com.example.nhungnguyen.firstproject.R;

public class TestFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment2);
        if (findViewById(R.id.frameContainer)!=null){
            if(savedInstanceState==null){
                RecyclerViewFragment fragment = new RecyclerViewFragment();
                fragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.frameContainer, fragment).commit();
            }
        }
    }

}
