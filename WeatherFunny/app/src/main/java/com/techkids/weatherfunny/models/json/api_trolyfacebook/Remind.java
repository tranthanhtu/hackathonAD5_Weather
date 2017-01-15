package com.techkids.weatherfunny.models.json.api_trolyfacebook;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Hau on 15/01/2017.
 */

public class Remind extends RealmObject {
    @SerializedName("text")
    private String text;

    public String getText() {
        return text;
    }
}
