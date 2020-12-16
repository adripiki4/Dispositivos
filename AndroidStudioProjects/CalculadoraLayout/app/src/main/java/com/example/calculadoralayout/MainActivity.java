package com.example.calculadoralayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String resultado="";
    private int primero = 0;
    private int segundo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView muestra = findViewById(R.id.txtprincipal);

        final Button btncero = findViewById(R.id.numero_cero);
        final Button btnuno = findViewById(R.id.numero_1);
        final Button btndos = findViewById(R.id.numero_2);
        final Button btntres = findViewById(R.id.numero_3);
        final Button btncuatro = findViewById(R.id.numero_4);
        final Button btncinco = findViewById(R.id.numero_5);
        final Button btnseis = findViewById(R.id.numero_6);
        final Button btnsiete = findViewById(R.id.numero_7);
        final Button btnocho = findViewById(R.id.numero_8);
        final Button btnnueve = findViewById(R.id.numero_9);

        final Button btnpunto = findViewById(R.id.punto);
        final Button btnigual = findViewById(R.id.signo_igual);
        final Button btndivide = findViewById(R.id.signo_divide);
        final Button btnpor = findViewById(R.id.signo_por);
        final Button btnsuma = findViewById(R.id.signo_mas);
        final Button btnmenos = findViewById(R.id.signo_menos);


    }
}