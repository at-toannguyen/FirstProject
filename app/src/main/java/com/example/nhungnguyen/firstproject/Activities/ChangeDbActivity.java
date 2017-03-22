package com.example.nhungnguyen.firstproject.Activities;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
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

import java.io.File;


public class ChangeDbActivity extends AppCompatActivity {
    private EditText mEdtUser;
    private EditText mEdAge;
    private EditText mEdtContent;
    private TextView mTvTitle;
    private Button mBtnAdd;
    private Button mBtnDelete;
    private Button mBtnEdit;
    private DataBaseHelper mDataBaseHelper;
    private ImageView mImgUser;
    private UserItem mData;
    private int mPosition;
    private static final int SELECT_PICTURE = 100;
    private String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_db);
        init();
        changeDataBse();
        updateDataBase();
    }

    private void init() {
        mEdtUser = (EditText) findViewById(R.id.edtUserName);
        mEdAge = (EditText) findViewById(R.id.edtUserAge);
        mEdtContent = (EditText) findViewById(R.id.edtUserContent);
        mTvTitle = (TextView) findViewById(R.id.tvTitle);
        mBtnAdd = (Button) findViewById(R.id.btnAdd);
        mBtnDelete = (Button) findViewById(R.id.btnDelete);
        mBtnEdit = (Button) findViewById(R.id.btnEdit);
        mDataBaseHelper = new DataBaseHelper(this);
        mImgUser = (ImageView) findViewById(R.id.imgChange);
    }

    private void changeDataBse() {
        Bundle b = getIntent().getExtras();
        String key = getIntent().getStringExtra("key");
        Log.d("11111111", "changeDataBse: " + key);
        if ("String".equals(key)) {
            mBtnDelete.setVisibility(View.GONE);
            mBtnEdit.setVisibility(View.GONE);
        } else {
            mBtnAdd.setVisibility(View.GONE);
            mBtnEdit.setVisibility(View.VISIBLE);
            mBtnDelete.setVisibility(View.VISIBLE);
            mTvTitle.setText("Edit/Delete");
            mData = b.getParcelable("paradb");
            mPosition = b.getInt("poisitiondb");
            mEdtUser.setText(mData.getTvUser());
            mEdAge.setText(mData.getTvAge());
            mEdtContent.setText(mData.getTvContent());
            Picasso.with(this).load(new File(mData.getImgPerson())).into(mImgUser);
        }
    }

    private void updateDataBase() {
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("1234", "onClick: " + mPath);
                mDataBaseHelper.addUser(new UserItem(mEdtUser.getText().toString(), mEdAge.getText().toString(), mEdtContent.getText().toString(), mPath));
                finish();
            }
        });
        mImgUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentGallerry = new Intent();
                intentGallerry.setType("image/*");
                intentGallerry.addCategory(Intent.CATEGORY_OPENABLE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    intentGallerry.setAction(Intent.ACTION_OPEN_DOCUMENT);
                    startActivityForResult(intentGallerry, SELECT_PICTURE);
                } else {
                    intentGallerry.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intentGallerry, "Select Picture"), SELECT_PICTURE);
                }
            }
        });
        mBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataBaseHelper.updateUser(new UserItem(mData.getId(), mEdtUser.getText().toString(), mEdAge.getText().toString(), mEdtContent.getText().toString(), mPath));
            }
        });
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataBaseHelper.deleteUser(new UserItem(mData.getId(), mEdtUser.getText().toString(), mEdAge.getText().toString(), mEdtContent.getText().toString(), mPath));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri uri = data.getData();
                String imagePath = getPath(this, uri);
                Log.d("aaa", "onActivityResult: " + imagePath);
                if (imagePath != null) {
                    // Get the path from the Uri
                    mPath = imagePath;
                    // Set the image in ImageView
                    Picasso.with(this)
                            .load(new File(mPath))
                            .centerCrop()
                            .fit()
                            .into(mImgUser);
                    Log.d("aaaaa", "onActivityResult: " + mPath);
                }
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private String getPath(final Context context, final Uri uri) {

        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            } else if (isDownloadsDocument(uri)) { // DownloadsProvider

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(context, contentUri, null, null);
            } else if (isMediaDocument(uri)) { // MediaProvider
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else {
                    return null;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) { // MediaStore (and general)

            // Return the remote address
            if (isGooglePhotosUri(uri)) {
                return uri.getLastPathSegment();
            }
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) { // File
            return uri.getPath();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is Google Photos.
     */
    private boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    private String getDataColumn(Context context, Uri uri, String selection,
                                 String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    private boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    private boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    private boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent();
        i.putExtra("db", mData);
        i.putExtra("positiondb", mPosition);
        setResult(RESULT_OK, i);
        finish();
    }
}
