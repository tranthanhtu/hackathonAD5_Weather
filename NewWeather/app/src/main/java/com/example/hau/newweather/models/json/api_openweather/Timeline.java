package com.example.hau.newweather.models.json.api_openweather;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hau on 08/01/2017.
 */

public class Timeline {
    @SerializedName("dt_txt")
    private String dateTime;
    @SerializedName("main")
    private Main main;
    @SerializedName("clouds")
    private Cloud cloud;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("rain")
    private Rain rain;
    @SerializedName("weather")
    private ArrayList<WeatherOpen> weatherOpen;

    public String getDateTime() {
        return dateTime;
    }

    public Main getMain() {
        return main;
    }

    public Cloud getCloud() {
        return cloud;
    }

    public Wind getWind() {
        return wind;
    }

    public Rain getRain() {
        return rain;
    }

    public ArrayList<WeatherOpen> getWeatherOpen() {
        return weatherOpen;
    }
}
