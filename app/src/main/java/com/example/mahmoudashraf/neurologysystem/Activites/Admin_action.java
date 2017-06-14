package com.example.mahmoudashraf.neurologysystem.Activites;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_Diseases_info.Sqlite_diseases;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_Diseases_info.db_Diseases;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.Sqlite_patient;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.db_patient;
import com.example.mahmoudashraf.neurologysystem.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.mahmoudashraf.neurologysystem.Activites.consulte_class.All_Symptoms;
import static com.example.mahmoudashraf.neurologysystem.Activites.consulte_class.new_Alzheimer_Symptoms_array;
import static com.example.mahmoudashraf.neurologysystem.Activites.consulte_class.new_Ataxia_Symptoms_array;
import static com.example.mahmoudashraf.neurologysystem.Activites.consulte_class.new_Bell_palsy_Symptoms_array;
import static com.example.mahmoudashraf.neurologysystem.Activites.consulte_class.new_neuralgia_Symptoms_array;

public class Admin_action extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    // Spinner Drop down elements
    List<String> disease_list = new ArrayList<String>();

Button btn__addfact;
    EditText ed_fact;
    String item="";
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_action);

        btn__addfact=(Button)findViewById(R.id.btn_add);
        ed_fact =(EditText)findViewById(R.id.fact);
        btn__addfact.setEnabled(false);
        ed_fact.setEnabled(false);

        Spinner disease_spinner = (Spinner) findViewById(R.id.diseases_spinner);
        // Spinner click listener
        disease_spinner.setOnItemSelectedListener(this);
        disease_list.add("--Select--");
        disease_list.add("Alzheimer");
        disease_list.add("neuralgia ");
        disease_list.add("Bell_palsy");
        disease_list.add("Ataxia");


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, disease_list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        disease_spinner.setAdapter(dataAdapter);


//==================================================================

    }

    public void add(View view)
    {
        if (item=="")
        {
            Toast.makeText(this, "PLZ select item", Toast.LENGTH_SHORT).show();
            return;
        }
        if (item=="--Select--")
        {
            Toast.makeText(this, "PLZ select item", Toast.LENGTH_SHORT).show();
            return;
        }


        String fact=ed_fact.getText().toString();
        if (fact.equals("")||fact==null)
        {
            Toast.makeText(this, "enter your full and correct data", Toast.LENGTH_SHORT).show();
            return;
        }

 /*
if (item=="1")
{ new_Alzheimer_Symptoms_array.add(fact);}
        if (item=="2")
        { new_neuralgia_Symptoms_array.add(fact);}
        if (item=="3")
        { new_Bell_palsy_Symptoms_array.add(fact);}
        if (item=="4")
        { new_Ataxia_Symptoms_array.add(fact);}
        */




        All_Symptoms.add(fact);

        //===========  add data to database
        Sqlite_diseases sqliteUtil = new Sqlite_diseases(getApplicationContext());
        SQLiteDatabase sqLiteDatabase=sqliteUtil.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(db_Diseases.Disease_Name,item);
        contentValues.put(db_Diseases.Symptoms_Disease,fact);

        long id=sqLiteDatabase.insert(db_Diseases.Tbale_Name,null,contentValues);

        if (id>0)
        {
            Toast.makeText(getApplicationContext(),"Fact Saved",Toast.LENGTH_LONG).show();
            ed_fact.setText("");

        }
        else {
            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
        }



        }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item

        if (position>0) {
            pos=position;
            item = parent.getItemAtPosition(position).toString();
            ed_fact.setEnabled(true);
            btn__addfact.setEnabled(true);
        }

        // Showing selected spinner item
     Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }







}



