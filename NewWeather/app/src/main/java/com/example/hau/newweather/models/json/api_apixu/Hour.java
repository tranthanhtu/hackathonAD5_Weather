package com.example.hau.newweather.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Hour {
    @SerializedName("time_epoch")
    private int timeEpoch;
    @SerializedName("time")
    private String time;
    @SerializedName("temp_c")
    private int tempC;
    @SerializedName("temp_f")
    private int tempF;
    @SerializedName("is_day")
    private int isDay;
    @SerializedName("condition")
    private ConditionHour conditionHour;
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
    private int feelsLikeC;
    @SerializedName("feelslike_f")
    private int feelsLikeF;
    @SerializedName("windchill_c")
    private int windChillC;
    @SerializedName("windchill_f")
    private int windChillF;
    @SerializedName("heatindex_c")
    private int heatIndexC;
    @SerializedName("heatindex_f")
    private int heatIndexF;
    @SerializedName("dewpoint_c")
    private int dewPointC;
    @SerializedName("dewpoint_f")
    private int dewPointF;
    @SerializedName("will_it_rain")
    private int willItRain;
    @SerializedName("will_it_snow")
    private int willItSnow;

    public int getTimeEpoch() {
        return timeEpoch;
    }

    public String getTime() {
        return time;
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

    public ConditionHour getConditionHour() {
        return conditionHour;
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

    public int getFeelsLikeC() {
        return feelsLikeC;
    }

    public int getFeelsLikeF() {
        return feelsLikeF;
    }

    public int getWindChillC() {
        return windChillC;
    }

    public int getWindChillF() {
        return windChillF;
    }

    public int getHeatIndexC() {
        return heatIndexC;
    }

    public int getHeatIndexF() {
        return heatIndexF;
    }

    public int getDewPointC() {
        return dewPointC;
    }

    public int getDewPointF() {
        return dewPointF;
    }

    public int getWillItRain() {
        return willItRain;
    }

    public int getWillItSnow() {
        return willItSnow;
    }
}
