package com.example.jobmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserMenu extends AppCompatActivity {
    long ahora = System.currentTimeMillis();
    Date fecha = new Date(ahora);
    DBHelper DB;
    Button ficharentrada, ficharsalida;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);
        DB = new DBHelper(this);
        Toast.makeText(UserMenu.this, "La hora actual es: " + fecha, Toast.LENGTH_SHORT).show();
        Bundle extras = getIntent().getExtras();
        String user="";
        if(extras!=null) user = extras.getString("UserName");
        String finalUser = user;
        ficharentrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(finalUser == "" || DB.getDiff(finalUser)<0)
                    Toast.makeText(UserMenu.this, "Todavia no has fichado la salida", Toast.LENGTH_SHORT).show();
                else{
                    DB.insertEntrada(finalUser, fecha.toString());
                    Toast.makeText(UserMenu.this, "Acabas de fichar la entrada", Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    }
