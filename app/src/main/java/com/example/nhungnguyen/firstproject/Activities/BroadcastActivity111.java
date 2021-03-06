package com.example.nhungnguyen.firstproject.Activities;


import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;

import android.content.Context;
import android.content.Intent;

import android.graphics.BitmapFactory;
import android.graphics.Color;

import android.media.RingtoneManager;
import android.net.Uri;

import android.support.design.widget.Snackbar;
import android.support.v7.app.NotificationCompat;
import android.view.View;

import android.widget.TextView;


import com.example.nhungnguyen.firstproject.BroadcastReceive.MyBroadcast;
import com.example.nhungnguyen.firstproject.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_broadcast)
public class BroadcastActivity111 extends Activity implements MyBroadcast.ConnectivityReceiverListener {
    @Click(R.id.btnStart)
    void checkConnect(){
        checkConnection();
    }

    private void checkConnection() {
        boolean isConnect = MyBroadcast.isConnect();
        showNotification(isConnect);
    }

    private void showSnack(boolean isConnect) {
        String mess;
        int color;
        if (isConnect) {
            mess = "Connect success";
            color = Color.WHITE;
        } else {
            mess = "Connect fail";
            color = Color.RED;
        }
        Snackbar snackbar = Snackbar.make(findViewById(R.id.fab), mess, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }



    private void showNotification(boolean isConnect) {
        NotificationCompat.Builder builder;
        String data1 = "Connect Success";
        String data2 = "Connect Fail";
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent notificationIntent = new Intent(this, TestNotificationActivity.class);
        if (isConnect) {
            builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_home)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_warning))
                    .setContentTitle("Connected")
                    .setContentText(data1)
                    .setColor(Color.RED)
                    .setSound(alarmSound);
            notificationIntent.putExtra("data", data1);
        } else {
            builder = (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_home)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_warning))
                    .setContentTitle("Connected")
                    .setContentText(data2)
                    .setSound(alarmSound);
            notificationIntent.putExtra("data", data2);
        }
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    @Override
    public void onNetworkConnectionChanged(Boolean isConnect) {
        showSnack(isConnect);
    }
}
