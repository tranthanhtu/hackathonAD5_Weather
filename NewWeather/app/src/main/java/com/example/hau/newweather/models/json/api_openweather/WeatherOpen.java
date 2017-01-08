package com.example.hau.newweather.models.json.api_openweather;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hau on 08/01/2017.
 */

public class WeatherOpen {
    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
