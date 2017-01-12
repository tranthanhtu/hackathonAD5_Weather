package com.techkids.weatherfunny.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.managers.RealmHandler;
import com.techkids.weatherfunny.models.json.api_apixu.ForeCastDay;
import com.techkids.weatherfunny.models.json.api_apixu.Weather;
import com.techkids.weatherfunny.models.recycleview.NextDayModel;
import com.techkids.weatherfunny.views.adapters.NextDayAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForcastDayFragment extends Fragment {

    private static final String TAG = ForcastDayFragment.class.toString();
    @BindView(R.id.rv_nextday)
    RecyclerView rvNextDay;
    private Weather weather;
    private NextDayAdapter adapter;

    public ForcastDayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forcast_day, container, false);
        ButterKnife.bind(this, view);
        weather = RealmHandler.getInstance().getWeather();
        addModels();
        setAdapter();
        Log.d(TAG, "onCreateView: " + weather.getLocation().toString());
        return view;
    }

    private void setAdapter() {
        LinearLayoutManager layoutManager =  new LinearLayoutManager(getContext());
        rvNextDay.setLayoutManager(layoutManager);
        rvNextDay.setHasFixedSize(true);
        adapter = new NextDayAdapter();
        rvNextDay.setAdapter(adapter);
    }

    private void addModels() {
        for (ForeCastDay foreCastDay: weather.getForecast().getList()){
//            Log.d(TAG, String.format("addModels: %s", foreCastDay));
            NextDayModel.list.add(new NextDayModel(
                    foreCastDay.getDate(),
                    foreCastDay.getDay().getConditionDay().getText(),
                    foreCastDay.getDay().getMaxTempC(),
                    foreCastDay.getDay().getMinTempC(),
                    loadImage(foreCastDay.getDay().getConditionDay().getCode())

            ));
        }
    }

    public void updateUI(){
        weather = RealmHandler.getInstance().getWeather();
        addModels();
        adapter.notifyDataSetChanged();
        setAdapter();

    }

    private int loadImage(String id) {
        return this.getActivity().getResources().getIdentifier("icon_" + id, "drawable", this.getActivity().getPackageName());
    }

    @Override
    public void onResume() {
        super.onResume();
        NextDayModel.list.clear();
        updateUI();
        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
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
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

}
