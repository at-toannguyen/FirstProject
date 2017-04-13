package com.example.nhungnguyen.firstproject.Activities;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


import com.example.nhungnguyen.firstproject.Fragment.RecyclerViewFragment;
import com.example.nhungnguyen.firstproject.Fragment.RecyclerViewFragment_;
import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_test_fragment2)
public class TestFragmentActivity extends AppCompatActivity {
    private final RecyclerViewFragment fragment = new RecyclerViewFragment();
    @AfterViews
    void inti(){
        getSupportFragmentManager().beginTransaction().add(R.id.frameContainer, RecyclerViewFragment_.builder().build()).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Fragment fragment1 = getSupportFragmentManager().findFragmentById(R.id.frameContainer);
        if (fragment1 != null) {
            fragment1.onActivityResult(requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
