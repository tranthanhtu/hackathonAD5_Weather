package com.example.hau.myweather.views.activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hau.myweather.R;
import com.example.hau.myweather.constants.Preferences;
import com.example.hau.myweather.managers.NetworkManager;
import com.example.hau.myweather.models.beans.Condition;
import com.example.hau.myweather.models.jsons.Astronomy;
import com.example.hau.myweather.models.jsons.Atmosphere;
import com.example.hau.myweather.models.jsons.ChannelW;
import com.example.hau.myweather.models.jsons.ConditionW;
import com.example.hau.myweather.models.jsons.ItemW;
import com.example.hau.myweather.models.jsons.Weather;
import com.example.hau.myweather.models.jsons.WindW;
import com.example.hau.myweather.presenters.WeatherPresenter;
import com.example.hau.myweather.presenters.WeatherPresenterImpl;
import com.example.hau.myweather.services.SampleBootReceiver;
import com.example.hau.myweather.utils.Utils;
import com.example.hau.myweather.views.adapters.ConditionAdapter;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WeatherActivityImpl extends AppCompatActivity implements WeatherActivity {

    private static final String TAG = WeatherActivityImpl.class.toString();
    private WeatherPresenter weatherPresenter;
    private ConditionAdapter conditionAdapter;

    @BindView(R.id.rv_list_condition)
    RecyclerView rvCondition;
    @BindView(R.id.edt_city)
    EditText edtCity;
    @BindView(R.id.tv_namecity)
    TextView tvNameCity;
    @BindView(R.id.tv_temperatorF)
    TextView tvTempF;
    @BindView(R.id.tv_temperatorC)
    TextView tvTempC;
    @BindView(R.id.tv_condition)
    TextView tvCondition;
    @BindView(R.id.imv_weatherIcon)
    ImageView imvWeatherIcon;
    @BindView(R.id.weather)
    ScrollView background;
    @BindView(R.id.tv_sunrise)
    TextView tvSunrise;
    @BindView(R.id.tv_sunset)
    TextView tvSunset;
    @BindView(R.id.tv_chill)
    TextView tvChill;
    @BindView(R.id.tv_direction)
    TextView tvDirection;
    @BindView(R.id.tv_speed)
    TextView tvSpeed;
    @BindView(R.id.tv_humidity)
    TextView tvHumidity;
    @BindView(R.id.tv_pressure)
    TextView tvPressure;
    @BindView(R.id.tv_rising)
    TextView tvRising;
    @BindView(R.id.tv_visibility)
    TextView tvVisibility;
    @BindView(R.id.fab)
    FloatingActionButton fabMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        ButterKnife.bind(this);
        Utils.init(this);
        NetworkManager.init(this);
        Preferences.init(this);
        weatherPresenter = new WeatherPresenterImpl(this);
        setupUI();
        if (!Preferences.getInstance().getCity().equals("")) {
            weatherPresenter.check(Preferences.getInstance().getCity());
        }
        setNotificationAlarm();
        Log.d(TAG, "onCreate: ");
    }

    private void setNotificationAlarm() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 12);
        calendar.set(Calendar.SECOND, 00);

        Intent intent = new Intent(getApplicationContext(), SampleBootReceiver.class);

        PendingIntent pendingIntent = PendingIntent
                .getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                pendingIntent);
    }

    private void setupUI() {
        fabMessage.setVisibility(View.VISIBLE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//Add this to your Recyclerview

        rvCondition.setLayoutManager(layoutManager);

        rvCondition.setHasFixedSize(true);

        conditionAdapter = new ConditionAdapter();

        rvCondition.setAdapter(conditionAdapter);

        fabMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pushDataToMessage();
            }
        });
    }

    private void pushDataToMessage() {
        Intent intent = new Intent(WeatherActivityImpl.this, ContactActivityImpl.class);
        intent.putExtra("temperatureF", tvTempF.getText().toString());
        intent.putExtra("temperatureC", tvTempC.getText().toString());
        intent.putExtra("condition", tvCondition.getText().toString());
        startActivity(intent);
    }

    @Override
    public void updateUI(Weather weather) {
        // get referrence
        ChannelW channelW = weather.getQuery().getResultW().getChannelW();
        ItemW itemW = channelW.getItemW();
        Astronomy astronomy = channelW.getAstronomy();
        WindW windW = channelW.getWindW();
        Atmosphere atmosphere = channelW.getAtmosphere();
        ConditionW conditionW = itemW.getConditionW();

        // update UI
        tvNameCity.setText(itemW.getTitle());
        tvTempF.setText(conditionW.getTemp() + "°F");
        float c = (conditionW.getTemp() - 32) / 1.8f;
        tvTempC.setText(c + "°C");
        tvCondition.setText(conditionW.getText());
        imvWeatherIcon.setImageResource(Utils.loadImage(conditionW.getCode()));
        background.setBackgroundResource(Utils.loadBackground(conditionW.getCode()));

        tvSunrise.setText(astronomy.getSunrise());
        tvSunset.setText(astronomy.getSunset());

        tvChill.setText(windW.getChill());
        tvDirection.setText(windW.getDirection());
        tvSpeed.setText(windW.getSpeed());

        tvHumidity.setText(atmosphere.getHumiditi());
        tvPressure.setText(atmosphere.getPressure());
        tvRising.setText(atmosphere.getRising());
        tvVisibility.setText(atmosphere.getVisibility());

        conditionAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.btn_check)
    public void onCheck() {
        Log.d(TAG, "onCheck: ");
        Preferences.getInstance().putCity(edtCity.getText().toString());
        if (NetworkManager.getInstance().isConnectedToInternet()) {
            Log.d(TAG, "onCheck: Internet");
            if (checkCity()) {
                weatherPresenter.check(edtCity.getText().toString());
            } else {
                edtCity.setText("hanoi");
                weatherPresenter.check(edtCity.getText().toString());
            }
        } else {
            Toast.makeText(this, "No Internet Access!", Toast.LENGTH_SHORT).show();
        }
        edtCity.setText("");
        fabMessage.setVisibility(View.VISIBLE);
    }

    public boolean checkCity() {
        return edtCity.getText().toString().length() > 0;
    }


}
