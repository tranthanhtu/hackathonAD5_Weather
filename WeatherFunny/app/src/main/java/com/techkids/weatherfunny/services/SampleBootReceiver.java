package com.techkids.weatherfunny.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.views.activities.MainActivity;

/**
 * Created by Dell latitude E6520 on 1/15/2017.
 */

public class SampleBootReceiver extends BroadcastReceiver {
    Weather weather;
    @Override
    public void onReceive(Context context, Intent intent) {

        weather = RealmHandler.getInstance().getWeather();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeat_intent = new Intent(context, MainActivity.class);

        repeat_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeat_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("abc")
                .setContentText("bac")
                .setAutoCancel(true);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        builder.setSound(alarmSound);

        notificationManager.notify(100, builder.build());
    }
}
