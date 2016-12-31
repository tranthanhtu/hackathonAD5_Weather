package com.example.hau.myweather.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hau.myweather.R;
import com.example.hau.myweather.models.beans.Contact;
import com.example.hau.myweather.views.adapters.interfaces.RecyclerItemClickListener;
import com.example.hau.myweather.views.adapters.viewholders.ContactViewHolder;

import java.util.List;

/**
 * Created by Hau on 31/12/2016.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    private List<Contact> list;
    private Context mContext;
    private RecyclerItemClickListener recyclerItemClickListener;

    public ContactAdapter(List<Contact> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
    }

    public void setRecyclerItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View menuView = layoutInflater.inflate(R.layout.list_contact, parent, false);

        ContactViewHolder contactViewHolder = new ContactViewHolder(menuView);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, final int position) {
        Contact contactModel = list.get(position);
        holder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerItemClickListener != null) {
                    recyclerItemClickListener.onItemClickListener(position);
                }
            }
        });
        holder.bind(contactModel);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
