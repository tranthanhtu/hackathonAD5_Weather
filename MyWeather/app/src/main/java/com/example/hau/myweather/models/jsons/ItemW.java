package com.example.hau.myweather.models.jsons;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hau on 31/12/2016.
 */

public class ItemW {
    @SerializedName("title")
    private String title;

    public String getTitle() {
        return title;
    }

    @SerializedName("condition")
    private ConditionW conditionW;

    public ConditionW getConditionW() {
        return conditionW;
    }

    @SerializedName("forecast")
    private List<ForecastItem> itemList;

    public List<ForecastItem> getItemList() {
        return itemList;
    }
}
