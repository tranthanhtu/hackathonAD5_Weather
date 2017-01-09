package com.example.hau.newweather.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Day {
    @SerializedName("maxtemp_c")
    private String maxTempC;
    @SerializedName("maxtemp_f")
    private String maxTempF;
    @SerializedName("temp_c")
    private String tempC;
    @SerializedName("temp_f")
    private String tempF;
    @SerializedName("avgtemp_c")
    private String avgTempC;
    @SerializedName("avgtemp_f")
    private String avgTempF;
    @SerializedName("maxwind_mph")
    private String maxWindMph;
    @SerializedName("maxwind_kph")
    private String maxWindKph;
    @SerializedName("totalprecip_mm")
    private String totalPrecipMM;
    @SerializedName("totalprecip_in")
    private String totalPrecipIn;
    @SerializedName("condition")
    private ConditionDay conditionDay;

    public String getMaxTempC() {
        return maxTempC;
    }

    public String getMaxTempF() {
        return maxTempF;
    }

    public String getTempC() {
        return tempC;
    }

    public String getTempF() {
        return tempF;
    }

    public String getAvgTempC() {
        return avgTempC;
    }

    public String getAvgTempF() {
        return avgTempF;
    }

    public String getMaxWindMph() {
        return maxWindMph;
    }

    public String getMaxWindKph() {
        return maxWindKph;
    }

    public String getTotalPrecipMM() {
        return totalPrecipMM;
    }

    public String getTotalPrecipIn() {
        return totalPrecipIn;
    }

    public ConditionDay getConditionDay() {
        return conditionDay;
    }
}
