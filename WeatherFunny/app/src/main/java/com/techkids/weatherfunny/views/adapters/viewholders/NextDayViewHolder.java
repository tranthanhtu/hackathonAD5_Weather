package com.techkids.weatherfunny.views.adapters.viewholders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.models.recycleview.NextDayModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Dell latitude E6520 on 1/12/2017.
 */

public class NextDayViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_day)
    TextView tvDay;
    @BindView(R.id.tv_condition_day)
    TextView tvConditionDay;
    @BindView(R.id.iv_icon_condition)
    ImageView ivIconCondition;
    @BindView(R.id.tv_tempDayMax)
    TextView tvTempDayMax;
    @BindView(R.id.tv_tempDayMin)
    TextView tvTempDayMin;
    public NextDayViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(NextDayModel dayModel){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(dayModel.getDay());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String s = format1.format(date);

        tvDay.setText(s);
        tvConditionDay.setText(dayModel.getCondition());
        tvTempDayMax.setText(dayModel.getTemperatureCmax() + "°↑");
        tvTempDayMin.setText(dayModel.getTemperatureMin() + "°↓");
        ivIconCondition.setImageResource(dayModel.getCode());
    }

}
