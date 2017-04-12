package com.example.nhungnguyen.firstproject.Activities;

import android.app.Dialog;
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

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;
@EActivity(R.layout.activity_test_day19)
@OptionsMenu(R.menu.menu_test)
public class TestDay19Activity extends AppCompatActivity {
    @ViewById(R.id.toolbarTest)
    Toolbar mToolbar;
    @OptionsItem({R.id.itemShowCustomDialog,R.id.itemShowDialog,R.id.itemShowFragmentDialog})
    void itemSelected(MenuItem item){
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
    }
    @AfterViews
    void init(){
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
