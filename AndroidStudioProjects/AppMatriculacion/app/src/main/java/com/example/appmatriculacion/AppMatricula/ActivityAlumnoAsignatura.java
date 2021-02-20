package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appmatriculacion.DATA.AlumnoAsignatura;
import com.example.appmatriculacion.DATA.AlumnoAsignaturaAdapter;
import com.example.appmatriculacion.DATA.AlumnoAsignaturaViewModel;
import com.example.appmatriculacion.DATA.Alumnos;
import com.example.appmatriculacion.Fragments.RelacionFragment;
import com.example.appmatriculacion.R;

import java.util.List;

public class ActivityAlumnoAsignatura extends AppCompatActivity {
    private RecyclerView alumnosasignaturaslist;
    private AlumnoAsignaturaAdapter adapter;
    private AlumnoAsignaturaViewModel alumnoAsignaturaViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_asignatura);

        LiveData<List<AlumnoAsignatura>>listLiveData;


        Alumnos alumnos = (Alumnos) getIntent().getSerializableExtra("alumno");
        String titulo = "Asignaturas de "+ alumnos.getName_alumno();
        this.setTitle(titulo);

        ViewModelProvider.AndroidViewModelFactory  factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        alumnoAsignaturaViewModel = new ViewModelProvider(this, factory).get(AlumnoAsignaturaViewModel.class);


        setupList();
        set_alumno(alumnos);
        add_relacion();


    }

    public void setupList(){
        alumnosasignaturaslist= findViewById(R.id.lista_alumno_Asignatura);
        adapter = new AlumnoAsignaturaAdapter();
        alumnosasignaturaslist.setAdapter(adapter);


        //Asignar escucha de items
        adapter.setItemListener(new AlumnoAsignaturaAdapter.ItemListener() {
            @Override
            public void onClick(AlumnoAsignatura alumnoAsignatura) {

            }

            @Override
            public void onDeleteIconClicked(AlumnoAsignatura alumnoAsignatura) {

            }
        });

        alumnoAsignaturaViewModel.getListalumnoAsignatura().observe(this,adapter::setItems);
    }

    public void set_alumno(Alumnos alumno){
        adapter.setAlumnos(alumno);
    }

    public void add_relacion(){
        findViewById(R.id.add_relacion).setOnClickListener(v -> {
            DialogFragment dialog = new RelacionFragment();
            dialog.show(getSupportFragmentManager(),"relacion");
        });
    }



}