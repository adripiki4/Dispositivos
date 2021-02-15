package com.example.appmatriculacion.DATA;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "alumnoasignatura", primaryKeys = {"dni_alumno","id_asignatura"})
public class AlumnoAsignatura {
    @NonNull
    @ColumnInfo(name = "dni_alumno")
    String dni_alumno;

    @NonNull
    @ColumnInfo(name = "id_asignatura")
    int id_asignatura;

    public AlumnoAsignatura(@NonNull String dni_alumno, int id_asignatura) {
        this.dni_alumno = dni_alumno;
        this.id_asignatura = id_asignatura;
    }

    @NonNull
    public String getDni_alumno() {
        return dni_alumno;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }
}
