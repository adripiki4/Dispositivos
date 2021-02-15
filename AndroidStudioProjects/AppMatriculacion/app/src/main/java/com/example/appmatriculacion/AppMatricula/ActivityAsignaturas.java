package com.example.appmatriculacion.AppMatricula;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;


import com.example.appmatriculacion.DATA.AsignaturaAdapter;
import com.example.appmatriculacion.DATA.Asignaturas;
import com.example.appmatriculacion.DATA.AsignaturasViewModel;
import com.example.appmatriculacion.Fragments.AsignaturaFragment;
import com.example.appmatriculacion.R;

public class ActivityAsignaturas extends AppCompatActivity implements AsignaturaFragment.DialogFragmentupdate {

    private AsignaturasViewModel asignaturasViewModel;
    private RecyclerView listasignaturas;
    private AsignaturaAdapter adapter;
    String titulo = "ASIGNATURAS";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);
        this.setTitle(titulo);
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

            @Override
            public void onEditIconClicked(Asignaturas asignaturas) {
                DialogFragment dialogFragment = new AsignaturaFragment(asignaturas);
                dialogFragment.show(getSupportFragmentManager(),"Asignatura");
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


    @Override
    public void onClickUpdate(Asignaturas asignaturas) {
        asignaturasViewModel.update_asignatura(asignaturas);
    }
}