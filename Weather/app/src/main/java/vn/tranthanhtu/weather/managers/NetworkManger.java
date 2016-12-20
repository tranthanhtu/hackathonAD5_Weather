package vn.tranthanhtu.weather.managers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Hau on 25/10/2016.
 */
public class NetworkManger {
    private static NetworkManger instance;
    private ConnectivityManager connectivityManager;

    public static NetworkManger getInstance() {
        return instance;
    }

    public static void init(Context context) {
        instance = new NetworkManger(context);
    }

    private NetworkManger(Context context) {
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
