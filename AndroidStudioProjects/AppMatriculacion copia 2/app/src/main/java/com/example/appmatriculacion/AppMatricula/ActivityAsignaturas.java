package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appmatriculacion.DATA.Asignaturas;
import com.example.appmatriculacion.DATA.AsignaturasViewModel;
import com.example.appmatriculacion.R;

public class ActivityAsignaturas extends AppCompatActivity {

    private AsignaturasViewModel asignaturasViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        TextView dbText = findViewById(R.id.db_text);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        asignaturasViewModel = new ViewModelProvider(this, factory).get(AsignaturasViewModel.class);

        asignaturasViewModel.getList_asignaturas().observe(this, asignaturas -> {
            StringBuilder sb = new StringBuilder();
            for(Asignaturas asig : asignaturas){
                sb.append(asig.getName_asignatura()).append("\n");
            }
            dbText.setText(sb.toString());
        });


    }
}