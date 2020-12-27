package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

public class CityActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DBHelper myDB;
    private MyAdapter.RecyclerViewClickListener listener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        myDB=new DBHelper(this);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);


        String user="";
        Bundle extras=getIntent().getExtras();
        if(extras != null){
            user=extras.getString("user");
        }
        setAdapter(user);


    }
    private void setAdapter(String user){
        MyAdapter adapter=new MyAdapter(this,myDB,R.layout.my_row,listener,user);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }
}