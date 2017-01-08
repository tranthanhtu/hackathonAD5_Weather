package com.example.hau.newweather.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Hau on 08/01/2017.
 */

public class ForeCastDay {
    @SerializedName("date")
    private String date;
    @SerializedName("date_epoch")
    private String dateEpoch;
    @SerializedName("day")
    private Day day;
    @SerializedName("astro")
    private Astro astro;
    @SerializedName("hour")
    ArrayList<Hour> list;

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

    public ArrayList<Hour> getList() {
        return list;
    }
}
