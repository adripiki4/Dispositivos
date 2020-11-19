package com.example.perrobueno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.widget.TextView;


public class Pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView ponnombre = findViewById(R.id.txtimage);

        Bundle recoge = getIntent().getExtras();
        ponnombre.setText(recoge.getString("nombre"));
    }
}