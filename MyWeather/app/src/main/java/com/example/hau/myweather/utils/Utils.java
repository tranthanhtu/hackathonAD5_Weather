package com.example.hau.myweather.utils;

import android.content.Context;

/**
 * Created by Hau on 31/12/2016.
 */

public class Utils {
    private static Utils _sharePointer;
    private static Context context;

    public static Utils getInstance() {
        return _sharePointer;
    }

    private Utils(Context context) {
        Utils.context = context;
    }

    public static void init(Context context) {
        _sharePointer = new Utils(context);
    }

    public static int loadImage(String id) {
        return context.getResources().getIdentifier("icon_" + id, "drawable", context.getPackageName());
    }

    public static int loadBackground(String id) {
        return context.getResources().getIdentifier("background_" + id, "drawable", context.getPackageName());
    }
}
