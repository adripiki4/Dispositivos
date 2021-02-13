package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appmatriculacion.DATA.AlumnoAdapter;
import com.example.appmatriculacion.DATA.Alumnos;
import com.example.appmatriculacion.DATA.AlumnosViewModel;
import com.example.appmatriculacion.R;

public class ActivityAlumnos extends AppCompatActivity {
    private RecyclerView alumnoslist;
    private AlumnoAdapter adapter;
    private AlumnosViewModel alumnosViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);



        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        alumnosViewModel = new ViewModelProvider(this,factory).get(AlumnosViewModel.class);

        setupList();


   }

   public void setupList(){
        alumnoslist = findViewById(R.id.lista_alumnos);
        adapter = new AlumnoAdapter();
        alumnoslist.setAdapter(adapter);

        //Asignar escucha de items


       alumnosViewModel.getList_alumnos().observe(this,adapter::setItems);
   }
}