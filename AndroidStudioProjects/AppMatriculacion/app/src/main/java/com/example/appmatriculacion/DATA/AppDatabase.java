package com.example.appmatriculacion.DATA;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Asignaturas.class, Alumnos.class}, version = 1, exportSchema = false)
public  abstract class AppDatabase  extends RoomDatabase {

    //Exposicion de DAOs
    public abstract AsignaturasDAO asignaturasDAO();

    public abstract AlumnoDAO alumnoDAO();

    private static final String DATABASE_NAME = "app-matriculas-db1";

    private static AppDatabase INSTANCE;

    private static final int THREADS = 4;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(THREADS);

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                            .addCallback(mRoomCallback2).fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

    //Prepoblar  Asignaturas base de datos con callback
    private static final RoomDatabase.Callback mRoomCallback2 = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            dbExecutor.execute(() -> {
                AsignaturasDAO asignaturasDAO = INSTANCE.asignaturasDAO();

                Asignaturas asignatura1 = new Asignaturas(01, "Programacion");
                Asignaturas asignatura2 = new Asignaturas(02, "Sistemas Informaticos");

                asignaturasDAO.insert(asignatura1);
                asignaturasDAO.insert(asignatura2);

                AlumnoDAO alumnoDAO = INSTANCE.alumnoDAO();

                Alumnos alumno1 = new Alumnos("2525582D","Adrian","Piquero Ibanez");
                Alumnos alumno2 = new Alumnos("47852547F","Roberto","Hernandez Perez");

                alumnoDAO.insert(alumno1);
                alumnoDAO.insert(alumno2);

            });

        }

    };


    //Prepoblar Alumnos base de datos con Callback
//    private static final RoomDatabase.Callback callbackAlumnos = new Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//
//            dbExecutor.execute(()->{
//                AlumnoDAO alumnoDAO = INSTANCE.alumnoDAO();
//
//                Alumnos alumno1 = new Alumnos("2525582D","Adrian","Piquero Ibanez");
//                Alumnos alumno2 = new Alumnos("47852547F","Roberto","Hernandez Perez");
//
//                alumnoDAO.insert(alumno1);
//                alumnoDAO.insert(alumno2);
//
//            });
//        }
//    };


}
