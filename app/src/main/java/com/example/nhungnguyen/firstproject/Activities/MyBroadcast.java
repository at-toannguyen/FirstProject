package com.example.nhungnguyen.firstproject.Activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class MyBroadcast extends BroadcastReceiver {
    public static ConnectivityReceiverListener connectivityReceiverListener;

    public MyBroadcast() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        boolean isConnect = networkInfo != null
                && networkInfo.isConnectedOrConnecting();
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnect);
        }
    }

    public static boolean isConnect() {
        ConnectivityManager cm = (ConnectivityManager) MyApplication.getInstance().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

     interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(Boolean isConnect);
    }
}
