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
        //_tvTime.setText(_sdfWatchTime.format(new Date()));
//        ficharentrada.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
////                if(user.equals("")||pass.equals("")||repass.equals(""))
////                    Toast.makeText(RegisterActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
////                else{
////                    if(pass.equals(repass)){
////                        Boolean checkuser = DB.checkusername(user);
////                        if(checkuser==false){
////                            Boolean insert = DB.insertData(user, pass);
////                            if(insert==true){
////                                Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
////                                Intent intent = new Intent(getApplicationContext(),UserMenu.class);
////                                startActivity(intent);
////                            }else{
////                                Toast.makeText(RegisterActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
////                            }
////                        }
////                        else{
////                            Toast.makeText(RegisterActivity.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
////                        }
////                    }else{
////                        Toast.makeText(RegisterActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
////                    }
////                }
//            }
        //});
        }
    }
