package com.example.appmatriculacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnalumnos;
    private Button btnasignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnalumnos = findViewById(R.id.id_alumnos);
        btnasignaturas = findViewById(R.id.id_asignaturas);

        btnalumnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, ActivityAlumnos.class);
                startActivity(intent1);
            }
        });

        btnasignaturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, ActivityAsignaturas.class);
                startActivity(intent2);
            }
        });
    }
}