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
import android.util.Log;

import com.example.hau.myweather.R;
import com.example.hau.myweather.constants.Preferences;
import com.example.hau.myweather.models.jsons.Astronomy;
import com.example.hau.myweather.models.jsons.Atmosphere;
import com.example.hau.myweather.models.jsons.ChannelW;
import com.example.hau.myweather.models.jsons.ConditionW;
import com.example.hau.myweather.models.jsons.ItemW;
import com.example.hau.myweather.models.jsons.Weather;
import com.example.hau.myweather.models.jsons.WindW;
import com.example.hau.myweather.presenters.WeatherPresenter;
import com.example.hau.myweather.presenters.WeatherPresenterImpl;
import com.example.hau.myweather.views.activities.ReceiverActivity;
import com.example.hau.myweather.views.activities.WeatherActivity;
import com.example.hau.myweather.views.activities.WeatherActivityImpl;

/**
 * Created by Hau on 31/12/2016.
 */

public class SampleBootReceiver extends BroadcastReceiver implements WeatherActivity{
    public static final String TAG = SampleBootReceiver.class.toString();
    private WeatherPresenter weatherPresenter;
    private int temperatureF;

    Context context;

    public SampleBootReceiver() {
        weatherPresenter = new WeatherPresenterImpl(this);


    }

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;


        weatherPresenter.check("Ha Noi");
        Log.d(TAG, "onReceive: " + temperatureF);



    }


    @Override
    public void updateUI(Weather weather) {
        Log.d(TAG, "updateUI");

        ChannelW channelW = weather.getQuery().getResultW().getChannelW();
        ItemW itemW = channelW.getItemW();
        Astronomy astronomy = channelW.getAstronomy();
        WindW windW = channelW.getWindW();
        Atmosphere atmosphere = channelW.getAtmosphere();
        ConditionW conditionW = itemW.getConditionW();

        temperatureF = conditionW.getTemp();

        Log.d(TAG, "updateUI: " + temperatureF);



        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeat_intent = new Intent(context, ReceiverActivity.class);

        repeat_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 100, repeat_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("abc")
                .setContentText(temperatureF + "F")
                .setAutoCancel(true);

        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        builder.setSound(alarmSound);

        builder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(100, builder.build());

    }
}
