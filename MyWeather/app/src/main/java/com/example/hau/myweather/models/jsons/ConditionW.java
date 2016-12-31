package com.example.hau.myweather.models.jsons;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class ConditionW {
    @SerializedName("code")
    private String code;
    @SerializedName("temp")
    private int temp;
    @SerializedName("text")
    private String text;

    public String getCode() {
        return code;
    }

    public int getTemp() {
        return temp;
    }

    public String getText() {
        return text;
    }
}
