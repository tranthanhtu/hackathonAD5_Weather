package com.techkids.weatherfunny.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.techkids.weatherfunny.R;
import com.techkids.weatherfunny.models.recycleview.NextDayModel;
import com.techkids.weatherfunny.views.adapters.viewholders.NextDayViewHolder;

import static com.techkids.weatherfunny.models.recycleview.NextDayModel.list;

/**
 * Created by Dell latitude E6520 on 1/12/2017.
 */

public class NextDayAdapter extends RecyclerView.Adapter<NextDayViewHolder> {

    @Override
    public NextDayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_next_day_weather, parent, false);

        NextDayViewHolder nextDayViewHolder = new NextDayViewHolder(view);
        return nextDayViewHolder;
    }

    @Override
    public void onBindViewHolder(NextDayViewHolder holder, int position) {
        NextDayModel dayModel = list.get(position);
        holder.bind(dayModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
