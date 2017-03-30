package com.example.nhungnguyen.firstproject.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;
import com.squareup.picasso.Picasso;

public class TestDay19Activity extends AppCompatActivity {
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_day19);
        mToolbar=(Toolbar) findViewById(R.id.toolbarTest);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemShowDialog:
                AlertDialog.Builder builder=new AlertDialog.Builder(this);
                View view= getLayoutInflater().inflate(R.layout.custom_dialog_layout,null);
                TextView tvDialog=(TextView) view.findViewById(R.id.tvDialog);
                ImageView imageView=(ImageView) view.findViewById(R.id.imgDialog);
                tvDialog.setText("asdfqweqweqwe");
                Picasso.with(this).load(R.drawable.img_person1).into(imageView);
                builder.setTitle("Custom Dialog");
                builder.setView(view);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                Dialog dialog=builder.create();
                dialog.show();
                break;
            case R.id.itemShowFragmentDialog:
                BuildDialogFragment buildDialogFragment=new BuildDialogFragment();
                buildDialogFragment.setRetainInstance(true);
                buildDialogFragment.show(getFragmentManager(),"asdlqjweqwe");
                break;
            case R.id.itemShowCustomDialog:
                AlertDialog.Builder builder1=new AlertDialog.Builder(this);

        }
        return super.onOptionsItemSelected(item);
    }
}
