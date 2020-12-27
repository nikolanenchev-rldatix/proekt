package com.example.proekt;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyReservationsAdapter extends RecyclerView.Adapter<MyReservationsAdapter.ViewHolder>{

    private ArrayList<MyReservationsC> myList;
    private int rowLayout;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView cName;
        private TextView hour;
        private TextView date;

        public ViewHolder( View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.park_name);
            cName = (TextView) itemView.findViewById(R.id.c_name);
        }
    }

    public MyReservationsAdapter(ArrayList<MyReservationsC> Reservations, int rowLayout, Context context) {
        this.myList = Reservations;
        this.rowLayout = rowLayout;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        MyReservationsC entry = myList.get(position);
        holder.mName.setText(entry.getParkingName());
        holder.cName.setText(entry.getCityName());
    }

    @Override
    public int getItemCount() {
        return myList == null ? 0 : myList.size();
    }

}
