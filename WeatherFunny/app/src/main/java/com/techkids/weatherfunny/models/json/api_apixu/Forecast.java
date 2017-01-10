package com.techkids.weatherfunny.models.json.api_apixu;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Hau on 08/01/2017.
 */

public class Forecast extends RealmObject {
    @SerializedName("forecastday")
    RealmList<ForeCastDay> list;

    public RealmList<ForeCastDay> getList() {
        return list;
    }
}
