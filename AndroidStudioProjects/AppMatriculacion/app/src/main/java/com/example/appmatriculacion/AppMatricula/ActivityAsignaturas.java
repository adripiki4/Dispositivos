package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appmatriculacion.DATA.AsignaturaAdapter;
import com.example.appmatriculacion.DATA.Asignaturas;
import com.example.appmatriculacion.DATA.AsignaturasViewModel;
import com.example.appmatriculacion.Fragments.AsignaturaFragment;
import com.example.appmatriculacion.R;

public class ActivityAsignaturas extends AppCompatActivity {

    private AsignaturasViewModel asignaturasViewModel;
    private RecyclerView listasignaturas;
    private AsignaturaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        //TextView dbText = findViewById(R.id.db_text);


        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        asignaturasViewModel = new ViewModelProvider(this, factory).get(AsignaturasViewModel.class);

        setupList();


    }

    private void setupList(){
        listasignaturas = findViewById(R.id.listasignatura);
        adapter = new AsignaturaAdapter();
        listasignaturas.setAdapter(adapter);

        //Asignar escucha de items

        asignaturasViewModel.getList_asignaturas().observe(this,adapter::setItems);

    }


}