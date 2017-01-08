package com.example.hau.newweather.models.json.api_yahoo;

import com.example.hau.newweather.models.json.api_yahoo.QueryW;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hau on 31/12/2016.
 */

public class Weather {
    @SerializedName("query")
    private QueryW query;

    public QueryW getQuery() {
        return query;
    }
}
