package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class ReservationForm extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    ImageView mainImageView;
    TextView title;
    String data1;
    int myImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);
        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        mainImageView=findViewById(R.id.mainImageView);
        title=findViewById(R.id.title);
        getData();
        setData();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDate= DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime());
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