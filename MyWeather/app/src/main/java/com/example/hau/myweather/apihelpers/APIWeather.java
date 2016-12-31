package com.example.hau.myweather.apihelpers;

import com.example.hau.myweather.models.jsons.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hau on 31/12/2016.
 */

public interface APIWeather {
    @GET("/v1/public/yql")
    Call<Weather> callQuery(@Query("q") String q, @Query("format") String format);
}
