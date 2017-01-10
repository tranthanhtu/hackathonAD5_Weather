package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Hau on 08/01/2017.
 */

public class Current extends RealmObject {
    @SerializedName("last_updated_epoch")
    private String lastUpdateEpoch;
    @SerializedName("last_updated")
    private String lastUpdate;
    @SerializedName("temp_c")
    private String tempC;
    @SerializedName("temp_f")
    private String tempF;
    @SerializedName("is_day")
    private String isDay;
    @SerializedName("condition")
    private Condition condition;
    @SerializedName("wind_mph")
    private String windMph;
    @SerializedName("wind_kph")
    private String windKph;
    @SerializedName("wind_degree")
    private String windDegree;
    @SerializedName("wind_dir")
    private String windDir;
    @SerializedName("pressure_mb")
    private String pressureMb;
    @SerializedName("pressure_in")
    private String pressureIn;
    @SerializedName("precip_mm")
    private String precipMM;
    @SerializedName("precip_in")
    private String precipIn;
    @SerializedName("humidity")
    private String humidity;
    @SerializedName("cloud")
    private String cloud;
    @SerializedName("feelslike_c")
    private String feelslikeC;
    @SerializedName("feelslike_f")
    private String feelslikeF;

    public String getLastUpdateEpoch() {
        return lastUpdateEpoch;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public String getTempC() {
        return tempC;
    }

    public String getTempF() {
        return tempF;
    }

    public String getIsDay() {
        return isDay;
    }

    public Condition getCondition() {
        return condition;
    }

    public String getWindMph() {
        return windMph;
    }

    public String getWindKph() {
        return windKph;
    }

    public String getWindDegree() {
        return windDegree;
    }

    public String getWindDir() {
        return windDir;
    }

    public String getPressureMb() {
        return pressureMb;
    }

    public String getPressureIn() {
        return pressureIn;
    }

    public String getPrecipMM() {
        return precipMM;
    }

    public String getPrecipIn() {
        return precipIn;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getCloud() {
        return cloud;
    }

    public String getFeelslikeC() {
        return feelslikeC;
    }

    public String getFeelslikeF() {
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
