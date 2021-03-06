package com.example.hau.myweather.managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Hau on 25/10/2016.
 */
public class NetworkManager {
    private static NetworkManager instance;
    private ConnectivityManager connectivityManager;

    public static NetworkManager getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new NetworkManager(context);
    }

    private NetworkManager(Context context) {
        this.connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isConnectedToInternet() {
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
