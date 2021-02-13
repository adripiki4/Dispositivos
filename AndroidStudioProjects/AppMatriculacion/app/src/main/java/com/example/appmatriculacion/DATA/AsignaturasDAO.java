package com.example.appmatriculacion.DATA;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AsignaturasDAO {

    @Query("SELECT * FROM asignaturas")
    LiveData<List<Asignaturas>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Asignaturas asignatura);

    @Delete(entity = Asignaturas.class)
    void delete(Asignaturas asignaturas);
}
