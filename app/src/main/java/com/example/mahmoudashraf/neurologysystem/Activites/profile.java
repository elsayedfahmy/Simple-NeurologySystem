package com.example.mahmoudashraf.neurologysystem.Activites;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_Diseases_info.Sqlite_diseases;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_Diseases_info.db_Diseases;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_Diseases.Sqlite_patient_diseases;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_Diseases.db_patient_Diseases;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.Sqlite_patient;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.db_patient;
import com.example.mahmoudashraf.neurologysystem.R;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    Button btn_edite_pfofile,btn_save_pfofile;
    EditText ed_username, ed_country, ed_age, ed_gender, ed_social, ed_tailness,ed_PatientSymptoms;
    ArrayList<String> usernames_array = new ArrayList<String>();
    ArrayList<String> country_array = new ArrayList<String>();
    ArrayList<String> age_array = new ArrayList<String>();
    ArrayList<String> gender_array = new ArrayList<String>();
    ArrayList<String> social_array = new ArrayList<String>();
    ArrayList<String> tailness_array = new ArrayList<String>();
    ArrayList<String> symptoms_array = new ArrayList<String>();
    ArrayList<String> user_array = new ArrayList<String>();
    String old_countery,old_age,old_gender,old_social;
    String ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ed_username = (EditText) findViewById(R.id.mUserName);
        ed_country = (EditText) findViewById(R.id.mCountry);
        ed_age = (EditText) findViewById(R.id.mAge);
        ed_gender = (EditText) findViewById(R.id.mGender);
        ed_social = (EditText) findViewById(R.id.mSocial);
        ed_tailness = (EditText) findViewById(R.id.mTallness);
        ed_PatientSymptoms = (EditText) findViewById(R.id.mPatientSymptoms);
        btn_edite_pfofile = (Button) findViewById(R.id.mEditProfile);
        btn_save_pfofile = (Button) findViewById(R.id.msaveProfile);
        //-------------------------------------------------
        old_countery=ed_country.getText().toString();
        old_age=ed_age.getText().toString();
        old_countery=ed_gender.getText().toString();
        old_social=ed_social.getText().toString();

//===========================================================
        boolean enable=false;
ed_username.setEnabled(enable);
        ed_country.setEnabled(enable);
        ed_age.setEnabled(enable);
        ed_social.setEnabled(enable);
        ed_tailness.setEnabled(enable);
        ed_PatientSymptoms.setEnabled(enable);
       ed_gender.setEnabled(enable);
        btn_save_pfofile.setEnabled(enable);
        btn_edite_pfofile.setEnabled(enable);

        //===========================================================
        ss=Login.name;

        Sqlite_patient sqliteUtil = new Sqlite_patient(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = sqliteUtil.getWritableDatabase();
        String[] colums = {db_patient.Key_id, db_patient.User_Name, db_patient.Country, db_patient.Age, db_patient.Gender, db_patient.Social, db_patient.Disease};
        Cursor cursor = sqLiteDatabase.query(db_patient.Tbale_Name, colums, null, null, null, null, null);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String user_name = cursor.getString(1);
            String country = cursor.getString(2);
            String age = cursor.getString(3);
            String gender = cursor.getString(4);
            String social = cursor.getString(5);
            String tailness = cursor.getString(6);

            usernames_array.add(user_name);
            country_array.add(country);
            age_array.add(age);
            gender_array.add(gender);
            social_array.add(social);
            tailness_array.add(tailness);
        }

//==================================================================
        Sqlite_patient_diseases sqlite = new Sqlite_patient_diseases(getApplicationContext());
        SQLiteDatabase sqLiteDatabase2=sqlite.getWritableDatabase();
        String[] colums22 = {db_patient_Diseases.Key_id,db_patient_Diseases.Username,db_patient_Diseases.Patient_Disease, db_patient_Diseases.PatientSymptoms};
        Cursor cursor22 = sqLiteDatabase2.query(db_patient_Diseases.Tbale_Name, colums22, null, null, null, null, null);
        String all_Patient_Disease="";
        String all_PatientSymptoms="";

        while (cursor22.moveToNext()) {
            int id = cursor22.getInt(0);
            String user = cursor22.getString(1);
            String patient_Disease = cursor22.getString(2);
            String patientSymptoms = cursor22.getString(3);
            if (ss == user) {
              //  Toast.makeText(getApplicationContext(),"user is"+ss+"patient_Disease"+patient_Disease+"patientSymptoms"+patientSymptoms,Toast.LENGTH_LONG).show();
               all_Patient_Disease += ","+patient_Disease;
                all_PatientSymptoms +=","+ patientSymptoms;



            }
        }
        ed_PatientSymptoms.setText(all_PatientSymptoms.toString());
        ed_tailness.setText(all_Patient_Disease.toString());
        /*
       for (int y=0;y <user_array.size();y++)
       {if (ss.equals(user_array.get(y))) {
           {
               ed_PatientSymptoms.setText(all_PatientSymptoms.toString());
               ed_tailness.setText(all_Patient_Disease.toString());
           }
       }

       }
*/


        //----------------------------------------

        for (int i = 0; i < usernames_array.size(); i++) {
            if (ss.equals(usernames_array.get(i))) {
                ed_username.setText(usernames_array.get(i).toString());
                ed_country.setText(country_array.get(i).toString());
                ed_age.setText(age_array.get(i).toString());
                ed_gender.setText(gender_array.get(i).toString());
                ed_social.setText(social_array.get(i).toString());

                break;
            } else {
                Toast.makeText(profile.this, "this user not found" + country_array.get(i), Toast.LENGTH_SHORT).show();
            }

        }


    }


    public void Edit_Profile(View view) {
        /*
        boolean enable=true;
        ed_country.setEnabled(enable);
        ed_age.setEnabled(enable);
        ed_social.setEnabled(enable);
        ed_gender.setEnabled(enable);
        btn_save_pfofile.setEnabled(enable);
*/
        }

    public void Save(View view) {
        btn_edite_pfofile.setEnabled(false);

      //  Toast.makeText(profile.this, " update"+ed_country.getText().toString(), Toast.LENGTH_SHORT).show();

        Sqlite_patient sqliteUtil = new Sqlite_patient(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = sqliteUtil.getWritableDatabase();
        //new data
        ContentValues contentValues=new ContentValues();
        contentValues.put(db_patient.Country,ed_country.getText().toString());
        contentValues.put(db_patient.Age,ed_age.getText().toString());
       contentValues.put(db_patient.Gender,ed_gender.getText().toString());
        contentValues.put(db_patient.Social,ed_social.getText().toString());
        //old data
        String []whereargs={old_countery};


      //  int i =  sqLiteDatabase.update(db_patient.db_Name, contentValues, db_patient.User_Name + "=" + ed_username.getText().toString(), null);
        int count = sqLiteDatabase.update(
                db_patient.db_Name,
              contentValues ,
                db_patient.User_Name+" = "+ed_username.getText().toString(),
                null);


        if (count>0)
        {
            Toast.makeText(profile.this, "Done update", Toast.LENGTH_SHORT).show();
        }



    }


    }
