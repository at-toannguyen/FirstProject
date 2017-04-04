package com.example.nhungnguyen.firstproject.Activities;

import android.app.Application;
import android.util.Log;

import com.google.android.gms.maps.MapsInitializer;


public class MyApplication extends Application {
    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        try {
            MapsInitializer.initialize(getApplicationContext());
        } catch (Exception e) {
            Log.e("eeeeee", "onCreateView: ", e);
        }
    }

    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(MyBroadcast.ConnectivityReceiverListener listener) {
        MyBroadcast.connectivityReceiverListener = listener;
    }
}
