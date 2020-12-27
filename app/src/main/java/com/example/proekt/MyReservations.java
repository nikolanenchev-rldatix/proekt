package com.example.proekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MyReservations extends AppCompatActivity {
    RecyclerView mRecyclerView;
    MyReservationsAdapter mAdapter;
    TextView dateText;
    TextView numberHours;
    TextView cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_reservations);
        ArrayList<MyReservationsC> myReservations = new ArrayList<MyReservationsC>();
        DBHelper handler = new DBHelper(MyReservations.this);
        myReservations = handler.getReservations();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_reservations_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new MyReservationsAdapter(myReservations, R.layout.my_row3, this);
        mRecyclerView.setAdapter(mAdapter);
    }


}
