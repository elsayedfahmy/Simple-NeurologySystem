package com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_Diseases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_Diseases_info.db_Diseases;

/**
 * Created by elsayedfahmy on 4/14/2017.
 */

public class Sqlite_patient_diseases extends SQLiteOpenHelper {
    public Sqlite_patient_diseases(Context context) {
        super(context, db_patient_Diseases.db_Name,null ,db_Diseases.db_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+db_patient_Diseases.Tbale_Name+" ("+db_patient_Diseases.Key_id+" integer primary key autoincrement,"
                +db_patient_Diseases.Username+" text, "+
                db_patient_Diseases.Patient_Disease+" text, "+
                db_patient_Diseases.PatientSymptoms+" text )" ;
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
