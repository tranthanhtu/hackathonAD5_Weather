package com.techkids.weatherfunny.network;

import com.techkids.weatherfunny.configs.Constant;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hau on 09/01/2017.
 */

public interface APIWeatherAPIXU {
    @GET(Constant.API_APIXU)
    Call<Weather> getWeather(@Query("key") String key, @Query("q") String query, @Query("days") String day);

}
