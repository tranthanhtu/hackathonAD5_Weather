package com.example.hau.newweather.services;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.example.hau.newweather.configs.Constant;
import com.example.hau.newweather.eventbus.LoadDataFailEvent;
import com.example.hau.newweather.eventbus.LoadDataSuccessEvent;
import com.example.hau.newweather.models.json.api_apixu.Weather;
import com.example.hau.newweather.network.APIWeatherAPIXUHelper;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hau on 09/01/2017.
 */

public class LoadDataService extends Service {
    private static final String TAG = LoadDataService.class.toString();
    private static final int MY_PERMISSION_REQUEST_LOCATION = 1;
    private String city;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
        loadLocation();


//        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    private void loadLocation() {

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

        city = hereLocation(location.getLatitude(), location.getLongitude());
        Log.d(TAG, String.format("onCreate: %s", city));

        loadData(Uri.encode(city));


    }

    private void loadData(String city) {
        APIWeatherAPIXUHelper.getInstance()
                .getApiWeatherAPIXU()
                .getWeather(Constant.KEY_API, city)
                .enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Response<Weather> response) {
                        Log.d(TAG, "onResponse: " + response.body().toString());
                        Weather weather = response.body();
                        Log.d(TAG, weather.getCurrent().toString() );
                        EventBus.getDefault().post(new LoadDataSuccessEvent(weather));
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.d(TAG, "onFailure: " + t.toString());
                        EventBus.getDefault().post(new LoadDataFailEvent());
                    }
                });
    }


    public String hereLocation(double lat, double lon){
        String curCity = "";

        Geocoder geocoder = new Geocoder(LoadDataService.this, Locale.getDefault());

        List<Address> addresses;

        try {
            addresses = geocoder.getFromLocation(lat, lon, 1);
            if (addresses.size() > 0){
                curCity = addresses.get(0).getLocality();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return curCity;

    }
}
