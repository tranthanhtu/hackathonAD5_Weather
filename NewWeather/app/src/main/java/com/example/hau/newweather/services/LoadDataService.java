package com.example.hau.newweather.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.hau.newweather.configs.Constant;
import com.example.hau.newweather.eventbus.LoadDataFailEvent;
import com.example.hau.newweather.eventbus.LoadDataSuccessEvent;
import com.example.hau.newweather.models.json.api_apixu.Weather;
import com.example.hau.newweather.network.APIWeatherAPIXUHelper;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hau on 09/01/2017.
 */

public class LoadDataService extends Service {
    private static final String TAG = LoadDataService.class.toString();

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        loadData();
        return null;
    }

    private void loadData() {
        APIWeatherAPIXUHelper.getInstance()
                .getApiWeatherAPIXU()
                .getWeather(Constant.KEY_API, "10000")
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Response<Weather> response) {
                        Log.d(TAG, "onResponse: ");
                        Weather weather = response.body();
                        Log.d(TAG, weather.getCurrent().toString() );
                        EventBus.getDefault().post(new LoadDataSuccessEvent());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                        EventBus.getDefault().post(new LoadDataFailEvent());
                    }
                });
    }
}
