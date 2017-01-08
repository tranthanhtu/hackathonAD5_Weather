package com.example.hau.newweather.network;

import com.example.hau.newweather.configs.Constant;
import com.example.hau.newweather.models.json.api_openweather.City;
import com.example.hau.newweather.models.json.api_openweather.Timeline;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hau on 08/01/2017.
 */

public interface APIWeatherOpenWeather {
    @GET(Constant.API_OPEN_WEATHER)
    Call<City> getWeatherCity(@Query("q") String q, @Query("appid") String appid);
}
