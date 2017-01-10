package com.techkids.weatherfunny.models.json.api_yahoo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class WindW {
    @SerializedName("chill")
    private String chill;
    @SerializedName("direction")
    private String direction;
    @SerializedName("speed")
    private String speed;

    public String getChill() {
        return chill;
    }

    public String getDirection() {
        return direction;
    }

    public String getSpeed() {
        return speed;
    }
}
