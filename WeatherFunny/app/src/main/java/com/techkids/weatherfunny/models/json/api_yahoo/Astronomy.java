package com.techkids.weatherfunny.models.json.api_yahoo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class Astronomy {
    @SerializedName("sunrise")
    private String sunrise;
    @SerializedName("sunset")
    private String sunset;

    public String getSunrise() {
        return sunrise;
    }

    public String getSunset() {
        return sunset;
    }
}
