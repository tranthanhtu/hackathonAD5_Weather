package com.example.hau.newweather;

import android.app.Application;

import com.example.hau.newweather.managers.NetworkManager;

/**
 * Created by Hau on 08/01/2017.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(this);
    }
}
