package com.example.jobmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AdminMenu extends AppCompatActivity {
    DBHelper DB;
    Button monitorizarusuarios, gestionarusuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
    }
}