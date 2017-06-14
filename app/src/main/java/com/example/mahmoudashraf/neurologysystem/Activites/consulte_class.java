package com.example.mahmoudashraf.neurologysystem.Activites;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_Diseases_info.Sqlite_diseases;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.Sqlite_patient;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.db_patient;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_Diseases.*;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_Diseases_info.*;
import com.example.mahmoudashraf.neurologysystem.Activites.Login;
import com.example.mahmoudashraf.neurologysystem.R;

import java.util.ArrayList;
import java.util.Arrays;

public class consulte_class extends AppCompatActivity {

    LinearLayout container;
    TextView result;
    Button btn_save,btnexplain;
    public static String[] Diseases;
    public static String[]  Symptoms_neuralgia;
    public static String[]  Symptoms_Alzheimer;
    public static String[]  Symptoms_Ataxia;
    public static String[]  Symptoms_Bell_palsy;
    public  static ArrayList<String> new_neuralgia_Symptoms_array = new ArrayList<String>();
    public  static  ArrayList<String> new_Bell_palsy_Symptoms_array = new ArrayList<String>();
    public  static  ArrayList<String> new_Alzheimer_Symptoms_array = new ArrayList<String>();
    public  static ArrayList<String> new_Ataxia_Symptoms_array = new ArrayList<String>();
  public  static   ArrayList<String> All_Symptoms = new ArrayList<String>();
    String[] alltocheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulte);
