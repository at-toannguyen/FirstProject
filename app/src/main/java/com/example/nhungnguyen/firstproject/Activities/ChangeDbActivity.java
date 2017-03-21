package com.example.nhungnguyen.firstproject.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.Models.UserItem;
import com.example.nhungnguyen.firstproject.R;
import com.example.nhungnguyen.firstproject.SQLite.DataBaseHelper;
import com.squareup.picasso.Picasso;

public class ChangeDbActivity extends AppCompatActivity {
    private EditText mEdtUser;
    private EditText mEdAge;
    private EditText mEdtcontent;
    private TextView mTvTitle;
    private Button mBtnAdd;
    private Button mBtnDelete;
    private Button mBtnEdit;
    private DataBaseHelper mDataBaseHelper;
    private ImageView mImgUser;
    private static final String URL = "https://www.shareicon.net/data/48x48/2015/09/18/103158_user_512x512.png";
    private UserItem mData;
    private int mPoisition;
    private static final int SELECT_PICTURE = 100;
    private String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_db);
        init();
        changeDataBse();
        addDataBase();
    }

    public void init() {
        mEdtUser = (EditText) findViewById(R.id.edtUserName);
        mEdAge = (EditText) findViewById(R.id.edtUserAge);
        mEdtcontent = (EditText) findViewById(R.id.edtUserContent);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mBtnAdd = (Button) findViewById(R.id.btnAdd);
        mBtnDelete = (Button) findViewById(R.id.btnDelete);
        mBtnEdit = (Button) findViewById(R.id.btnEdit);
        mDataBaseHelper = new DataBaseHelper(this);
        mImgUser = (ImageView) findViewById(R.id.imgChange);
    }

    public void changeDataBse() {
        Bundle b = getIntent().getExtras();
        String string = b.getString("keya");
        String editdb = b.getString("keyb");
        if (string == b.getString("keya")) {
            mBtnDelete.setVisibility(View.GONE);
            mBtnEdit.setVisibility(View.GONE);
            mImgUser.setVisibility(View.GONE);
        }
        if (editdb == b.get("keyb")) {
            mBtnAdd.setVisibility(View.GONE);
            mBtnEdit.setVisibility(View.VISIBLE);
            mBtnDelete.setVisibility(View.VISIBLE);
            mImgUser.setVisibility(View.VISIBLE);
            mTvTitle.setText("Edit/Delete");
            mData = b.getParcelable("paradb");
            mPoisition = b.getInt("poisitiondb");
            mEdtUser.setText(mData.getTvUser());
            mEdAge.setText(mData.getTvAge());
            mEdtcontent.setText(mData.getTvContent());
            Picasso.with(this).load(mData.getImgPerson()).into(mImgUser);
        }
    }

    public void addDataBase() {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataBaseHelper.addUser(new UserItem(mEdtUser.getText().toString(), mEdAge.getText().toString(), mEdtcontent.getText().toString(), URL));
            }
        });
        mImgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGalerry = new Intent();
                intentGalerry.setType("image/*");
                intentGalerry.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intentGalerry, "Select Picture"), SELECT_PICTURE);
            }
        });
        mBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataBaseHelper.updateUser(new UserItem(mEdtUser.getText().toString(), mEdAge.getText().toString(), mEdtcontent.getText().toString(), mPath));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    mPath = selectedImageUri.toString();
                    // Set the image in ImageView
                    Picasso.with(this).load(mPath).into(mImgUser);
                    Log.d("aaaaa", "onActivityResult: " + mPath);
//                    mImgUser.setImageURI(selectedImageUri);
                }
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent();
        i.putExtra("db", mData);
        i.putExtra("positiondb", mPoisition);
        setResult(RESULT_OK, i);
        finish();
    }
}
