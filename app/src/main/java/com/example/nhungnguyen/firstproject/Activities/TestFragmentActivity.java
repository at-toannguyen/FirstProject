package com.example.nhungnguyen.firstproject.Activities;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.nhungnguyen.firstproject.Fragment.RecyclerViewFragment;
import com.example.nhungnguyen.firstproject.R;


public class TestFragmentActivity extends AppCompatActivity {
    private final RecyclerViewFragment fragment = new RecyclerViewFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment2);
        if (findViewById(R.id.frameContainer) != null) {
            if (savedInstanceState == null) {
                fragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().add(R.id.frameContainer, fragment).commit();
            }
        }
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
