package com.example.hau.newweather.models.json.api_openweather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 08/01/2017.
 */

public class Main {
    @SerializedName("temp")
    private int temp;
    @SerializedName("temp_min")
    private int tempMin;
    @SerializedName("temp_max")
    private int tempMax;
    @SerializedName("pressure")
    private int pressure;
    @SerializedName("sea_level")
    private int seaLevel;
    @SerializedName("grnd_level")
    private int grndLevel;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("temp_kf")
    private int tempKf;

    public int getTemp() {
        return temp;
    }

    public int getTempMin() {
        return tempMin;
    }

    public int getTempMax() {
        return tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public int getGrndLevel() {
        return grndLevel;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getTempKf() {
        return tempKf;
    }
}
