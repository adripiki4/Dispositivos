package com.example.appmatriculacion.DATA;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AlumnosViewModel extends AndroidViewModel {
    private final AppRepository appRepository;

    private final LiveData<List<Alumnos>> list_alumnos;

    public AlumnosViewModel(@NonNull Application application){
        super(application);
        appRepository = new AppRepository(application);
        list_alumnos = appRepository.getAllAlumnos();
    }

    public LiveData<List<Alumnos>> getList_alumnos(){
        return list_alumnos;
    }

    public void insert_alumno(Alumnos alumno){
        appRepository.insert_alumno(alumno);
    }

    public void delete_alumno(Alumnos alumnos){
        appRepository.delete_alumno(alumnos);
    }

    public void update_alumno(Alumnos alumnos){
        appRepository.update_alumno(alumnos);
    }
}
