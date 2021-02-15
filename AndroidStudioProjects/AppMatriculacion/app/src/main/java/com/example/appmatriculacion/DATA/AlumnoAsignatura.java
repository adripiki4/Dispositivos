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

    @NonNull
    @ColumnInfo(name = "name_asignatura")
    String name_asignatura;

    public AlumnoAsignatura(@NonNull String dni_alumno, int id_asignatura, String name_asignatura) {
        this.dni_alumno = dni_alumno;
        this.id_asignatura = id_asignatura;
        this.name_asignatura = name_asignatura;
    }

    @NonNull
    public String getDni_alumno() {
        return dni_alumno;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    @NonNull
    public String getName_asignatura() {
        return name_asignatura;
    }
}
