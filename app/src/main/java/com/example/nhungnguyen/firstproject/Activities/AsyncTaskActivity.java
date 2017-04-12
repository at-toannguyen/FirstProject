package com.example.nhungnguyen.firstproject.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.AfterTextChange;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.NonConfigurationInstance;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Random;

@EActivity(R.layout.activity_async_task)
public class AsyncTaskActivity extends AppCompatActivity {
    private final String URL_DOWNLOAD = "http://hd.wallpaperswide.com/thumbs/colorful_background_5-t2.jpg";
    private ProgressDialog mDownloading;

    private int mPercen;
    @ViewById(R.id.tvMessTask)
    TextView mTvMess;

    @ViewById(R.id.imgAsync)
    ImageView imgTest;

    @AfterViews
    void afterViews() {
        mDownloading = new ProgressDialog(this);
        mDownloading.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mDownloading.setTitle("Downloading image: ");
        mDownloading.setMessage("Loading....");
        mDownloading.setIndeterminate(false);
    }

    @Click(R.id.btnDL)
    void setmDownloading() {
        if (!mDownloading.isShowing()) {
            mDownloading.show();
        }
        downloadImageFromURl(URL_DOWNLOAD);

    }

    private void init() {
        mTvMess = (TextView) findViewById(R.id.tvMessTask);
        imgTest = (ImageView) findViewById(R.id.imgAsync);
    }

    @Background
    void downloadImageFromURl(String imageUrl) {
        int count;
        try {
            URL url = new URL(imageUrl);
            URLConnection connection = url.openConnection();
            connection.connect();
            int leghtOfFile = connection.getContentLength();
            InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);
            OutputStream outputStream = new FileOutputStream("/sdcard/downloadedfile" + Calendar.getInstance().getTimeInMillis() + ".jpg");
            byte data[] = new byte[1024];
            long total = 0;
            while ((count = inputStream.read(data)) != -1) {
                total += count;
                mPercen = (int) total * 1000 / leghtOfFile;
                // writing data to file
                outputStream.write(data, 0, count);
                Log.d("VVV", "downloadImageFromURl: " + mPercen);
                updateUi();

            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void updateUi() {
        mDownloading.setProgress(mPercen);
    }
}
