package com.example.hau.newweather;

import android.app.Application;
import android.content.Intent;

import com.example.hau.newweather.managers.NetworkManager;
import com.example.hau.newweather.services.LoadDataService;

/**
 * Created by Hau on 08/01/2017.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(this);
        Intent intent = new Intent(this, LoadDataService.class);
        startService(intent);
    }
}
