package com.techkids.weatherfunny.services;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import com.techkids.weatherfunny.configs.Constant;
import com.techkids.weatherfunny.eventbus.LoadDataFailEvent;
import com.techkids.weatherfunny.eventbus.LoadDataSuccessEvent;
import com.techkids.weatherfunny.managers.Preferrences;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.ForeCastDay;
import com.techkids.weatherfunny.models.json.api_apixu.Forecast;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.network.APIWeatherAPIXUHelper;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hau on 10/01/2017.
 */

public class LoadDataFromAPIService extends IntentService {
    public static final String TAG = LoadDataFromAPIService.class.toString();

    public LoadDataFromAPIService() {
        super("LoadDataFromAPIService");
        Log.d(TAG, "LoadDataFromAPIService: ");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent: ");
        APIWeatherAPIXUHelper.getInstance()
                .getApiWeatherAPIXU()
                .getWeather(Constant.KEY_API, Uri.encode(Preferrences.getInstance().getCity()))
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Response<Weather> response) {
                        Log.d(TAG, "onResponse: " + response.body().toString());
                        Weather weather = response.body();
                        Log.d(TAG, weather.getCurrent().toString() );

                        RealmHandler.getInstance().addWeather(weather);

                        EventBus.getDefault().postSticky(new LoadDataSuccessEvent(weather));
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                        EventBus.getDefault().postSticky(new LoadDataFailEvent());
                    }
                });
    }
}
