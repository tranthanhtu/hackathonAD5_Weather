package com.example.hau.newweather.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Day {
    @SerializedName("maxtemp_c")
    private int maxTempC;
    @SerializedName("maxtemp_f")
    private int maxTempF;
    @SerializedName("mintemp_c")
    private int minTempC;
    @SerializedName("mintemp_f")
    private int minTempF;
    @SerializedName("avgtemp_c")
    private int avgTempC;
    @SerializedName("avgtemp_f")
    private int avgTempF;
    @SerializedName("maxwind_mph")
    private int maxWindMph;
    @SerializedName("maxwind_kph")
    private int maxWindKph;
    @SerializedName("totalprecip_mm")
    private int totalPrecipMM;
    @SerializedName("totalprecip_in")
    private int totalPrecipIn;
    @SerializedName("condition")
    private ConditionDay conditionDay;

    public int getMaxTempC() {
        return maxTempC;
    }

    public int getMaxTempF() {
        return maxTempF;
    }

    public int getMinTempC() {
        return minTempC;
    }

    public int getMinTempF() {
        return minTempF;
    }

    public int getAvgTempC() {
        return avgTempC;
    }

    public int getAvgTempF() {
        return avgTempF;
    }

    public int getMaxWindMph() {
        return maxWindMph;
    }

    public int getMaxWindKph() {
        return maxWindKph;
    }

    public int getTotalPrecipMM() {
        return totalPrecipMM;
    }

    public int getTotalPrecipIn() {
        return totalPrecipIn;
    }

    public ConditionDay getConditionDay() {
        return conditionDay;
    }
}
