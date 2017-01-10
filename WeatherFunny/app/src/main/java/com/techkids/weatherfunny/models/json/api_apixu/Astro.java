package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Hau on 08/01/2017.
 */

public class Astro extends RealmObject {
    @SerializedName("sunrise")
    private String sunRise;
    @SerializedName("sunset")
    private String sunSet;
    @SerializedName("moonrise")
    private String moonRise;
    @SerializedName("moonset")
    private String moonSet;

    public String getSunRise() {
        return sunRise;
    }

    public String getSunSet() {
        return sunSet;
    }

    public String getMoonRise() {
        return moonRise;
    }

    public String getMoonSet() {
        return moonSet;
    }
}
