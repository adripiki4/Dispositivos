package com.example.calculadorafragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Obteniendo la instancia del botón add_fragment
        Button anadirfragment = findViewById(R.id.button);


        //escucha el boton
        anadirfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //forma estatica
                //Paso 1: Obtener la instancia del administrador de fragmentos
                androidx.fragment.app.FragmentManager fm = getSupportFragmentManager();

                //Paso 2: Crear una nueva transacción
                FragmentTransaction transaction = fm.beginTransaction();

                //Paso 3: Crear un nuevo fragmento y añadirlo
                fragmentocal fragment = new fragmentocal();
                transaction.add(R.id.contenedor, fragment);

                //Paso 4: Confirmar el cambio
                 transaction.commit();

            /*    //forma dinamica
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentocal fragment = new fragmentocal();
                fragmentTransaction.add(R.id.contenedor, fragment);
                fragmentTransaction.commit(); */

            }
        });

    }
}