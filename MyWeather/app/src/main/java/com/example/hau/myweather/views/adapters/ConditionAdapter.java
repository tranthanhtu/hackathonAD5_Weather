package com.example.hau.myweather.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.myweather.R;
import com.example.hau.myweather.models.beans.Condition;
import com.example.hau.myweather.views.adapters.viewholders.ConditionViewHolder;

/**
 * Created by Hau on 31/12/2016.
 */

public class ConditionAdapter extends RecyclerView.Adapter<ConditionViewHolder> {


    @Override
    public ConditionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View menuView = layoutInflater.inflate(R.layout.list_item_condition, parent, false);
        ConditionViewHolder conditionViewHolder = new ConditionViewHolder(menuView);
        return conditionViewHolder;
    }

    @Override
    public void onBindViewHolder(ConditionViewHolder holder, int position) {
        Condition condition = Condition.list.get(position);
        holder.bind(condition);
    }

    @Override
    public int getItemCount() {
        return Condition.list.size();
    }
}
