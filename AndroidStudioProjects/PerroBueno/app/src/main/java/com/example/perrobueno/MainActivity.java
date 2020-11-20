package com.example.perrobueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity{

    public static int COD_RESPUESTA=0;
    TextView opinion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button show_pet = findViewById(R.id.show_pet_button);
        final TextView page = findViewById(R.id.pageweb);
        opinion = (TextView)findViewById(R.id.opinion_text);

        show_pet.setOnClickListener(new View.OnClickListener() {
            String nombreperro = "TU PERRITO DE CONFIANZA";

            @Override
            public void onClick(View v) {

                Intent myintent = new Intent(MainActivity.this, Pantalla2.class);
                Bundle mybundle = new Bundle();
                mybundle.putString("nombre",nombreperro);
                myintent.putExtras(mybundle);
                startActivityForResult(myintent,COD_RESPUESTA);
            }
        });

        page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("http://hermosaprogramacion.blogspot.com");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                // Verificar si hay aplicaciones disponibles
                PackageManager packageManager = getPackageManager();
                List activities = packageManager.queryIntentActivities(webIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                // Si hay, entonces ejecutamos la actividad
                if (isIntentSafe) {
                    startActivity(webIntent);
                }
            }
        });

    }

    @Override
    public void onActivityResult(int cod_resp, int cod_result,Intent intent) {
        super.onActivityResult(cod_resp, cod_result, intent);
        if (cod_result == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            opinion.setText(otroBundle.getString("respuesta"));
        }
    }

}