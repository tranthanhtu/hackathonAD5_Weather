package com.example.hau.newweather.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Location {
    @SerializedName("name")
    private String name;
    @SerializedName("region")
    private String region;
    @SerializedName("country")
    private String country;
    @SerializedName("lat")
    private float lat;
    @SerializedName("lon")
    private float lon;
    @SerializedName("tz_id")
    private String tzId;
    @SerializedName("localtime_epoch")
    private int localTime;
    @SerializedName("localtime")
    private String localTimel;

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public String getTzId() {
        return tzId;
    }

    public int getLocalTime() {
        return localTime;
    }

    public String getLocalTimel() {
        return localTimel;
    }
}
