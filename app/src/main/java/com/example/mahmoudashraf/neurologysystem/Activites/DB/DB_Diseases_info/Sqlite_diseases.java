package com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_Diseases_info;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by elsayedfahmy on 4/14/2017.
 */

public class Sqlite_diseases extends SQLiteOpenHelper {
    public Sqlite_diseases(Context context) {
        super(context, db_Diseases.db_Name,null ,db_Diseases.db_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table "+db_Diseases.Tbale_Name+" ("+db_Diseases.Key_id+" integer primary key autoincrement,"
                +db_Diseases.Disease_Name+" text, "+
                db_Diseases.Symptoms_Disease+" text )" ;
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table "+db_Diseases.Tbale_Name;
        db.execSQL(sql);
        onCreate(db);

    }
}
