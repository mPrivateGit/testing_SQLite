package com.example.aprivate.testing_sqlite.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aprivate.testing_sqlite.bin.Collection;
import com.example.aprivate.testing_sqlite.bin.Contacts;
import com.example.aprivate.testing_sqlite.R;
import com.example.aprivate.testing_sqlite.holders.CustomHolder;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomHolder>
        implements View.OnClickListener {
    private ArrayList<Contacts> mArrayList = Collection.getInstance().getContacts();

    @Override
    public CustomHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        CustomHolder holder = new CustomHolder(v);
        holder.itemView.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(CustomHolder holder, int position) {
        holder.bind(mArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    @Override
    public void onClick(View v) {
        //todo
    }
}
