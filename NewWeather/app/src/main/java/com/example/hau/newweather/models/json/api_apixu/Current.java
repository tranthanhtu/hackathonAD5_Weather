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
    private float tempC;
    @SerializedName("temp_f")
    private float tempF;
    @SerializedName("is_day")
    private int isDay;
    @SerializedName("condition")
    private Condition condition;
    @SerializedName("wind_mph")
    private float windMph;
    @SerializedName("wind_kph")
    private float windKph;
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
    private float feelslikeC;
    @SerializedName("feelslike_f")
    private float feelslikeF;

    public int getLastUpdateEpoch() {
        return lastUpdateEpoch;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public float getTempC() {
        return tempC;
    }

    public float getTempF() {
        return tempF;
    }

    public int getIsDay() {
        return isDay;
    }

    public Condition getCondition() {
        return condition;
    }

    public float getWindMph() {
        return windMph;
    }

    public float getWindKph() {
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

    public float getFeelslikeC() {
        return feelslikeC;
    }

    public float getFeelslikeF() {
        return feelslikeF;
    }

    @Override
    public String toString() {
        return "Current{" +
                "lastUpdateEpoch=" + lastUpdateEpoch +
                ", lastUpdate='" + lastUpdate + '\'' +
                ", tempC=" + tempC +
                ", tempF=" + tempF +
                ", isDay=" + isDay +
                ", condition=" + condition +
                ", windMph=" + windMph +
                ", windKph=" + windKph +
                ", windDegree=" + windDegree +
                ", windDir='" + windDir + '\'' +
                ", pressureMb=" + pressureMb +
                ", pressureIn=" + pressureIn +
                ", precipMM=" + precipMM +
                ", precipIn=" + precipIn +
                ", humidity=" + humidity +
                ", cloud=" + cloud +
                ", feelslikeC=" + feelslikeC +
                ", feelslikeF=" + feelslikeF +
                '}';
    }
}
