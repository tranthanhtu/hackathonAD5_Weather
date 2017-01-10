package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Hau on 08/01/2017.
 */

public class ForeCastDay extends RealmObject {
    @SerializedName("date")
    private String date;
    @SerializedName("date_epoch")
    private String dateEpoch;
    @SerializedName("day")
    private Day day;
    @SerializedName("astro")
    private Astro astro;
    @SerializedName("hour")
    RealmList<Hour> list;

    public String getDate() {
        return date;
    }

    public String getDateEpoch() {
        return dateEpoch;
    }

    public Day getDay() {
        return day;
    }

    public Astro getAstro() {
        return astro;
    }

    public RealmList<Hour> getList() {
        return list;
    }
}
