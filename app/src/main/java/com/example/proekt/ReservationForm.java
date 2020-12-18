package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ReservationForm extends AppCompatActivity {
    ImageView mainImageView;
    TextView title;
    String data1;
    int myImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);

        mainImageView=findViewById(R.id.mainImageView);
        title=findViewById(R.id.title);
        getData();
        setData();
    }
    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1")){
            data1=getIntent().getStringExtra("data1");
            myImage=getIntent().getIntExtra("myImage",1);
        }
        Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
    }
    private void setData(){
        title.setText(data1);
        mainImageView.setImageResource(myImage);
    }
}