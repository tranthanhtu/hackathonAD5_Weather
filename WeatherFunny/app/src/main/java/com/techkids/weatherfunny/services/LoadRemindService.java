package com.techkids.weatherfunny.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.techkids.weatherfunny.managers.Preferrences;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_trolyfacebook.Message;
import com.techkids.weatherfunny.models.json.api_trolyfacebook.Remind;
import com.techkids.weatherfunny.network.APITroLyFacebookHelper;
import com.techkids.weatherfunny.utils.StringUtils;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hau on 15/01/2017.
 */

public class LoadRemindService extends IntentService{
    public static final String TAG = LoadRemindService.class.toString();
    public LoadRemindService() {
        super("LoadRemindService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        APITroLyFacebookHelper.getInstance()
                .getApiTroLyFacebook()
                .getRemind(StringUtils.removeAccent(Preferrences.getInstance().getCity()))
                .enqueue(new Callback<Message>() {
                    @Override
                    public void onResponse(Response<Message> response) {
                        Message message = response.body();
                        Log.d(TAG, "onResponse: " + message.getList().get(6).getText());
                        if (message.getList().get(6) != null) {
                            RealmHandler.getInstance().addMessage(message);
                        }
                        EventBus.getDefault().post(new LoadRemindService());
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
    }
}
