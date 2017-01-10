package com.techkids.weatherfunny.models.json.api_openweather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Rain {
    @SerializedName("3h")
    private int hhh;

    public int getHhh() {
        return hhh;
    }
}
