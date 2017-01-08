package com.example.hau.myweather.views.aplications;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;

import com.example.hau.myweather.services.SampleBootReceiver;

import java.util.Calendar;

/**
 * Created by Dell latitude E6520 on 1/6/2017.
 */

public class WeatherAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setNotificationAlarm();
    }


    private void setNotificationAlarm() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 12);
        calendar.set(Calendar.MINUTE, 35);
        calendar.set(Calendar.SECOND, 00);

        Intent intent = new Intent(getApplicationContext(), SampleBootReceiver.class);

        PendingIntent pendingIntent = PendingIntent
                .getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                pendingIntent);
    }
}
