package com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elsayedfahmy on 4/13/2017.
 */

public class Sqlite_patient extends SQLiteOpenHelper {
    public Sqlite_patient(Context context) {
        super(context, db_patient.db_Name,null ,db_patient.db_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        String sql = "create table "+db_patient.Tbale_Name+" ("+db_patient.Key_id+" integer primary key autoincrement,"
                +db_patient.User_Name+" text, "+
                db_patient.PassWord+" text, " +
                db_patient.Country+" text, " +
                db_patient.Age+" integer, "+
                db_patient.Gender+" text, " +
                db_patient.Social +" text, "+
                db_patient.Symtoms+" text, " +
                db_patient.Disease+" text )" ;
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "drop table "+db_patient.Tbale_Name;
        db.execSQL(sql);
        onCreate(db);

    }
}
