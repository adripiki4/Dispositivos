package com.example.appmatriculacion.DATA;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AsignaturasViewModel extends AndroidViewModel {
    private final AppRepository appRepository;

    private final LiveData<List<Asignaturas>> list_asignaturas;

    public AsignaturasViewModel(@NonNull Application application){
        super(application);
        appRepository = new AppRepository(application);
        list_asignaturas = appRepository.getAllAsignaturas();
    }
     public LiveData<List<Asignaturas>> getList_asignaturas(){
        return list_asignaturas;
     }

     public void insert_asignatura(Asignaturas asignatura){
        appRepository.insert_asignatura(asignatura);
     }

     public void delete_asignatura(Asignaturas asignaturas){
        appRepository.delete_asignatura(asignaturas);
     }

     public void update_asignatura(Asignaturas asignaturas){
        appRepository.update_asignatura(asignaturas);
     }
}
