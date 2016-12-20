package vn.tranthanhtu.weather.data;

import org.json.JSONObject;

/**
 * Created by Dell latitude E6520 on 11/30/2016.
 */

public class Units implements JSONPopulator{
    private String temperator;

    public String getTemperator() {
        return temperator;
    }

    @Override
    public void populate(JSONObject data) {
        temperator = data.optString("temperature");
    }
}
