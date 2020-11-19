package com.example.perrobueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private Button show_pet;
    public final static String nombreperro = "TU PERRITO DE CONFIANZA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_pet = findViewById(R.id.show_pet_button);

        show_pet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle mybundle = new Bundle();
                mybundle.putString("nombre",nombreperro);
                myintent.putExtras(mybundle);
                startActivity(myintent);
            }
        });

    }

}