package com.example.appmatriculacion.DATA;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AlumnoAsignaturaDAO {
    @Query("SELECT * FROM alumnoasignatura")
    LiveData<List<AlumnoAsignatura>>getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AlumnoAsignatura alumnoAsignatura);
}
