package com.example.appmatriculacion.DATA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;

import com.example.appmatriculacion.R;

public class NuevaAsignatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_asignatura);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        AsignaturasViewModel viewModel = new ViewModelProvider(this,factory).get(AsignaturasViewModel.class);

        setupCreateButton(viewModel);

    }

    private void setupCreateButton(AsignaturasViewModel viewModel){
        findViewById(R.id.create_button).setOnClickListener(view ->{
            //Obtener los valores
            EditText id = findViewById(R.id.nuevo_id);
            EditText nombre = findViewById(R.id.nuevo_nombre);

            String pasa = id.getText().toString();
            int pasaid = Integer.parseInt(pasa);
            String pasanombre = nombre.getText().toString();

            //Ignorar accion si no hay caracteres
            if (pasaid ==0 || pasanombre.isEmpty()){
                return;
            }

            //Crear entidad y guardarla
            Asignaturas asignaturas = new Asignaturas(pasaid, pasanombre);
            viewModel.insert_asignatura(asignaturas);

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