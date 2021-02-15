package com.example.appmatriculacion.DATA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appmatriculacion.R;

import java.util.List;

public class ActivityAlumnoAsignatura extends AppCompatActivity {
    private AlumnoAsignaturaViewModel alumnoAsignaturaViewModel;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_asignatura);

        LiveData<List<AlumnoAsignatura>>listLiveData;

        ViewModelProvider.AndroidViewModelFactory  factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        alumnoAsignaturaViewModel = new ViewModelProvider(this, factory).get(AlumnoAsignaturaViewModel.class);

        alumnoAsignaturaViewModel.getListalumnoAsignatura().observe(this, alumnoAsignaturaList->{
            StringBuilder sb = new StringBuilder();
            for(AlumnoAsignatura a : alumnoAsignaturaList){
                sb.append(a.getDni_alumno()).append(" "+a.getId_asignatura());
            }
            txt.setText(sb.toString());
        });


    }
}