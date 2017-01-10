package com.techkids.weatherfunny;

import android.app.Application;

import com.techkids.weatherfunny.managers.NetworkManager;
import com.techkids.weatherfunny.managers.Preferrences;
import com.techkids.weatherfunny.managers.RealmHandler;

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
    }
}
