package com.techkids.weatherfunny.network;

import com.techkids.weatherfunny.configs.Constant;
import com.techkids.weatherfunny.models.json.api_yahoo.Weather;

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
