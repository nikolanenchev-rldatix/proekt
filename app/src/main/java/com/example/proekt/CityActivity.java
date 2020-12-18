package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import android.content.Intent;
import android.os.Bundle;

public class CityActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[];
    int images[] = {R.drawable.tetovo,R.drawable.strumica,R.drawable.ohrid,
    R.drawable.skopje,R.drawable.gostivar,R.drawable.bitola,R.drawable.veles};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView) findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.Gradovi);
        MyAdapter myAdapter = new MyAdapter(this, s1, images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}