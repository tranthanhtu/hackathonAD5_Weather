package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Hau on 08/01/2017.
 */

public class Day extends RealmObject {
    @SerializedName("maxtemp_c")
    private String maxTempC;
    @SerializedName("maxtemp_f")
    private String maxTempF;
    @SerializedName("mintemp_c")
    private String minTempC;
    @SerializedName("mintemp_f")
    private String minTempF;
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

    public String getMinTempC() {
        return minTempC;
    }

    public String getMinTempF() {
        return minTempF;
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
