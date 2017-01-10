package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Hau on 08/01/2017.
 */

public class ConditionHour extends RealmObject {
    @SerializedName("text")
    private String text;
    @SerializedName("icon")
    private String icon;
    @SerializedName("code")
    private String code;

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public String getCode() {
        return code;
    }
}
