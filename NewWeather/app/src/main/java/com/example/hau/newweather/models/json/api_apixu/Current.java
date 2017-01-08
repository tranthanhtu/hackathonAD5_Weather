package com.example.hau.newweather.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Current {
    @SerializedName("last_updated_epoch")
    private int lastUpdateEpoch;
    @SerializedName("last_updated")
    private String lastUpdate;
    @SerializedName("temp_c")
    private int tempC;
    @SerializedName("temp_f")
    private int tempF;
    @SerializedName("is_day")
    private int isDay;
    @SerializedName("condition")
    private Condition condition;
    @SerializedName("wind_mph")
    private int windMph;
    @SerializedName("wind_kph")
    private int windKph;
    @SerializedName("wind_degree")
    private int windDegree;
    @SerializedName("wind_dir")
    private String windDir;
    @SerializedName("pressure_mb")
    private int pressureMb;
    @SerializedName("pressure_in")
    private int pressureIn;
    @SerializedName("precip_mm")
    private int precipMM;
    @SerializedName("precip_in")
    private int precipIn;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("cloud")
    private int cloud;
    @SerializedName("feelslike_c")
    private int feelslikeC;
    @SerializedName("feelslike_f")
    private int feelslikeF;

    public int getLastUpdateEpoch() {
        return lastUpdateEpoch;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public int getTempC() {
        return tempC;
    }

    public int getTempF() {
        return tempF;
    }

    public int getIsDay() {
        return isDay;
    }

    public Condition getCondition() {
        return condition;
    }

    public int getWindMph() {
        return windMph;
    }

    public int getWindKph() {
        return windKph;
    }

    public int getWindDegree() {
        return windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public int getPressureMb() {
        return pressureMb;
    }

    public int getPressureIn() {
        return pressureIn;
    }

    public int getPrecipMM() {
        return precipMM;
    }

    public int getPrecipIn() {
        return precipIn;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getCloud() {
        return cloud;
    }

    public int getFeelslikeC() {
        return feelslikeC;
    }

    public int getFeelslikeF() {
        return feelslikeF;
    }
}
