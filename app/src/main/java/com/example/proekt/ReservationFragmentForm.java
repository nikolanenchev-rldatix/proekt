package com.example.proekt;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Calendar;


public class ReservationFragmentForm extends Fragment {



    public ReservationFragmentForm() {
        // Required empty public constructor
    }
    private static final String TAG = "ReservationFragmentForm";
    private TextView displayDate;
    private DatePickerDialog.OnDateSetListener datesetlistener;



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        EditText cityname = getActivity().findViewById(R.id.formcity);


        displayDate = (TextView) getActivity().findViewById(R.id.editTextDate);
        displayDate.setOnClickListener(view -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog picker = new DatePickerDialog(
                    getContext(),
                    android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                    datesetlistener,
                    year, month, day

            );
            picker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            picker.show();
        });

        datesetlistener = (view, year, month, dayOfMonth) -> {
            month = month + 1;

            String date = dayOfMonth + "/" + month + "/" + year;
            displayDate.setText(date);
        };

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the activity_reservation_confirmation for this fragment
        return inflater.inflate(R.layout.fragment_reservation_form, container, false);
    }

}