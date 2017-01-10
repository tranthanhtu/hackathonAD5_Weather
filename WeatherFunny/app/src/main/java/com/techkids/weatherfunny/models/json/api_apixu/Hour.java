package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by Hau on 08/01/2017.
 */

public class Hour extends RealmObject {
    @SerializedName("time_epoch")
    private String timeEpoch;
    @SerializedName("time")
    private String time;
    @SerializedName("temp_c")
    private String tempC;
    @SerializedName("temp_f")
    private String tempF;
    @SerializedName("is_day")
    private String isDay;
    @SerializedName("condition")
    private ConditionHour conditionHour;
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
    private String feelsLikeC;
    @SerializedName("feelslike_f")
    private String feelsLikeF;
    @SerializedName("windchill_c")
    private String windChillC;
    @SerializedName("windchill_f")
    private String windChillF;
    @SerializedName("heatindex_c")
    private String heatIndexC;
    @SerializedName("heatindex_f")
    private String heatIndexF;
    @SerializedName("dewpoint_c")
    private String dewPointC;
    @SerializedName("dewpoint_f")
    private String dewPointF;
    @SerializedName("will_it_rain")
    private String willItRain;
    @SerializedName("will_it_snow")
    private String willItSnow;

    public String getTimeEpoch() {
        return timeEpoch;
    }

    public String getTime() {
        return time;
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

    public ConditionHour getConditionHour() {
        return conditionHour;
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

    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    public String getFeelsLikeF() {
        return feelsLikeF;
    }

    public String getWindChillC() {
        return windChillC;
    }

    public String getWindChillF() {
        return windChillF;
    }

    public String getHeatIndexC() {
        return heatIndexC;
    }

    public String getHeatIndexF() {
        return heatIndexF;
    }

    public String getDewPointC() {
        return dewPointC;
    }

    public String getDewPointF() {
        return dewPointF;
    }

    public String getWillItRain() {
        return willItRain;
    }

    public String getWillItSnow() {
        return willItSnow;
    }
}