//==============================================
        container = (LinearLayout)findViewById(R.id.checkbox_container);
        result=(TextView)findViewById(R.id.edconsulte);
         btn_save=(Button)findViewById(R.id.btnsavedata);
        btnexplain=(Button)findViewById(R.id.btnexplain);
        result.setText("NO Diseases ");
        btnexplain.setVisibility(View.INVISIBLE);
        btn_save.setVisibility(View.INVISIBLE);

        //============================================== Diseases
        Diseases = new String[] {"neuralgia","Alzheimer","Bell_palsy","Ataxia"};

        //============================================== Symptoms_neuralgia
        new_neuralgia_Symptoms_array.add("The exact mechanism that consists neuralgia which is not clear");
        new_neuralgia_Symptoms_array.add("the disease myasthenia gravis is muscle weakness and fatigue");
        new_neuralgia_Symptoms_array.add("the extreme weakness in the muscle when used for a long time");
        new_neuralgia_Symptoms_array.add("sagging eyelids and blurred vision");
        new_neuralgia_Symptoms_array.add("the nerve injury");
        //============================================== Symptoms_Alzheimer
        new_Alzheimer_Symptoms_array.add("repeat the same sentences and words");
        new_Alzheimer_Symptoms_array.add("forgetting  family names and the names use for a day");
        new_Alzheimer_Symptoms_array.add("problems with abstract thinking");
        new_Alzheimer_Symptoms_array.add("Loss of sense of time");
        new_Alzheimer_Symptoms_array.add("repeat the same sentences and words");
        new_Alzheimer_Symptoms_array.add("Loss of the ability to judge the situation and take");

        //============================================== Symptoms_Bell_palsy
        new_Bell_palsy_Symptoms_array.add("muscle weakness in the semi-face");
        new_Bell_palsy_Symptoms_array.add("reduction or loss of the sense of taste in the anterior two-thirds of the half-tongue");
        new_Bell_palsy_Symptoms_array.add("change in facial expressions");
        new_Bell_palsy_Symptoms_array.add("severe acute fatigue in the muscles of the pharynx during chewing and talking");
        //============================================== Symptoms_Ataxia
        new_Ataxia_Symptoms_array.add("dizziness");
        new_Ataxia_Symptoms_array.add("erratic movement");
        new_Ataxia_Symptoms_array.add("it may be a lack of consistency only");
        new_Ataxia_Symptoms_array.add("difficulties in solving daily problems");
        new_Ataxia_Symptoms_array.add("the right problems in the ability to determine the location");

        getnew_data();
        //---------------------------------------  to add checkbox to design
        Symptoms_neuralgia=new_neuralgia_Symptoms_array.toArray(new String[ new_neuralgia_Symptoms_array.size()]);
        Symptoms_Alzheimer=new_Alzheimer_Symptoms_array.toArray(new String[ new_Alzheimer_Symptoms_array.size()]);
        Symptoms_Ataxia=new_Ataxia_Symptoms_array.toArray(new String[ new_Ataxia_Symptoms_array.size()]);
        Symptoms_Bell_palsy=new_Bell_palsy_Symptoms_array.toArray(new String[ new_Bell_palsy_Symptoms_array.size()]);


        All_Symptoms.addAll(new_neuralgia_Symptoms_array);
        All_Symptoms.addAll(new_Alzheimer_Symptoms_array);
        All_Symptoms.addAll(new_Bell_palsy_Symptoms_array);
        All_Symptoms.addAll(new_Ataxia_Symptoms_array);


        alltocheck=All_Symptoms.toArray(new String[ All_Symptoms.size()]);

        for (int i=0;i<alltocheck.length;i++)
        {
            CheckBox chksymptomsName = new CheckBox(this);
            chksymptomsName.setText(alltocheck[i]);
            chksymptomsName.setTextColor(Color.BLUE);
            container.addView(chksymptomsName);
        }


    }

   

    //---------------------------------------  to gat new Symptoms from database and add to arrays
    public void getnew_data()
    { Sqlite_diseases sqliteUtil = new Sqlite_diseases(getApplicationContext());
        SQLiteDatabase sqLiteDatabase=sqliteUtil.getWritableDatabase();
        String[] colums = {db_Diseases.Key_id,db_Diseases.Disease_Name, db_Diseases.Symptoms_Disease};
        Cursor cursor = sqLiteDatabase.query(db_Diseases.Tbale_Name, colums, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String disease = cursor.getString(1);
            String symptoms = cursor.getString(2);

            if (disease=="neuralgia")
            {
                new_neuralgia_Symptoms_array.add(symptoms);
            }
            if (disease=="Alzheimer")
            {
                new_Alzheimer_Symptoms_array.add(symptoms);
            }
            if (disease=="Bell_palsy")
            {
                new_Bell_palsy_Symptoms_array.add(symptoms);
            }
            if (disease=="Ataxia")
            {
                new_Ataxia_Symptoms_array.add(symptoms);
            }
        }

    }
    //--------------------------------------- to consulte disease_patient
    String disease_patient="";
    String input_disease_patient_Symptoms="is ";
    String fact="";

    public void consulte(View view)
    {
        fact="";
        int diseases_neuralgia=0;
        int   diseases_Alzheimer=0;
        int diseases_Bell_palsy=0;
        int diseases_Ataxia=0;

        for (int i = 0; i < container.getChildCount(); i++){
            View v = container.getChildAt(i);
            if (v instanceof CheckBox){
                if (((CheckBox) v).isChecked())
                {
                     fact=((CheckBox) v).getText().toString();
                    input_disease_patient_Symptoms+=","+fact;


                    if (Arrays.asList(Symptoms_Ataxia).contains(fact))
                    {
                        diseases_Ataxia+=1;
                    }
                    if (Arrays.asList(Symptoms_Bell_palsy).contains(fact))
                    {
                        diseases_Bell_palsy+=1;
                    }
                    if (Arrays.asList(Symptoms_Alzheimer).contains(fact))
                    {
                        diseases_Alzheimer+=1;
                    }
                    if (Arrays.asList(Symptoms_neuralgia).contains(fact))
                    {
                        diseases_neuralgia+=1;
                    }


                }
            }
        }
        if (fact=="")
        {
            Toast.makeText(getApplicationContext(),"choose Symptoms",Toast.LENGTH_LONG).show();
            result.setText("No Diseases :->" + disease_patient);
        }
        else {

           int sum=diseases_neuralgia+diseases_Alzheimer+diseases_Bell_palsy+diseases_Ataxia;
            if (sum>=8) {
                int[] max_Diseases = new int[]{diseases_neuralgia, diseases_Alzheimer, diseases_Bell_palsy, diseases_Ataxia};
                Arrays.sort(max_Diseases);
                int max = max_Diseases[max_Diseases.length - 1];
                if (max == diseases_Ataxia) {
                    disease_patient = "Ataxia";
                    result.setText("You suffer from a disease :->" + disease_patient);
                }
                if (max == diseases_Bell_palsy) {
                    disease_patient = "Bell_palsy";
                    result.setText("You suffer from a disease :->" + disease_patient);
                }
                if (max == diseases_Alzheimer) {
                    disease_patient = "Alzheimer";
                    result.setText("You suffer from a disease :->" + disease_patient);
                }
                if (max == diseases_neuralgia) {
                    disease_patient = "neuralgia";
                    result.setText("You suffer from a disease :->" + disease_patient);
                }

                btnexplain.setVisibility(View.VISIBLE);
                btn_save.setVisibility(View.VISIBLE);


            }
            else Toast.makeText(getApplicationContext(),"You Should choose More ,at least 8 facts ",Toast.LENGTH_LONG).show();
        }
    }


    public void explain(View view)
    {
        Intent intent = new Intent(consulte_class.this, explain.class);
        intent.putExtra("patient_Symptoms",input_disease_patient_Symptoms);
        intent.putExtra("disease_patient",disease_patient);
        String disease_sy="is: ";
        if (disease_patient=="Ataxia")
        {
            for (int i=0;i<new_Ataxia_Symptoms_array.size();i++)
            {
                disease_sy+=  ","+ new_Ataxia_Symptoms_array.get(i);
            }
        }


            if (disease_patient=="Bell_palsy")
            {
                for (int i=0;i<new_Bell_palsy_Symptoms_array.size();i++)
                {
                    disease_sy+= ","+ new_Bell_palsy_Symptoms_array.get(i);
                }
            }

                if (disease_patient=="Alzheimer")
                {
                    for (int i=0;i<new_Alzheimer_Symptoms_array.size();i++)
                    {
                        disease_sy+=  ","+ new_Alzheimer_Symptoms_array.get(i);
                    }
                }
                    if (disease_patient=="neuralgia")
                    {
                        for (int i=0;i<new_neuralgia_Symptoms_array.size();i++)
                    {
                        disease_sy+=  ","+ new_neuralgia_Symptoms_array.get(i);
                    }

                    }

        intent.putExtra("disease_sy",disease_sy);
        startActivity(intent);
    }

    public  void save(View view)
    {

        //===========  add data to database

        Sqlite_patient_diseases sqliteUtil = new Sqlite_patient_diseases(getApplicationContext());
        SQLiteDatabase sqLiteDatabase=sqliteUtil.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(db_patient_Diseases.Username,Login.name);
        contentValues.put(db_patient_Diseases.Patient_Disease, disease_patient);
        contentValues.put(db_patient_Diseases.PatientSymptoms,input_disease_patient_Symptoms);
        long id=sqLiteDatabase.insert(db_patient_Diseases.Tbale_Name,null,contentValues);
        if (id>0)
        {
            Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_LONG).show();

        }
        else  Toast.makeText(getApplicationContext(),"Data not Saved",Toast.LENGTH_LONG).show();


    }
}
