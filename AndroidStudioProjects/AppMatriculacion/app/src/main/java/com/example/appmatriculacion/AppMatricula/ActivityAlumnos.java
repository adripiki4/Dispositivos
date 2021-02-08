package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appmatriculacion.DATA.Alumnos;
import com.example.appmatriculacion.DATA.AlumnosViewModel;
import com.example.appmatriculacion.R;

public class ActivityAlumnos extends AppCompatActivity {
    private Button btndetalle;
    private AlumnosViewModel alumnosViewModel;
    private TextView dbText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        btndetalle = findViewById(R.id.asigalumno);
        dbText = findViewById(R.id.db_text2);


        btndetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAlumnos.this, AsigAlumno.class);
                startActivity(intent);
            }
        });

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        alumnosViewModel = new ViewModelProvider(this,factory).get(AlumnosViewModel.class);

        alumnosViewModel.getList_alumnos().observe(this,alumnos -> {
            StringBuilder sb = new StringBuilder();
            for(Alumnos alumno : alumnos){
                sb.append(alumno.getName_alumno()).append("\n");
                sb.append(alumno.getApellidos_alumno()).append("\n");
            }
            dbText.setText(sb.toString());
        });


    }
}