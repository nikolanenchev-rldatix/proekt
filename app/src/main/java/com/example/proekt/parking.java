package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class parking extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DBHelper myDB;
    private pAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        myDB = new DBHelper(this);
        String city = "";
        String date = "";
        String hour = "";
        String user = "";
        Intent intent = getIntent();
        city = intent.getStringExtra("city");
        date = intent.getStringExtra("date");
        hour = intent.getStringExtra("hour");
        user = intent.getStringExtra("user");
        recyclerView= findViewById(R.id.recyclerView2);
        setAdapter(city, date, hour, user);
    }
       private void setAdapter(String city, String date, String hour, String user){
        pAdapter adapter= new pAdapter(this,myDB,R.layout.my_row1,listener,city,date,hour,user);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
       }
}