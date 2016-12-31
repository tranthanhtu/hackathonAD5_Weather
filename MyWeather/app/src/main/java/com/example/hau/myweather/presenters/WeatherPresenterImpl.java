package com.example.hau.myweather.presenters;

import android.util.Log;

import com.example.hau.myweather.apihelpers.APIHelper;
import com.example.hau.myweather.models.beans.Condition;
import com.example.hau.myweather.models.jsons.ForecastItem;
import com.example.hau.myweather.models.jsons.Weather;
import com.example.hau.myweather.utils.Utils;
import com.example.hau.myweather.views.activities.WeatherActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Hau on 31/12/2016.
 */

public class WeatherPresenterImpl implements WeatherPresenter {

    private WeatherActivity weatherActivity;

    public WeatherPresenterImpl(WeatherActivity weatherActivity) {
        this.weatherActivity = weatherActivity;
    }

    @Override
    public void check(String nameCity) {

        String query = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")", nameCity);
        String format = "json";
        APIHelper.getInstance()
                .getApiWeather()
                .callQuery(query, format)
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        Log.d(TAG, "onResponse: ");
                        Weather weather = response.body();
                        Condition.list.clear();
                        for (ForecastItem forecastItem : weather.getQuery().getResultW().getChannelW().getItemW().getItemList()) {
                            Condition.list.add(new Condition(
                                    forecastItem.getDay(),
                                    forecastItem.getMtext(),
                                    forecastItem.getHigh(),
                                    forecastItem.getLow(),
                                    Utils.loadImage(forecastItem.getCode())
                            ));
                        }
                        weatherActivity.updateUI(weather);
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        Log.d(TAG, "onFailure: ");
                    }
                });

    }
}
