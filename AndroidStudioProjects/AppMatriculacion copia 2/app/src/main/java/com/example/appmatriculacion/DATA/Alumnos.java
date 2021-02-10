package com.example.appmatriculacion.DATA;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "alumnos")
public class Alumnos {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "dni")
    String dni_alumno;

    @NonNull
    @ColumnInfo(name = "name")
    String name_alumno;

    @NonNull
    @ColumnInfo(name = "apellidos")
    String apellidos_alumno;

    public Alumnos(){

        dni_alumno = null;
        name_alumno = null;
        apellidos_alumno = null;
    }

    public Alumnos(@NonNull String dni, @NonNull String name, @NonNull String apellidos){
        dni_alumno = dni;
        name_alumno = name;
        apellidos_alumno = apellidos;

    }

    public String getDni_alumno(){
        return dni_alumno;
    }

    public String getName_alumno(){
        return name_alumno;
    }

    public String getApellidos_alumno(){
        return apellidos_alumno;
    }

}
