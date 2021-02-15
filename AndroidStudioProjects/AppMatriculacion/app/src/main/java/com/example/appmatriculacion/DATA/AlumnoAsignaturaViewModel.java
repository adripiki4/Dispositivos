package com.example.appmatriculacion.DATA;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AlumnoAsignaturaViewModel extends AndroidViewModel {
    private AppRepository repository;

    private final LiveData<List<AlumnoAsignatura>> listalumnoAsignatura;

    public AlumnoAsignaturaViewModel(@NonNull Application application) {
        super(application);
        repository = new AppRepository(application);
        listalumnoAsignatura = repository.getAllAlumnoAsignatura();
    }

    public LiveData<List<AlumnoAsignatura>> getListalumnoAsignatura(){
        return listalumnoAsignatura;
    }

    public void insert(AlumnoAsignatura alumnoAsignatura){
        repository.insert_alumnoAsignatura(alumnoAsignatura);
    }
}
