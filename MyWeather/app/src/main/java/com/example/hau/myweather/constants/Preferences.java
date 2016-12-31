package com.example.hau.myweather.constants;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Hau on 31/12/2016.
 */

public class Preferences {

    public static final String CITY = "City";

    private SharedPreferences sharedPreferences;
    private static Preferences _sharePointer;

    private Preferences(Context context) {
        sharedPreferences = context.getSharedPreferences("weather", Context.MODE_PRIVATE);
    }

    public String getCity() {
        return sharedPreferences.getString(CITY, "");
    }

    public void putCity(String city) {
        sharedPreferences.edit().putString(CITY, city).commit();
    }

    public static Preferences getInstance() {
        return _sharePointer;
    }

    public static void init(Context context) {
        _sharePointer = new Preferences(context);
    }
}
