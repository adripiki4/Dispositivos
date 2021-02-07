package com.example.appmatriculacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityAlumnos extends AppCompatActivity {
    private Button btndetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        btndetalle = findViewById(R.id.asigalumno);

        btndetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAlumnos.this, AsigAlumno.class);
                startActivity(intent);
            }
        });
    }
}