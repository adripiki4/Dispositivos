package com.example.suma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText texto1 = findViewById(R.id.miTxt);
        final EditText texto2 = findViewById(R.id.miTxt2);



        final Button miBtn = findViewById(R.id.miBtn);
        miBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(String.valueOf(texto1.getText()));
                int num2 = Integer.parseInt(String.valueOf(texto2.getText()));
                Intent miIntent = new Intent(MainActivity.this, Suma2.class);
                Bundle miBundle = new Bundle();
                final int resultado = num1 + num2 ;
                String res = Integer.toString(resultado);
                /*final TextView muestra = findViewById(R.id.muestralo);
                muestra.setText(res);*/

                /*Comentando prueba*/


                String larespuesta = "El resulatdo es "+ res;
                miBundle.putString("Suma", larespuesta);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);


            }
        });




    }
}