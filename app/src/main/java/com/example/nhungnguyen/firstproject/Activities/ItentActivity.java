package com.example.nhungnguyen.firstproject.Activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OnActivityResult;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_itent)
public class ItentActivity extends AppCompatActivity  {
    private static final int SELECT_PICTURE = 100;
    private static final int CAMERA_REQUEST = 1888;
    @Click(R.id.btnCall)
    void onCLickBtnCall(){
        Intent call = new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel: 0124578325"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
            return;
        }
        startActivity(call);
    }
    @Click(R.id.btnCamera)
    void onCLickBtnCamera(){
        Intent intentCamera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamera, CAMERA_REQUEST);
    }
    @Click(R.id.btnSendMail)
    void onCLickBtnSendMail(){
        Intent sendmail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "tai.nguyen@asiantech.vn", null));
        sendmail.putExtra(Intent.EXTRA_SUBJECT, "test");
        sendmail.putExtra(Intent.EXTRA_TEXT, "asdqweqweqwew");
        startActivity(sendmail);
    }
    @Click(R.id.btnSendmMess)
    void onCLickBtnSendMess(){
        Intent sendmess = new Intent(Intent.ACTION_SENDTO);
        sendmess.setData(Uri.parse("smsto:032123456"));
        sendmess.putExtra("sms_body", "abcasdasdqwe");
        startActivity(sendmess);
    }
    @Click(R.id.btnLauchWeb)
    void onCLickBtnLauchWeb(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.vnexpress.net")));
    }
    @Click(R.id.btnOpenAppPlay)
    void onCLickBtnOpenAppPlay(){
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/movies/details/Ti%E1%BB%83u_%C4%91%E1%BB%99i_c%C3%B2_bay?id=SRfm1sspS-g&hl=vi" + appPackageName)));
        }
    }
    @Click(R.id.btnOpenGGMap)
    void onCLickBtnOpenGGMap(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/@16.0764786,108.2314929,16.15z")));
    }
    @Click(R.id.btnGallery)
    void onCLickBtnGallery(){
        Intent intentGalerry = new Intent();
        intentGalerry.setType("image/*");
        intentGalerry.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intentGalerry, "Select Picture"), SELECT_PICTURE);
    }
    @ViewById(R.id.imgTest)
    ImageView mImgTest;

    @OnActivityResult(SELECT_PICTURE)
    void setSelectPicture(int resultCode, Intent data){
        if (resultCode == RESULT_OK) {
                // Get the url from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // Get the path from the Uri
                    // Set the image in ImageView
                    mImgTest.setImageURI(selectedImageUri);
                }
        }
    }
    @OnActivityResult(CAMERA_REQUEST)
    void setCameraRequest(int resultCode, Intent data){
        if (resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            mImgTest.setImageBitmap(photo);
        }
    }
}
