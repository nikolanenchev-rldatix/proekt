package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReservationForm extends AppCompatActivity {
    String city = "";
    String username = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_form);



        Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragmentforma);
        Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragmentspin);

        EditText cityname = (EditText) findViewById(R.id.formcity);



        Bundle extras = getIntent().getExtras();
        if(extras != null){
            city = extras.getString("cityname");
            username = extras.getString("username");
        }
        cityname.setText(city);

    }

    public void functionClick(View v){

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        TextView datepicker = (TextView) findViewById(R.id.editTextDate);
        String hour = spinner.getSelectedItem().toString();
        String date = datepicker.getText().toString();

        Intent i = new Intent(this, parking.class);
        i.putExtra("city", city);
        i.putExtra("username", username);
        i.putExtra("date", date);
        i.putExtra("hour", hour);
        startActivity(i);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent intent = new Intent(this, MyReservations.class);
        startActivity(intent);
        return true;
    }
}

