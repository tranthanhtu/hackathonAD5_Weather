package com.example.hau.myweather.views.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hau.myweather.R;
import com.example.hau.myweather.models.beans.Condition;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hau on 31/12/2016.
 */

public class ConditionViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.tv_weather)
    TextView tvWeather;
    @BindView(R.id.tv_high)
    TextView tvHigh;
    @BindView(R.id.tv_low)
    TextView tvLow;
    @BindView(R.id.imv_weather)
    ImageView imvWeather;

    public ConditionViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Condition condition){
        tvDay.setText(condition.getDay());
        tvWeather.setText(condition.getText());
        tvHigh.setText(condition.getHigh() + "°F");
        tvLow.setText(condition.getLow() + "°F");
        imvWeather.setImageResource(condition.getCode());
    }
}
