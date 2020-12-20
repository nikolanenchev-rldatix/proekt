package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class parking extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[];
    int image[]={R.drawable.parking};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        s1 = getResources().getStringArray(R.array.parking);
        MyAdapter1 myAdapter1 = new MyAdapter1(this, s1);
        recyclerView.setAdapter(myAdapter1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}