package com.example.hau.newweather.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class ConditionHour {
    @SerializedName("text")
    private String text;
    @SerializedName("icon")
    private String icon;
    @SerializedName("code")
    private int code;

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public int getCode() {
        return code;
    }
}
