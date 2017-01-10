package com.techkids.weatherfunny.network;

import com.techkids.weatherfunny.configs.Constant;
import com.techkids.weatherfunny.models.json.api_openweather.City;

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
