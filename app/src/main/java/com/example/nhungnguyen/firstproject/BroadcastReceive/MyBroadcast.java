package com.example.nhungnguyen.firstproject.BroadcastReceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.example.nhungnguyen.firstproject.Activities.MyApplication;
import com.example.nhungnguyen.firstproject.Activities.PassReceiveActivity_;
import com.example.nhungnguyen.firstproject.Activities.TestNotificationActivity;



public class MyBroadcast extends BroadcastReceiver {
    public static ConnectivityReceiverListener connectivityReceiverListener;
    public static String NAME = "com.example.nhungnguyen.firstproject.Activities.TestNotificationActivity";
    public static String NAME1 = "com.example.nhungnguyen.firstproject.Receive";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(NAME)) {
            String data = intent.getStringExtra("files");
            Toast.makeText(context, data, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(context, TestNotificationActivity.class);
            i.putExtra("test", data);
            context.startActivity(i);
        } else {
            if (intent.getAction().equals(NAME1)) {
                Intent i1 = new Intent(context, PassReceiveActivity_.class);
                i1.putExtra("from", intent.getStringExtra("send"));
                context.startActivity(i1);
            } else {
                ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = cm.getActiveNetworkInfo();
                boolean isConnect = networkInfo != null
                        && networkInfo.isConnectedOrConnecting();
                if (connectivityReceiverListener != null) {
                    connectivityReceiverListener.onNetworkConnectionChanged(isConnect);
                }
            }
        }
    }

    public static boolean isConnect() {
        ConnectivityManager cm = (ConnectivityManager) MyApplication.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(Boolean isConnect);
    }
}
