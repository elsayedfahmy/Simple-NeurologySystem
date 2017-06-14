package com.example.mahmoudashraf.neurologysystem.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mahmoudashraf.neurologysystem.R;

public class homeAvtivity extends AppCompatActivity {
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_avtivity);
    }

    public  void done_consulte(View view)
    {
        Intent i=new Intent(homeAvtivity.this, consulte_class.class);
        startActivity(i);
    }

    public  void profile(View view)
    {
        Intent i=new Intent(homeAvtivity.this, profile.class);
        startActivity(i);
    }
    public  void admin(View view)
    {
        Intent i=new Intent(homeAvtivity.this, Admin_action.class);
        startActivity(i);
    }
}
