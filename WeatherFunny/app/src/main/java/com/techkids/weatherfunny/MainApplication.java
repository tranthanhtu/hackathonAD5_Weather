package com.techkids.weatherfunny;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;

import com.facebook.stetho.Stetho;
import com.techkids.weatherfunny.eventbus.BaseEvent;
import com.techkids.weatherfunny.eventbus.SevenHourEvent;
import com.techkids.weatherfunny.eventbus.SeventeenHourEvent;
import com.techkids.weatherfunny.eventbus.TwelveHourEvent;
import com.techkids.weatherfunny.managers.NetworkManager;
import com.techkids.weatherfunny.managers.Preferrences;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.services.AlarmService;
import com.techkids.weatherfunny.services.SampleBootReceiver;

import org.greenrobot.eventbus.EventBus;

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
        Intent intent = new Intent(this, AlarmService.class);
        startService(intent);

    }


}


