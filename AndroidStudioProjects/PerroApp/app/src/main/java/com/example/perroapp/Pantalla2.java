package com.example.perroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final TextView ponnombre = findViewById(R.id.txtimage);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        Bundle recoge = getIntent().getExtras();
        ponnombre.setText(recoge.getString("nombre"));
    }
}