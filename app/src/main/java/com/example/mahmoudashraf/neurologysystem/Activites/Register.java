package com.example.mahmoudashraf.neurologysystem.Activites;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.Sqlite_patient;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.db_patient;
import com.example.mahmoudashraf.neurologysystem.R;

public class Register extends AppCompatActivity {



    String username_value,password_value,confirm_value,country_value,age_value,social_value,gender_value;

    String symptoms,disease;
    EditText ed_username,ed_password,ed_confirm,ed_country,ed_age,ed_social,ed_gender;
    Button btn_register ,btn_cancel;
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ed_username=(EditText)findViewById(R.id.mUserName);
        ed_password=(EditText)findViewById(R.id.mPassword);
        ed_confirm=(EditText)findViewById(R.id.mConfirm);
        ed_country=(EditText)findViewById(R.id.mCountry);
        ed_age=(EditText)findViewById(R.id.mAge);
        ed_social=(EditText)findViewById(R.id.mSocialStatus);
        ed_gender=(EditText)findViewById(R.id.mgender);

    }

public  void Register(View view)
{
    username_value=ed_username.getText().toString();
    password_value=ed_password.getText().toString();
   confirm_value=ed_confirm.getText().toString();
    country_value=ed_country.getText().toString();
    age_value=ed_age.getText().toString();
    social_value=ed_social.getText().toString();
    gender_value=ed_gender.getText().toString();

    if (username_value.equals("")||username_value==null
            ||password_value.matches("")||password_value==null
            ||confirm_value.matches("")||confirm_value==null
            ||country_value.matches("") ||country_value==null
            ||age_value.matches("") ||age_value==null
            ||social_value.matches("")||social_value==null
            ||gender_value.matches("")||gender_value==null
            )
    {
        Toast.makeText(this, "enter your full and correct data", Toast.LENGTH_SHORT).show();
        return;
    }

    if (password_value.equals(confirm_value))
    {
        //===========  add data to database
        Sqlite_patient sqliteUtil = new Sqlite_patient(getApplicationContext());
        SQLiteDatabase sqLiteDatabase=sqliteUtil.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(db_patient.User_Name,username_value);
        contentValues.put(db_patient.PassWord,password_value);
        contentValues.put(db_patient.Country,country_value);
        contentValues.put(db_patient.Age,age_value);
        contentValues.put(db_patient.Gender,gender_value);
        contentValues.put(db_patient.Social,social_value);
        symptoms="Non";
        disease="Non";
        contentValues.put(db_patient.Social,social_value);
        contentValues.put(db_patient.Gender,gender_value);
        long id=sqLiteDatabase.insert(db_patient.Tbale_Name,null,contentValues);

        if (id>0)
        {
            Toast.makeText(getApplicationContext(),"Register Done",Toast.LENGTH_LONG).show();
            ed_username.setText("");
            ed_password.setText("");
            ed_confirm.setText("");
            ed_country.setText("");
            ed_age.setText("");
            ed_social.setText("");
            ed_gender.setText("");
        }
        else  Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
    }
    else {
        Toast.makeText(getApplicationContext(), "please enter correct password", Toast.LENGTH_LONG).show();
        return;
    }
}
    public  void Cancel(View view)
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

}
