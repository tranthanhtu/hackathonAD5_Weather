package com.techkids.weatherfunny.managers;

import android.content.Context;


import com.techkids.weatherfunny.models.json.api_apixu.Weather;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Hau on 10/01/2017.
 */

public class RealmHandler {
    private Realm realm;

    private RealmHandler(Context context) {
        Realm.init(context);
        this.realm = Realm.getDefaultInstance();
    }

    public void addWeather (Weather weather) {
        realm.beginTransaction();
        realm.copyToRealm(weather);
        realm.commitTransaction();
    }

    public Weather getWeather() {
        RealmResults<Weather> weathers = realm
                .where(Weather.class)
                .findAll();

        return weathers.get((int) (getCount() - 1));
    }

    public long getCount() {
        return realm.where(Weather.class).count();
    }

    private static RealmHandler _sharePointer;

    public static RealmHandler getInstance() {
        return _sharePointer;
    }

    public static void init(Context context) {
        _sharePointer = new RealmHandler(context);
    }
}
