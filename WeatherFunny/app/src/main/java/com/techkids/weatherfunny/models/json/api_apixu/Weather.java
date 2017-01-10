package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Hau on 08/01/2017.
 */

public class Weather extends RealmObject{
    @SerializedName("location")
    private Location location;
    @SerializedName("current")
    private Current current;
    @SerializedName("forecast")
    private Forecast forecast;

    public Location getLocation() {
        return location;
    }

    public Current getCurrent() {
        return current;
    }

    public Forecast getForecast() {
        return forecast;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "location=" + location +
                ", current=" + current +
                ", forecast=" + forecast +
                '}';
    }
}
