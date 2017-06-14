package com.example.mahmoudashraf.neurologysystem.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mahmoudashraf.neurologysystem.R;

public class explain extends AppCompatActivity {
TextView txtnamedisease,txtdisease_Symptoms,txtpatient_Symptoms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explain);

        txtdisease_Symptoms=(TextView)findViewById(R.id.disease_Symptoms);
        txtnamedisease=(TextView)findViewById(R.id.nameod_disease);
        txtpatient_Symptoms=(TextView)findViewById(R.id.patient_Symptoms);

        String patient_Symptoms = getIntent().getStringExtra("patient_Symptoms");
        String disease_patient_name = getIntent().getStringExtra("disease_patient");
        String disease_sy = getIntent().getStringExtra("disease_sy");

        txtdisease_Symptoms.setText(disease_sy);
        txtnamedisease.setText(disease_patient_name);
        txtpatient_Symptoms.setText(patient_Symptoms);

    }
}
