package com.techkids.weatherfunny.services;

import android.Manifest;
import android.app.IntentService;
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

import com.techkids.weatherfunny.eventbus.LoadLocationSuccessEvent;
import com.techkids.weatherfunny.managers.Preferrences;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Locale;

/**
 * Created by Hau on 10/01/2017.
 */

public class LoadLocationService extends IntentService{

    private static final String TAG = LoadLocationService.class.toString();
    private String city;


    public LoadLocationService() {
        super("LoadLocationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        loadLocation();
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

//        city = hereLocation(location.getLatitude(), location.getLongitude());

        city = "Ha noi";
        Log.d(TAG, "loadLocation: " + city);

        Preferrences.getInstance().putCity(city);
        Log.d(TAG, String.format("onCreate: %s", city));
        EventBus.getDefault().post(new LoadLocationSuccessEvent());
    }

    public String hereLocation(double lat, double lon){
        String curCity = "";

        Geocoder geocoder = new Geocoder(LoadLocationService.this, Locale.getDefault());

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
