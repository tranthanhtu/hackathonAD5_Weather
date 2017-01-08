package com.example.hau.newweather.network;

import com.example.hau.newweather.configs.Constant;
import com.example.hau.newweather.models.json.api_yahoo.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hau on 31/12/2016.
 */

public interface APIWeatherYahoo {
    @GET(Constant.API_YAHOO_WEATHER)
    Call<Weather> callQuery(@Query("q") String q, @Query("format") String format);
}
