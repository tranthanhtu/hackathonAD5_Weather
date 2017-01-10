package com.techkids.weatherfunny.models.json.api_openweather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Wind {
    @SerializedName("speed")
    private int speed;
    @SerializedName("deg")
    private int deg;

    public int getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }
}
