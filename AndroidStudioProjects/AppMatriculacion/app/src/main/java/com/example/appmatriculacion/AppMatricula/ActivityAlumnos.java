package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appmatriculacion.DATA.AlumnoAdapter;
import com.example.appmatriculacion.DATA.AlumnoAsignatura;
import com.example.appmatriculacion.DATA.Alumnos;
import com.example.appmatriculacion.DATA.AlumnosViewModel;
import com.example.appmatriculacion.Fragments.AlumnoFragment;
import com.example.appmatriculacion.R;

public class ActivityAlumnos extends AppCompatActivity  implements AlumnoFragment.DialogFragmentupdate {
    private RecyclerView alumnoslist;
    private AlumnoAdapter adapter;
    private AlumnosViewModel alumnosViewModel;
    String titulo = "ALUMNOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);
        this.setTitle(titulo);


        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        alumnosViewModel = new ViewModelProvider(this,factory).get(AlumnosViewModel.class);

        setupList();
        setupFab();


   }

   public void setupList(){
        alumnoslist = findViewById(R.id.lista_alumnos);
        adapter = new AlumnoAdapter();
        alumnoslist.setAdapter(adapter);

        //Asignar escucha de items
       adapter.setItemListener(new AlumnoAdapter.ItemListener() {
           @Override
           public void onClick(Alumnos alumnos) {

           }

           @Override
           public void onDeleteIconClicked(Alumnos alumnos) {
            alumnosViewModel.delete_alumno(alumnos);
           }

           @Override
           public void onUpdateIconClicked(Alumnos alumnos) {
               DialogFragment dialog = new AlumnoFragment(alumnos);
               dialog.show(getSupportFragmentManager(),"alumnos");
           }

           @Override
           public void onDetailIconClicked(Alumnos alumnos) {
               Intent intent = new Intent(ActivityAlumnos.this, ActivityAlumnoAsignatura.class);
               intent.putExtra("alumno",alumnos);
               startActivity(intent);
           }
       });


       alumnosViewModel.getList_alumnos().observe(this,adapter::setItems);
   }

    private void setupFab(){
        findViewById(R.id.add_alumno).setOnClickListener(view ->{
            addNewAlumno();
        });
    }

    private void addNewAlumno(){
        startActivity(new Intent(this, NuevoAlumno.class));
    }

    @Override
    public void onClickUpdate(Alumnos alumnos) {
        alumnosViewModel.update_alumno(alumnos);
    }


}