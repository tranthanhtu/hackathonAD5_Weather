package com.techkids.weatherfunny.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.eventbus.BaseEvent;
import com.techkids.weatherfunny.eventbus.LoadRemindEvent;
import com.techkids.weatherfunny.managers.NetworkManager;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.models.json.api_trolyfacebook.Message;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogActivity extends AppCompatActivity {

    @BindView(R.id.iv_icon_dialog)
    ImageView ivIcon;
    @BindView(R.id.tv_remind)
    TextView tvRemind;
    Message message;
    Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
        if (NetworkManager.getInstance().isConnectedToInternet()){
            message = RealmHandler.getInstance().getMessage();
            weather = RealmHandler.getInstance().getWeather();
        }
        if (message != null && weather != null){
            setupUI();
        }
    }

    private void setupUI() {
        if (weather != null){
            if (weather.getCurrent().getCondition().getCode() == "1072"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1150"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1153"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1168"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1171"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1183"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1189"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1195"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1198"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1201"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1237"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1240"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1243"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1246"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1261"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1264"){
                loadGif();
            }else if (weather.getCurrent().getCondition().getCode() == "1087"){
                ivIcon.setImageResource(R.drawable.tango_weather_storm);
            }else if (weather.getCurrent().getCondition().getCode() == "1273"){
                ivIcon.setImageResource(R.drawable.tango_weather_storm);
            }else if (weather.getCurrent().getCondition().getCode() == "1276"){
                ivIcon.setImageResource(R.drawable.tango_weather_storm);
            }else if (weather.getCurrent().getCondition().getCode() == "1279"){
                ivIcon.setImageResource(R.drawable.tango_weather_storm);
            }else if (weather.getCurrent().getCondition().getCode() == "1282"){
                ivIcon.setImageResource(R.drawable.tango_weather_storm);
            }
        }else {
            ivIcon.setImageResource(R.drawable.alert);
        }


        if (message != null) {
            tvRemind.setText(message.getList().get(6).getText());
        } else {
            tvRemind.setText("Chửa có gì để show");
        }

    }

    private void loadGif(){
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(ivIcon);
        Glide.with(this).load(R.drawable.rain).into(target);
    }

}
