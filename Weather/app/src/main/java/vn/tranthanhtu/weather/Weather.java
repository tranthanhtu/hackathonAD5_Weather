package vn.tranthanhtu.weather;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.tranthanhtu.weather.adapters.ConditionAdapter;
import vn.tranthanhtu.weather.managers.NetworkManger;
import vn.tranthanhtu.weather.models.ConditionModel;
import vn.tranthanhtu.weather.service.WeatherSevice;

public class Weather extends AppCompatActivity  {
    private static final String TAG = Weather.class.toString();

    private ScrollView background;
    private ImageView iconWeather;
    private TextView temperatureF;
    private TextView condition;
    private TextView cityname;
    private TextView temperatureC;
    private EditText city;
    private Button check;
    private RecyclerView rvCondition;
    private ConditionAdapter adapter;

    private TextView tvSunrise;
    private TextView tvSunset;
    private TextView tvHumidity;
    private TextView tvPressure;
    private TextView tvRising;
    private TextView tvVisibility;
    private TextView tvChill;
    private TextView tvDirection;
    private TextView tvSpeed;
    private FloatingActionButton fab;

    private NotificationCompat.Builder notBuilder;
    private static final int MY_NOTIFICATION_ID = 12345;
    private static final int MY_REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        NetworkManger.init(this);
        this.notBuilder = new NotificationCompat.Builder(this);
        getReferences();
        setupUI();
        setupNotification();
    }

    private void setupNotification() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Date date = new Date(System.currentTimeMillis());
                                int hour = date.getHours();
                                int minute = date.getMinutes();
                                int second = date.getSeconds();
                                if (hour == 7 && minute == 00 && second == 00){
                                    Log.d(TAG, "onCreate: succesful");
                                }
                                String stringDate = DateFormat.getTimeInstance().format(date);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();
    }

    private void setApdater() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//Add this to your Recyclerview
        rvCondition.setLayoutManager(layoutManager);

        rvCondition.setHasFixedSize(true);

        adapter = new ConditionAdapter();

        rvCondition.setAdapter(adapter);
    }


    private void setupUI() {
        fab.setVisibility(View.GONE);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkManger.getInstance().isConnectedToInternet() && rvCondition != null) {
                    if (city.getText().length() == 0){
//                        service.refreshWeather("Ha Noi");
                        cityname.setText("Ha Noi");
                        city.setText("hanoi");
                        getDataFromWeatherAPI();
                        city.setText("");
                    }
                    else {
                        getDataFromWeatherAPI();
                        city.setText("");
                    }
                    setApdater();
                } else if (NetworkManger.getInstance().isConnectedToInternet() && rvCondition == null){
                    Toast.makeText(Weather.this, "Checked!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Weather.this, "No Internet Access!", Toast.LENGTH_SHORT).show();
                }
                fab.setVisibility(View.VISIBLE);
                notiButtonClicked(null);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Weather.this, ListContact.class);
                startActivity(intent);
            }
        });
    }

    private void getDataFromWeatherAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherSevice sevice = retrofit.create(WeatherSevice.class);

        String query = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"%s\")", Uri.encode(city.getText().toString()));
        String format = "json";

        sevice.callQuery(query, format).enqueue(new Callback<WeatherSevice.Weather>() {
            @Override
            public void onResponse(Call<WeatherSevice.Weather> call, Response<WeatherSevice.Weather> response) {
                Log.d(TAG, "onResponse: ");
                WeatherSevice.Weather weather = response.body();
                Log.d(TAG, weather.toString());
                for (WeatherSevice.ForecastItem forecastItem : weather.getQuery().getResultW().getChannelW().getItemW().getItemList()){
                    ConditionModel.list.add(new ConditionModel(
                            forecastItem.getDay(),
                            forecastItem.getMtext(),
                            forecastItem.getHigh(),
                            forecastItem.getLow(),
                            loadImage(forecastItem.getCode())
                    ));
                }

                cityname.setText(weather.getQuery().getResultW().getChannelW().getItemW().getTitle());
                temperatureF.setText(weather.getQuery().getResultW().getChannelW().getItemW().getConditionW().getTemp() + "°F");
                float c;
                c = (weather.getQuery().getResultW().getChannelW().getItemW().getConditionW().getTemp() - 32) / 1.8f;
                temperatureC.setText(c + "°C");
                iconWeather.setImageResource(loadImage(weather.getQuery().getResultW().getChannelW().getItemW().getConditionW().getCode()));
                background.setBackgroundResource(loadBackground(weather.getQuery().getResultW().getChannelW().getItemW().getConditionW().getCode()));

                tvSunrise.setText(weather.getQuery().getResultW().getChannelW().getAstronomy().getSunrise());
                tvSunset.setText(weather.getQuery().getResultW().getChannelW().getAstronomy().getSunset());

                tvChill.setText(weather.getQuery().getResultW().getChannelW().getWindW().getChill());
                tvDirection.setText(weather.getQuery().getResultW().getChannelW().getWindW().getDirection());
                tvSpeed.setText(weather.getQuery().getResultW().getChannelW().getWindW().getSpeed());

                tvHumidity.setText(weather.getQuery().getResultW().getChannelW().getAtmosphere().getHumiditi());
                tvPressure.setText(weather.getQuery().getResultW().getChannelW().getAtmosphere().getPressure());
                tvRising.setText(weather.getQuery().getResultW().getChannelW().getAtmosphere().getRising());
                tvVisibility.setText(weather.getQuery().getResultW().getChannelW().getAtmosphere().getVisibility());

            }

            @Override
            public void onFailure(Call<WeatherSevice.Weather> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }



    private void getReferences() {
        background = (ScrollView) findViewById(R.id.weather);

        iconWeather = (ImageView) findViewById(R.id.imv_weatherIcon);
        temperatureF = (TextView) findViewById(R.id.tv_temperatorF);
        condition = (TextView) findViewById(R.id.tv_condition);
        city = (EditText) findViewById(R.id.edt_city);
        check = (Button) findViewById(R.id.btn_check);
        cityname = (TextView) findViewById(R.id.tv_namecity);
        temperatureC = (TextView) findViewById(R.id.tv_temperatorC);
        rvCondition = (RecyclerView) findViewById(R.id.rv_list_condition);

        tvSunrise = (TextView) findViewById(R.id.tv_sunrise);
        tvSunset = (TextView) findViewById(R.id.tv_sunset);
        tvHumidity = (TextView) findViewById(R.id.tv_humidity);
        tvPressure = (TextView) findViewById(R.id.tv_pressure);
        tvRising = (TextView) findViewById(R.id.tv_rising);
        tvVisibility = (TextView) findViewById(R.id.tv_visibility);
        tvChill = (TextView) findViewById(R.id.tv_chill);
        tvDirection = (TextView) findViewById(R.id.tv_direction);
        tvSpeed = (TextView) findViewById(R.id.tv_speed);

        fab = (FloatingActionButton) findViewById(R.id.fab);

    }



    public void notiButtonClicked(View view)  {

        // --------------------------
        // Prepare a notification
        // --------------------------
        this.notBuilder.setSmallIcon(R.drawable.icon_weather);
        this.notBuilder.setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher));
        this.notBuilder.setTicker("Today's Weather");

        // Set the time that the event occurred.
        // Notifications in the panel are sorted by this time.
        this.notBuilder.setWhen(System.currentTimeMillis()+ 10* 1000);
        this.notBuilder.setContentTitle(city.getText().toString());
        this.notBuilder.setContentText(String.format("Weather : %s, %s, %s",
                temperatureF.getText().toString(),
                temperatureC.getText().toString(),
                condition.getText().toString()));

        // Create Intent
        Intent intent = new Intent(this, Weather.class);

        // PendingIntent.getActivity(..) will start an Activity, and returns PendingIntent object.
        // It is equivalent to calling Context.startActivity(Intent).
        PendingIntent pendingIntent = PendingIntent.getActivity(this, MY_REQUEST_CODE,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        this.notBuilder.setContentIntent(pendingIntent);

        // Get a notification service (A service available on the system).
        NotificationManager notificationService  =
                (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);

        // Builds notification and issue it

        Notification notification =  notBuilder.build();
        notificationService.notify(MY_NOTIFICATION_ID, notification);

    }


    public void changeFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fl_container, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }

    private int loadImage(String id) {
        return this.getResources().getIdentifier("icon_" + id, "drawable", this.getPackageName());
    }

    private int loadBackground(String id){
        return this.getResources().getIdentifier("background_" + id, "drawable", this.getPackageName());
    }
}
