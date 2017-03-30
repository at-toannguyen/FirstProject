package com.example.nhungnguyen.firstproject.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.nhungnguyen.firstproject.R;

public class ItentActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnCall;
    private Button mBtnSendMess;
    private Button mBtnSendMail;
    private Button mBtnLauch;
    private Button mBtnOpenStore;
    private Button mBtnOpenMap;
    private Button mBtnGallery;
    private Button mBtnCamera;
    private ImageView mImgTest;
    private static final int SELECT_PICTURE = 100;
    private static final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itent);
        initVariable();
        setOnClick();
    }

    private void initVariable() {
        mBtnCall = (Button) findViewById(R.id.btnCall);
        mBtnCamera = (Button) findViewById(R.id.btnCamera);
        mBtnSendMail = (Button) findViewById(R.id.btnSendMail);
        mBtnSendMess = (Button) findViewById(R.id.btnSendmMess);
        mBtnLauch = (Button) findViewById(R.id.btnLauchWeb);
        mBtnOpenStore = (Button) findViewById(R.id.btnOpenAppPlay);
        mBtnOpenMap = (Button) findViewById(R.id.btnOpenGGMap);
        mBtnGallery = (Button) findViewById(R.id.btnGallery);
        mImgTest = (ImageView) findViewById(R.id.imgTest);
    }

    private void setOnClick() {
        mBtnCall.setOnClickListener(this);
        mBtnCamera.setOnClickListener(this);
        mBtnSendMess.setOnClickListener(this);
        mBtnSendMail.setOnClickListener(this);
        mBtnGallery.setOnClickListener(this);
        mBtnLauch.setOnClickListener(this);
        mBtnOpenMap.setOnClickListener(this);
        mBtnOpenStore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCall:
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: 0124578325"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
                    return;
                }
                startActivity(call);
                break;
            case R.id.btnSendmMess:
                Intent sendmess = new Intent(Intent.ACTION_SENDTO);
                sendmess.setData(Uri.parse("smsto:032123456"));
                sendmess.putExtra("sms_body", "abcasdasdqwe");
                startActivity(sendmess);
                break;
            case R.id.btnSendMail:
                Intent sendmail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "tai.nguyen@asiantech.vn", null));
                sendmail.putExtra(Intent.EXTRA_SUBJECT, "test");
                sendmail.putExtra(Intent.EXTRA_TEXT, "asdqweqweqwew");
                startActivity(sendmail);
                break;
            case R.id.btnLauchWeb:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vnexpress.net")));
                break;
            case R.id.btnOpenAppPlay:
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/movies/details/Ti%E1%BB%83u_%C4%91%E1%BB%99i_c%C3%B2_bay?id=SRfm1sspS-g&hl=vi" + appPackageName)));
                }
                break;
            case R.id.btnOpenGGMap:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/@16.0764786,108.2314929,16.15z")));
                break;
            case R.id.btnGallery:
                Intent intentGalerry = new Intent();
                intentGalerry.setType("image/*");
                intentGalerry.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intentGalerry, "Select Picture"), SELECT_PICTURE);
                break;
            case R.id.btnCamera:
                Intent intentCamera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamera, CAMERA_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Load ImageView From Gallery
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    // Set the image in ImageView
                    mImgTest.setImageURI(selectedImageUri);
                }
            }
        }
        // Load ImageView From Camera
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mImgTest.setImageBitmap(photo);
        }
    }

//    /**
//     * @param contentUri
//     * @return
//     */
//    @SuppressWarnings("JavaDoc")
//    private String getPathFromURI(Uri contentUri) {
//        String res = null;
//        String[] proj = {MediaStore.Images.Media.DATA};
//        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
//        if (cursor.moveToFirst()) {
//            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            res = cursor.getString(column_index);
//        }
//        cursor.close();
//        return res;
//    }
}
