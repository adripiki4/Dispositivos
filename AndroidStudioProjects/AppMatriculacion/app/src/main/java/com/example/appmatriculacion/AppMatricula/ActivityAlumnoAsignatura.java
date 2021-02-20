package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appmatriculacion.DATA.AlumnoAsignatura;
import com.example.appmatriculacion.DATA.AlumnoAsignaturaAdapter;
import com.example.appmatriculacion.DATA.AlumnoAsignaturaViewModel;
import com.example.appmatriculacion.DATA.Alumnos;
import com.example.appmatriculacion.DATA.Asignaturas;
import com.example.appmatriculacion.DATA.AsignaturasViewModel;
import com.example.appmatriculacion.Fragments.RelacionFragment;
import com.example.appmatriculacion.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityAlumnoAsignatura extends AppCompatActivity {
    private RecyclerView alumnosasignaturaslist;
    private AlumnoAsignaturaAdapter adapter;
    private AlumnoAsignaturaViewModel alumnoAsignaturaViewModel;
    private AsignaturasViewModel asignaturasViewModel;
    private List<Asignaturas>listapasa = new ArrayList<Asignaturas>();
    private List<AlumnoAsignatura> listrelacion = new ArrayList<AlumnoAsignatura>();
    private Alumnos alumnos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_asignatura);

        LiveData<List<AlumnoAsignatura>>listLiveData;


        alumnos = (Alumnos) getIntent().getSerializableExtra("alumno");
        String titulo = "Asignaturas de "+ alumnos.getName_alumno();
        this.setTitle(titulo);

        ViewModelProvider.AndroidViewModelFactory  factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        alumnoAsignaturaViewModel = new ViewModelProvider(this, factory).get(AlumnoAsignaturaViewModel.class);

        ViewModelProvider.AndroidViewModelFactory factory1 = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        asignaturasViewModel = new ViewModelProvider(this,factory1).get(AsignaturasViewModel.class);


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
            conseguirAsignaturas();
            conseguirRelacionActual();
            DialogFragment dialog = new RelacionFragment(Calcular());
            dialog.show(getSupportFragmentManager(),"relacion");
        });
    }

    public void conseguirAsignaturas(){
        asignaturasViewModel.getList_asignaturas().observe(this,asignaturasList -> {
            listapasa = asignaturasList;
        });
    }

    public void conseguirRelacionActual(){
        alumnoAsignaturaViewModel.getListalumnoAsignatura().observe(this,alumnoAsignaturas -> {
            listrelacion = alumnoAsignaturas;

        });
    }

    public List<Asignaturas> Calcular(){
        String compara;
        List<AlumnoAsignatura>listacompara = new ArrayList<AlumnoAsignatura>();
        for (AlumnoAsignatura alumnoAsignatura: listrelacion){
            compara = alumnoAsignatura.getDni_alumno();
            if (compara.equalsIgnoreCase(alumnos.getDni_alumno())==true){
                listacompara.add(alumnoAsignatura);
            }
        }


        List<Asignaturas> listbuena = new ArrayList<Asignaturas>();

        //Repite las asignauras, esta mal
        for (AlumnoAsignatura al : listacompara){
            for (Asignaturas a : listapasa){
                if (a.getId_asignatura()!= al.getId_asignatura()){
                    listbuena.add(a);
                }
            }
        }
        return listbuena;

    }





}