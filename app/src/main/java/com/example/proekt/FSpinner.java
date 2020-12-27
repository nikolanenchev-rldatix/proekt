package com.example.proekt;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class FSpinner extends Fragment {


    public FSpinner() {
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button b = (Button) getActivity().findViewById(R.id.button);
        final EditText city = (EditText) getActivity().findViewById(R.id.formcity);
        final TextView date = (TextView) getActivity().findViewById(R.id.editTextDate);
        final Spinner s = (Spinner) getActivity().findViewById(R.id.spinner);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), "Вие избравте: " + s.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getActivity().getApplicationContext(), "Не избравте ништо", Toast.LENGTH_SHORT).show();
            }
        });

    }
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState){

            return inflater.inflate(R.layout.fragment_f_spinner, container, false);
        }
    }
