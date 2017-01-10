package com.techkids.weatherfunny.models.json.api_yahoo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class ForecastItem {
    @SerializedName("day")
    private String day;

    @SerializedName("text")
    private String mtext;

    @SerializedName("high")
    private String high;

    @SerializedName("low")
    private String low;

    @SerializedName("code")
    private String code;

    public String getCode() {
        return code;
    }

    public String getMtext() {
        return mtext;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getDay() {
        return day;
    }
}
