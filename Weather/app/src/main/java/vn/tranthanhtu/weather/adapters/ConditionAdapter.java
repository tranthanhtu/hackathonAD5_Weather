package vn.tranthanhtu.weather.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.tranthanhtu.weather.R;
import vn.tranthanhtu.weather.models.ConditionModel;
import vn.tranthanhtu.weather.models.ContactModel;
import vn.tranthanhtu.weather.viewholders.ConditionViewHolder;
import vn.tranthanhtu.weather.viewholders.ContactViewHolder;

import static vn.tranthanhtu.weather.models.ConditionModel.list;

/**
 * Created by Dell latitude E6520 on 12/19/2016.
 */

public class ConditionAdapter extends RecyclerView.Adapter<ConditionViewHolder>{


    @Override
    public ConditionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View menuView = layoutInflater.inflate(R.layout.list_item_condition, parent, false);

        ConditionViewHolder conditionViewHolder = new ConditionViewHolder(menuView);
        return conditionViewHolder;
    }

    @Override
    public void onBindViewHolder(ConditionViewHolder holder, int position) {
        ConditionModel conditionModel = list.get(position);
        holder.bind(conditionModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
