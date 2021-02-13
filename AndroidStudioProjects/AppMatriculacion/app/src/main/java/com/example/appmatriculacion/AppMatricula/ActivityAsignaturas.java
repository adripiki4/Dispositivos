package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


import com.example.appmatriculacion.DATA.AsignaturaAdapter;
import com.example.appmatriculacion.DATA.Asignaturas;
import com.example.appmatriculacion.DATA.AsignaturasViewModel;
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
        setupFab();


    }

    private void setupList(){
        listasignaturas = findViewById(R.id.listasignatura);
        adapter = new AsignaturaAdapter();
        listasignaturas.setAdapter(adapter);

        //Asignar escucha de items
        adapter.setItemListener(new AsignaturaAdapter.ItemListener() {
            @Override
            public void onClick(Asignaturas asignaturas) {

            }

            @Override
            public void onDeleteIconClicked(Asignaturas asignaturas) {
                asignaturasViewModel.delete_asignatura(asignaturas);
            }
        });

        asignaturasViewModel.getList_asignaturas().observe(this,adapter::setItems);

    }

    private void setupFab(){
        findViewById(R.id.add_asignatura).setOnClickListener(view ->{
            addNewAsignatura();
        });
    }

    private void addNewAsignatura(){
        startActivity(new Intent(this, NuevaAsignatura.class));
    }


}