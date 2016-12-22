package vn.tranthanhtu.weather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.tranthanhtu.weather.adapters.ConditionAdapter;
import vn.tranthanhtu.weather.adapters.ContactAdapter;
import vn.tranthanhtu.weather.data.Channel;
import vn.tranthanhtu.weather.data.Item;
import vn.tranthanhtu.weather.managers.NetworkManger;
import vn.tranthanhtu.weather.models.ConditionModel;
import vn.tranthanhtu.weather.models.ContactModel;
import vn.tranthanhtu.weather.service.WeatherServiceCallback;
import vn.tranthanhtu.weather.service.WeatherSevice;
import vn.tranthanhtu.weather.service.YahooWeatherService;

public class Weather extends AppCompatActivity implements WeatherServiceCallback {
    private static final String TAG = Weather.class.toString();

    private RelativeLayout background;
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

    private YahooWeatherService service;
    private ProgressDialog dialog;

//    @Override
//    protected void onStop() {
//        super.onStop();
//        ConditionModel.list.clear();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        NetworkManger.init(this);
        getDataFromWeatherAPI();
        getReferences();
        service = new YahooWeatherService(Weather.this);
        setupUI();


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
        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLY);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NetworkManger.getInstance().isConnectedToInternet()) {
                    if (city.getText().length() == 0){
                        service.refreshWeather("Ha Noi");
                        cityname.setText("Ha Noi");
                    }
                    else {
                        service.refreshWeather(city.getText().toString());
                        cityname.setText(city.getText().toString());
//                        getDataFromWeatherAPI();

                    }

                    dialog = new ProgressDialog(Weather.this);
                    dialog.setMessage("Loading...");
                    dialog.show();
                    city.setText("");

                    Snackbar snackbar = Snackbar.make(coordinatorLayout, "", Snackbar.LENGTH_LONG)
                            .setDuration(Snackbar.LENGTH_INDEFINITE)
                            .setAction("SEND MESSAGE", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent intent = new Intent(Weather.this, ListContact.class);
                                    intent.putExtra("temperatorF", temperatureF.getText().toString());
                                    intent.putExtra("temperatorC", temperatureC.getText().toString());
                                    intent.putExtra("condition", condition.getText().toString());
                                    startActivity(intent);
                                }
                            });


                    snackbar.show();
                    setApdater();
                } else {
                    Toast.makeText(Weather.this, "Connect Interner Fail!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void getDataFromWeatherAPI(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://query.yahooapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherSevice sevice = retrofit.create(WeatherSevice.class);

        String query = "select * from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"Leeds\")&format=json";

        sevice.callQuery().enqueue(new Callback<WeatherSevice.Weather>() {
            @Override
            public void onResponse(Call<WeatherSevice.Weather> call, Response<WeatherSevice.Weather> response) {
                Log.d(TAG, "onResponse: ");
                WeatherSevice.Weather weather = response.body();
                Log.d(TAG, weather.toString());
                Log.d(TAG, weather.getQuery().getResultW().getChannelW().getItemW().getItemList().toString());
                for (WeatherSevice.ForecastItem forecastItem : weather.getQuery().getResultW().getChannelW().getItemW().getItemList()){
                    ConditionModel.list.add(new ConditionModel(
                            forecastItem.getDay(),
                            forecastItem.getMtext(),
                            forecastItem.getHigh(),
                            forecastItem.getLow(),
                            loadImage(forecastItem.getCode())
                    ));
                }
            }

            @Override
            public void onFailure(Call<WeatherSevice.Weather> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
    }



    private void getReferences() {
        background = (RelativeLayout) findViewById(R.id.weather);

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

    }



    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();
        Item item = channel.getItem();
        int resources = getResources()
                .getIdentifier("drawable/icon_" + item.getCondition().getCode(), null, getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resources);

        int weatherBackgrounđ = loadBackground(item.getCondition().getCode() + "");

        background.setBackgroundResource(weatherBackgrounđ);

        iconWeather.setImageDrawable(weatherIconDrawable);

        temperatureF.setText(item.getCondition().getTemperature() + "°"  + channel.getUnits().getTemperator());

        float c ;

        c = (item.getCondition().getTemperature() - 32) / 1.8f;

        temperatureC.setText(c + "°C");

        condition.setText(item.getCondition().getDescription());


    }

    @Override
    public void serviceFailure(Exception e) {
        dialog.hide();
        Toast.makeText(this, "Service Failure", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:

                break;
            case R.id.setting:

                break;
        }
        return false;
    }

    private void sendSMS(String phoneNumber, String message) {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
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
