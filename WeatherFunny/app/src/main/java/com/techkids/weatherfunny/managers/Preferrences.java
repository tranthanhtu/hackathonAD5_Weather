package com.techkids.weatherfunny.managers;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Hau on 10/01/2017.
 */

public class Preferrences {

    public static final String KEY_CITY = "city";
    public static final String CITY_DEFAULT = "Ha noi";

    private SharedPreferences sharedPreferences;

    public Preferrences(Context context) {
        this.sharedPreferences = context.getSharedPreferences("weather", Context.MODE_PRIVATE);
    }

    public void putCity(String city) {
        this.sharedPreferences.edit()
                .putString(KEY_CITY, city)
                .commit();
    }

    public String getCity() {
        return this.sharedPreferences.getString(KEY_CITY, CITY_DEFAULT);
    }

    private static Preferrences _sharePointer;

    public static Preferrences getInstance() {
        return _sharePointer;
    }

    public static void init(Context context) {
        _sharePointer = new Preferrences(context);
    }
}
