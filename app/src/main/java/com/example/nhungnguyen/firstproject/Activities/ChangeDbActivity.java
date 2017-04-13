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
import android.text.TextUtils;
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

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

import java.io.File;

@EActivity(R.layout.activity_change_db)
public class ChangeDbActivity extends AppCompatActivity {
    private DataBaseHelper mDataBaseHelper;
    private String mPath;
    private int mPosition;
    private static final int SELECT_PICTURE = 100;
    @Extra
    UserItem mData;
    @Extra
    String key;
    @ViewById(R.id.edtUserName)
    EditText mEdtUser;
    @ViewById(R.id.edtUserAge)
    EditText mEdtAge;
    @ViewById(R.id.edtUserContent)
    EditText mEdtContent;
    @ViewById(R.id.tvTitle)
    TextView mTvTitle;
    @ViewById(R.id.btnAdd)
    Button mBtnAdd;
    @ViewById(R.id.btnDelete)
    Button mBtnDelete;
    @ViewById(R.id.btnEdit)
    Button mBtnEdit;
    @ViewById(R.id.imgChange)
    ImageView mImgUser;

    @AfterViews
    void init() {
        mDataBaseHelper=new DataBaseHelper(this);
        changeDataBse();
    }

    @Click(R.id.btnAdd)
    void onClickAddDb() {
        mDataBaseHelper.addUser(new UserItem(mEdtUser.getText().toString(), mEdtAge.getText().toString(), mEdtContent.getText().toString(), mPath));
        finish();
    }

    @Click(R.id.imgChange)
    void onCLickImgChange() {
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

    @Click(R.id.btnEdit)
    void onCLickBtnEdit() {
        mDataBaseHelper.updateUser(new UserItem(mData.getId(), mEdtUser.getText().toString(), mEdtAge.getText().toString(), mEdtContent.getText().toString(), mPath));
    }

    @Click(R.id.btnDelete)
    void onClickBtnDelete() {
        mDataBaseHelper.deleteUser(new UserItem(mData.getId(), mEdtUser.getText().toString(), mEdtAge.getText().toString(), mEdtContent.getText().toString(), mPath));
    }


    private void changeDataBse() {
        if ("String".equals(key)) {
            mBtnDelete.setVisibility(View.GONE);
            mBtnEdit.setVisibility(View.GONE);
        } else {
            mBtnAdd.setVisibility(View.GONE);
            mBtnEdit.setVisibility(View.VISIBLE);
            mBtnDelete.setVisibility(View.VISIBLE);
            mTvTitle.setText("Edit/Delete");
            mEdtUser.setText(mData.getTvUser());
            mEdtAge.setText(mData.getTvAge());
            mEdtContent.setText(mData.getTvContent());
            if (!TextUtils.isEmpty(mData.getImgPerson())) {
                Picasso.with(this).load(new File(mData.getImgPerson())).into(mImgUser);
            }
        }
    }

    @OnActivityResult(SELECT_PICTURE)
    void resultImg(int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
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
