package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Hau on 08/01/2017.
 */

public class Location extends RealmObject{
    @SerializedName("name")
    private String name;
    @SerializedName("region")
    private String region;
    @SerializedName("country")
    private String country;
    @SerializedName("lat")
    private String lat;
    @SerializedName("lon")
    private String lon;
    @SerializedName("tz_id")
    private String tzId;
    @SerializedName("localtime_epoch")
    private String localTime;
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

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getTzId() {
        return tzId;
    }

    public String getLocalTime() {
        return localTime;
    }

    public String getLocalTimel() {
        return localTimel;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", country='" + country + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", tzId='" + tzId + '\'' +
                ", localTime='" + localTime + '\'' +
                ", localTimel='" + localTimel + '\'' +
                '}';
    }
}
