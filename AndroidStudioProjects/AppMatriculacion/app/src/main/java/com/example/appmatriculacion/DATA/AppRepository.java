package com.example.appmatriculacion.DATA;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {
    private final LiveData<List<Alumnos>> list_alumnos;
    private final LiveData<List<Asignaturas>> list_asignaturas;
    private final LiveData<List<AlumnoAsignatura>> list_alumnoAsignatura;

    private final AsignaturasDAO asignaturasDAO;
    private final AlumnoDAO alumnoDAO;
    private final AlumnoAsignaturaDAO alumnoAsignaturaDAO;

    public AppRepository(Context context){
        //AppDatabase db = AppDatabase.getInstance(context);
        AppDatabase db2 = AppDatabase.getInstance(context);
        asignaturasDAO = db2.asignaturasDAO();
        alumnoDAO = db2.alumnoDAO();
        alumnoAsignaturaDAO = db2.alumnoAsignaturaDAO();

        list_alumnos = alumnoDAO.getAll();
        list_asignaturas = asignaturasDAO.getAll();
        list_alumnoAsignatura = alumnoAsignaturaDAO.getAll();
    }

    public LiveData<List<Alumnos>> getAllAlumnos(){
        return list_alumnos;
    }

    public LiveData<List<Asignaturas>> getAllAsignaturas(){
        return list_asignaturas;
    }

    public LiveData<List<AlumnoAsignatura>> getAllAlumnoAsignatura(){
        return list_alumnoAsignatura;
    }

    public void insert_alumno(final Alumnos alumno){
        AppDatabase.dbExecutor.execute(()->alumnoDAO.insert(alumno));
    }
    public void insert_asignatura(final Asignaturas asignatura){
        AppDatabase.dbExecutor.execute(()->asignaturasDAO.insert(asignatura));
    }
    public void insert_alumnoAsignatura(final AlumnoAsignatura alumnoAsignatura){
        AppDatabase.dbExecutor.execute(()->alumnoAsignaturaDAO.insert(alumnoAsignatura));
    }
    public void delete_asignatura(Asignaturas asignaturas){
        AppDatabase.dbExecutor.execute(()-> asignaturasDAO.delete(asignaturas));
    }
    public void delete_alumno(Alumnos alumnos){
        AppDatabase.dbExecutor.execute(()-> alumnoDAO.delete(alumnos));
    }

    public void update_asignatura(Asignaturas asignaturas){
        AppDatabase.dbExecutor.execute(()-> asignaturasDAO.update(asignaturas));
    }

    public void update_alumno(Alumnos alumnos){
        AppDatabase.dbExecutor.execute(()->alumnoDAO.update(alumnos));
    }

}
