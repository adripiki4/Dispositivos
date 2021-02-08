package com.example.appmatriculacion.DATA;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {
    private final LiveData<List<Alumnos>> list_alumnos;
    private final LiveData<List<Asignaturas>> list_asignaturas;

    private final AsignaturasDAO asignaturasDAO;
    private final AlumnoDAO alumnoDAO;

    public AppRepository(Context context){
        AppDatabase db = AppDatabase.getInstance(context);
        asignaturasDAO = db.asignaturasDAO();
        alumnoDAO = db.alumnoDAO();
        list_alumnos = alumnoDAO.getAll();
        list_asignaturas = asignaturasDAO.getAll();
    }

    public LiveData<List<Alumnos>> getAllAlumnos(){
        return list_alumnos;
    }

    public LiveData<List<Asignaturas>> getAllAsignaturas(){
        return list_asignaturas;
    }

    public void insert_alumno(final Alumnos alumno){
        AppDatabase.dbExecutor.execute(()->alumnoDAO.insert(alumno));
    }
    public void inser_asignatura(final Asignaturas asignatura){
        AppDatabase.dbExecutor.execute(()->asignaturasDAO.insert(asignatura));
    }

}
