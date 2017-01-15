package com.techkids.weatherfunny.managers;

import android.content.Context;


import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.models.json.api_trolyfacebook.Message;
import com.techkids.weatherfunny.models.json.api_trolyfacebook.Remind;

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

    public void addWeather(Weather weather) {
        realm.beginTransaction();
        realm.copyToRealm(weather);
        realm.commitTransaction();
    }

    public Weather getWeather() {
        Weather weather = null;
        try {
            RealmResults<Weather> weathers = realm
                    .where(Weather.class)
                    .findAll();

            weather =  weathers.get((int) (getCount() - 1));
        } catch (Exception e) {

        }
        return  weather;
    }

    public Message getMessage() {
        Message message = null;
        try {
            RealmResults<Message> messages = realm
                    .where(Message.class)
                    .findAll();

            message = messages.get((int) (getCountMessage() - 1));
        } catch (Exception e) {

        }
        return message;
    }

    public void addMessage(Message message) {
        realm.beginTransaction();
        realm.copyToRealm(message);
        realm.commitTransaction();
    }

    private long getCountMessage() {
        return realm.where(Message.class).count();
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
