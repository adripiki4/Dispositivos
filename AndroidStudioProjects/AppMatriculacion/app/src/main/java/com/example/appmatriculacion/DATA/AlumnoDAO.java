package com.example.appmatriculacion.DATA;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AlumnoDAO {

    @Query("SELECT * FROM alumnos")
    LiveData<List<Alumnos>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Alumnos alumno);

    @Delete(entity = Alumnos.class)
    void delete(Alumnos alumnos);

    @Update(entity = Alumnos.class)
    void update(Alumnos alumnos);




}
