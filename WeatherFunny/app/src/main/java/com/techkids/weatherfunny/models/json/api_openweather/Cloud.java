package com.techkids.weatherfunny.models.json.api_openweather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Cloud {
    @SerializedName("all")
    private int all;

    public int getAll() {
        return all;
    }
}
