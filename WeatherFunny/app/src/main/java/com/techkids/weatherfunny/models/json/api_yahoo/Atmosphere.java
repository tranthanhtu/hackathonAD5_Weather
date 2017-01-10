package com.techkids.weatherfunny.models.json.api_yahoo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class Atmosphere {
    @SerializedName("humidity")
    private String humiditi;
    @SerializedName("pressure")
    private String pressure;
    @SerializedName("rising")
    private String rising;
    @SerializedName("visibility")
    private String visibility;

    public String getHumiditi() {
        return humiditi;
    }

    public String getPressure() {
        return pressure;
    }

    public String getRising() {
        return rising;
    }

    public String getVisibility() {
        return visibility;
    }
}
