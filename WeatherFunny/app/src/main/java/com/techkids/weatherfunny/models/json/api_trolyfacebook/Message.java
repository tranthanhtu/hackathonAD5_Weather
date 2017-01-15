package com.techkids.weatherfunny.models.json.api_trolyfacebook;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Hau on 15/01/2017.
 */

public class Message extends RealmObject{
    @SerializedName("messages")
    RealmList<Remind> list;

    public List<Remind> getList() {
        return list;
    }
}
