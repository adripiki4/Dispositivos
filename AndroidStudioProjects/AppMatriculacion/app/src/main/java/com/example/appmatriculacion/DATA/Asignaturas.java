package com.example.appmatriculacion.DATA;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "asignaturas")
public class Asignaturas {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    int id_asignatura;

    @NonNull
    @ColumnInfo(name = "name")
    String name_asignatura;

    public Asignaturas(){

        name_asignatura = null;
        id_asignatura = 0;
    }

    public Asignaturas(@NonNull int id, String name){
        id_asignatura = id;
        name_asignatura = name;
    }

    public int getId_asignatura(){
        return id_asignatura;
    }

    public String getName_asignatura(){
        return name_asignatura;
    }

    public void setId_asignatura(String id_asignatura) {
        int id = Integer.parseInt(id_asignatura);
        this.id_asignatura = id;
    }

    public void setName_asignatura(@NonNull String name_asignatura) {
        this.name_asignatura = name_asignatura;
    }
}
