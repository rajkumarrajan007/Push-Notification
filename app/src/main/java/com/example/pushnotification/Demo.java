package com.example.pushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class Demo extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Intent obj=new Intent(this,MainActivity.class);
        obj.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent ob2=PendingIntent.getActivity(this,0,obj,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder ob3=new NotificationCompat.Builder(this);
        ob3.setContentTitle("Notification Service");
        ob3.setAutoCancel(true);
        ob3.setSmallIcon(R.mipmap.ic_launcher);
        ob3.setContentIntent(ob2);
        NotificationManager nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(0,ob3.build());
    }
}
