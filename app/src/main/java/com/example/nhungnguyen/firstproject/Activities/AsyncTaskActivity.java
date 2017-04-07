package com.example.nhungnguyen.firstproject.Activities;

import android.app.ProgressDialog;
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class AsyncTaskActivity extends AppCompatActivity {
    private TextView mTvMess;
    private Button mBtnDL;
    private ProgressDialog mDownloading;
    private ImageView imgTest;
    private final String URL_DOWNLOAD = "http://hd.wallpaperswide.com/thumbs/colorful_background_5-t2.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        init();
        mBtnDL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadImage().execute(URL_DOWNLOAD);
            }
        });
    }

    private void init() {
        mBtnDL = (Button) findViewById(R.id.btnDL);
        mTvMess = (TextView) findViewById(R.id.tvMessTask);
        imgTest = (ImageView) findViewById(R.id.imgAsync);
    }

    private class DownloadImage extends AsyncTask<String, Integer, String> {
        final Random random=new Random();
        final int i=random.nextInt(1000);
        @Override
        protected String doInBackground(String... strings) {
            int count;
            try {
                URL url = new URL(strings[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                int leghtOfFile = connection.getContentLength();
                InputStream inputStream = new BufferedInputStream(url.openStream(), 8192);
                OutputStream outputStream = new FileOutputStream("/sdcard/downloadedfile"+i+".jpg");
                byte data[] = new byte[1024];
                long total = 0;
                while ((count = inputStream.read(data)) != -1) {
                    total += count;
                    int progress=(int) total*1000/leghtOfFile;
                    publishProgress(progress);
                    // writing data to file
                    outputStream.write(data, 0, count);
                }
                outputStream.flush();
                outputStream.close();
                inputStream.close();

            } catch (Exception e) {
                Log.e("eeeeeee", "doInBackground: ", e);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            mDownloading.setProgress(values[0]);
        }

        @Override
        protected void onPreExecute() {
            mTvMess.setText("Downloading");
            mDownloading = new ProgressDialog(AsyncTaskActivity.this);
            mDownloading.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mDownloading.setTitle("Downloading image: ");
            mDownloading.setMessage("Loading....");
            mDownloading.setIndeterminate(false);
            mDownloading.show();
        }

        @Override
        protected void onPostExecute(String string) {
            mDownloading.dismiss();
            String imagePath = Environment.getExternalStorageDirectory().toString() + "/downloadedfile"+i+".jpg";
            mTvMess.setText("Download Complete");
            Log.d("hhhhhhhhh", "onPostExecute: "+imagePath);
//            Picasso.with(AsyncTaskActivity.this).load(St).resize(200,200).into(imgTest);
            imgTest.setImageDrawable(Drawable.createFromPath(imagePath));
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(imagePath))));
        }

    }
}
