package com.techkids.weatherfunny.views.fragments;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.configs.Constant;
import com.techkids.weatherfunny.eventbus.BaseEvent;
import com.techkids.weatherfunny.eventbus.LoadDataFailEvent;
import com.techkids.weatherfunny.eventbus.LoadDataSuccessEvent;
import com.techkids.weatherfunny.managers.Preferrences;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.network.APIWeatherAPIXUHelper;
import com.techkids.weatherfunny.services.LoadDataFromAPIService;
import com.techkids.weatherfunny.utils.StringUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public static final String TAG = HomeFragment.class.toString();

    @BindView(R.id.iv_weather_home)
    ImageView ivWeatherHome;
    @BindView(R.id.tv_city_home)
    TextView tvCityHome;
    @BindView(R.id.tv_temp_home)
    TextView tvTempHome;
    @BindView(R.id.tv_condition_home)
    TextView tvConditionHome;
    @BindView(R.id.tv_humidity_home)
    TextView tvHumidityHome;
    @BindView(R.id.tv_wind_home)
    TextView tvWindHome;
    @BindView(R.id.tvTemperatureMax)
    TextView tvTemperatureMax;
    @BindView(R.id.tvTemperatureMin)
    TextView tvTemperatureMin;
    Weather weather;
    //    @BindView(R.id.iv_search)
//    ImageView ivSearch;
    @BindView(R.id.edt_search)
    EditText edtSearch;
    //    @BindView(R.id.iv_clear)
//    ImageView ivClear;
//    @BindView(R.id.tv_current_location)
//    TextView tvCurrentLocation;
//    @BindView(R.id.tv_current_time)
//    TextView tvCurrentTime;
    @BindView(R.id.iv_reload)
    ImageView ivReload;

    boolean onEditText;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        weather = RealmHandler.getInstance().getWeather();
        Log.d(TAG, "onCreateView: " + weather.getLocation().toString());
        if (weather != null) {
            setupUI();
        }
        onEditText = true;
        addListener();
//        checkOnEditText(onEditText);
        return view;
    }

    private void addListener() {
        edtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    onSearch();
                    return true;
                }
                return false;
            }
        });
    }

    private void checkOnEditText(Boolean onEdittext) {
        if (onEdittext) {
//            ivClear.setVisibility(View.VISIBLE);
            edtSearch.setVisibility(View.VISIBLE);
        } else {
//            ivClear.setVisibility(View.INVISIBLE);
            edtSearch.setVisibility(View.INVISIBLE);
        }
    }

//    private void addListener() {
//        ivSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (edtSearch.getText().length() == 0) {
//                    checkOnEditText(true);
//                    Toast.makeText(getContext(), "Insert City To Check!!!", Toast.LENGTH_SHORT).show();
//                } else {
//                    APIWeatherAPIXUHelper.getInstance()
//                            .getApiWeatherAPIXU()
//                            .getWeather(Constant.KEY_API, StringUtils.removeAccent(edtSearch.getText().toString()), "10")
//                            .enqueue(new Callback<Weather>() {
//                                @Override
//                                public void onResponse(Response<Weather> response) {
//                                    Weather weather = response.body();
//                                    RealmHandler.getInstance().addWeather(weather);
//                                    updateUI();
//                                }
//
//                                @Override
//                                public void onFailure(Throwable t) {
//                                    Toast.makeText(getContext(), "Check city again!", Toast.LENGTH_SHORT).show();
//                                }
//                            });
//                }
//            }
//        });
//
////        ivClear.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                edtSearch.setVisibility(View.INVISIBLE);
////                ivClear.setVisibility(View.INVISIBLE);
////            }
////        });
//
//        ivReload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                APIWeatherAPIXUHelper.getInstance()
//                        .getApiWeatherAPIXU()
//                        .getWeather(Constant.KEY_API, StringUtils.removeAccent(tvCurrentLocation.getText().toString()), "10")
//                        .enqueue(new Callback<Weather>() {
//                            @Override
//                            public void onResponse(Response<Weather> response) {
//                                Weather weather = response.body();
//                                RealmHandler.getInstance().addWeather(weather);
//                                updateUI();
//                            }
//
//                            @Override
//                            public void onFailure(Throwable t) {
//                                Toast.makeText(getContext(), "Check city again!", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//            }
//        });
//    }

    void onSearch() {
        if (edtSearch.getText().length() == 0) {
//            onEditText = true;
            Toast.makeText(getContext(), "Insert City To Check!!!", Toast.LENGTH_SHORT).show();
        } else {
//            onEditText = false;
            RotateAnimation rotate = new RotateAnimation(0, 360,
                    Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                    0.5f);
            rotate.setDuration(4000);
            rotate.setFillAfter(false);
            rotate.setRepeatCount(Animation.INFINITE);
            ivReload.startAnimation(rotate);
            Preferrences.getInstance().putCity(edtSearch.getText().toString());
            Intent intent = new Intent(getContext(), LoadDataFromAPIService.class);
            getContext().startService(intent);
        }
//        checkOnEditText(onEditText);
    }

    @OnClick(R.id.iv_reload)
    void onReload() {
        RotateAnimation rotate = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotate.setDuration(4000);
        rotate.setFillAfter(false);
        rotate.setRepeatCount(Animation.INFINITE);
        ivReload.startAnimation(rotate);
        Intent intent = new Intent(getContext(), LoadDataFromAPIService.class);
        getContext().startService(intent);
    }

    private void setupUI() {
        Log.d(TAG, "setupUI: ");
        tvCityHome.setText(weather.getLocation().getName());
        tvTempHome.setText(weather.getCurrent().getTempC() + "°");
        tvConditionHome.setText("Feel like: " + weather.getCurrent().getFeelslikeC() + "°\n" + weather.getCurrent().getCondition().getText());
        tvHumidityHome.setText(weather.getCurrent().getHumidity() + "%");
        tvWindHome.setText(weather.getCurrent().getWindMph() + " mph");
        Log.d(TAG, String.format("setupUI: %s", weather.getForecast().getList().get(0).getDay().getConditionDay().getCode()));
        tvTemperatureMax.setText(weather.getForecast().getList().get(0).getDay().getMaxTempC() + "°↑");
        tvTemperatureMin.setText(weather.getForecast().getList().get(0).getDay().getMinTempC() + "°↓");
        ivWeatherHome.setImageResource(loadImage(weather.getForecast().getList().get(0).getDay().getConditionDay().getCode()));
        if (edtSearch.getText() != null) {
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);
        }
//        tvCurrentLocation.setText(weather.getLocation().getName());
//        tvCurrentTime.setText(weather.getCurrent().getLastUpdate());

    }


    @Subscribe
    void onDataEvent(BaseEvent baseEvent) {
        Log.d(TAG, "onDataEvent: ");
        if (baseEvent instanceof LoadDataSuccessEvent) {
            LoadDataSuccessEvent event = (LoadDataSuccessEvent) baseEvent;
            weather = event.getWeather();
            setupUI();
            ivReload.clearAnimation();
        } else if (baseEvent instanceof LoadDataFailEvent) {
            Toast.makeText(getContext(), "Check city again! Or check Internet ", Toast.LENGTH_SHORT).show();
        }
    }


    private int loadImage(String id) {
        return this.getActivity().getResources().getIdentifier("icon_" + id, "drawable", this.getActivity().getPackageName());
    }

    public void updateUI() {
        weather = RealmHandler.getInstance().getWeather();
        setupUI();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
//        addListener();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

}

