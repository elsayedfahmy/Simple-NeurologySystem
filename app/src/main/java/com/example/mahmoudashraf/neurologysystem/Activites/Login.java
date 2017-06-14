package com.example.mahmoudashraf.neurologysystem.Activites;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.Sqlite_patient;
import com.example.mahmoudashraf.neurologysystem.Activites.DB.DB_patient_info.db_patient;
import com.example.mahmoudashraf.neurologysystem.R;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    ArrayList<String> usernames_array ;
    ArrayList<String> passwords_array;
    public  static String name;
    Button Login,Register;
    EditText ed_passwored,ed_username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ed_username=(EditText)findViewById(R.id.mUserName);
        ed_passwored=(EditText)findViewById(R.id.mPassword);
        Register=(Button)findViewById(R.id.btnRegister);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this, Register.class);
                startActivity(i);
            }
        });

        Login=(Button)findViewById(R.id.btnLogin);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getData();
    }

    public void getData()
    {
        usernames_array = new ArrayList<String>();
       passwords_array = new ArrayList<String>();
        Sqlite_patient sqliteUtil = new Sqlite_patient(getApplicationContext());
        SQLiteDatabase sqLiteDatabase = sqliteUtil.getWritableDatabase();
        String[] colums = {db_patient.Key_id, db_patient.User_Name, db_patient.PassWord};
        Cursor cursor = sqLiteDatabase.query(db_patient.Tbale_Name, colums, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String username = cursor.getString(1);
            String pass = cursor.getString(2);
            usernames_array.add(username);
            passwords_array.add(pass);
        }

    }

    public void  do_Login(View view) {
        String input_username = ed_username.getText().toString();
        String input_password = ed_passwored.getText().toString();
        if (TextUtils.isEmpty(input_username) || input_username.matches(" ") || TextUtils.isEmpty(input_password) || input_password.matches(" ")) {
            Toast.makeText(this, "plz enter your full data ", Toast.LENGTH_SHORT).show();
            return;
        }
          else {
            getData();
            if (usernames_array.size()>0)
            {
        for (int i = 0; i < usernames_array.size(); i++) {
            if ((input_username.equals(usernames_array.get(i))) && (input_password.equals(passwords_array.get(i)))) {
                ed_username.setText("");
                ed_passwored.setText("");
                name=input_username;
                Intent intent = new Intent(Login.this, homeAvtivity.class);
                startActivity(intent);
              break;

            }
            else {
                Toast.makeText(Login.this, "Make sure your data is correct", Toast.LENGTH_SHORT).show();
              ed_username.setText("");
               ed_passwored.setText("");
            }
        }
            }else {
                Toast.makeText(Login.this, "Make sure your data is correct", Toast.LENGTH_SHORT).show();
                ed_username.setText("");
                ed_passwored.setText("");
            }


    }




    }
}
