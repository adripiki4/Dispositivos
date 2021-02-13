package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;

import com.example.appmatriculacion.DATA.Alumnos;
import com.example.appmatriculacion.DATA.AlumnosViewModel;
import com.example.appmatriculacion.R;

public class NuevoAlumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_alumno);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        AlumnosViewModel viewModel = new ViewModelProvider(this,factory).get(AlumnosViewModel.class);

        setupCreateButton(viewModel);

    }
    private void setupCreateButton(AlumnosViewModel viewModel){
        findViewById(R.id.create_button).setOnClickListener(view ->{
            //Obtener los valores
            EditText nombretext = findViewById(R.id.nuevonombre_alu);
            EditText apellidostext = findViewById(R.id.nuevo_apellidos);
            EditText dnitext = findViewById(R.id.nuevo_dni);

            String nombre = nombretext.getText().toString();
            String apellidos = apellidostext.getText().toString();
            String dni = dnitext.getText().toString();

            //Ignorar accion si no hay caracteres
            if (nombre.isEmpty() ||apellidos.isEmpty() || dni.isEmpty() ){
                return;
            }

            //Crear entidad y guardarla
            Alumnos alumnos = new Alumnos(dni,nombre,apellidos);
            viewModel.insert_alumno(alumnos);

            //Ir a la lista
            finish();
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }



}