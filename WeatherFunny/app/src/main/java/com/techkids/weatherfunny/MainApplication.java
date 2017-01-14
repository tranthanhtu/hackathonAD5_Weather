package com.techkids.weatherfunny;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;

import com.facebook.stetho.Stetho;
import com.techkids.weatherfunny.managers.NetworkManager;
import com.techkids.weatherfunny.managers.Preferrences;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.services.SampleBootReceiver;

import java.util.Calendar;

/**
 * Created by Hau on 10/01/2017.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(this);
        Preferrences.init(this);
        RealmHandler.init(this);
        Stetho.initializeWithDefaults(this);
        setNotificationAlarm(07, 00, 00);
        setNotificationAlarm(12, 00, 00);
        setNotificationAlarm(17, 00, 00);

    }

    private void setNotificationAlarm(int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);

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
