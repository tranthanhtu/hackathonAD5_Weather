package vn.tranthanhtu.weather.viewholders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import vn.tranthanhtu.weather.R;
import vn.tranthanhtu.weather.Weather;
import vn.tranthanhtu.weather.data.Item;
import vn.tranthanhtu.weather.models.ConditionModel;

/**
 * Created by Dell latitude E6520 on 12/19/2016.
 */

public class ConditionViewHolder extends RecyclerView.ViewHolder{
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

    public void bind(ConditionModel conditionModel){
        tvDay.setText(conditionModel.getDay());
        tvWeather.setText(conditionModel.getText());
        tvHigh.setText(conditionModel.getHigh() + "°F");
        tvLow.setText(conditionModel.getLow() + "°F");
        imvWeather.setImageResource(conditionModel.getCode());
    }
}
