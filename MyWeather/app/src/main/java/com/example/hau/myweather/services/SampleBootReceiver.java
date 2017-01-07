package com.example.hau.myweather.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.example.hau.myweather.R;
import com.example.hau.myweather.views.activities.ReceiverActivity;
import com.example.hau.myweather.views.activities.WeatherActivityImpl;

/**
 * Created by Hau on 31/12/2016.
 */

public class SampleBootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeat_intent = new Intent(context, ReceiverActivity.class);

        repeat_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeat_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("abc")
                .setContentText("acb")
                .setAutoCancel(true);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        builder.setSound(alarmSound);

        builder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(100, builder.build());
    }


}
