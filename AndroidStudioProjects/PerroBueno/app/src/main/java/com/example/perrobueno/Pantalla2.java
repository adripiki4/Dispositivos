package com.example.perrobueno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Pantalla2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView ponnombre = findViewById(R.id.txtimage);
        final RadioGroup devuelve = findViewById(R.id.opiniones_group);
        final Button envviar = findViewById(R.id.send_button);
        final String[] respuesta = {""};


        Bundle recoge = getIntent().getExtras();
        ponnombre.setText(recoge.getString("nombre"));

        devuelve.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {


                switch (devuelve.getCheckedRadioButtonId()) {
                    case R.id.radio_hermoso:
                        respuesta[0] = "Hermoso";
                        break;
                    case R.id.radio_lindo:
                        respuesta[0] = "Nindo";
                        break;
                    case R.id.radio_normal:
                        respuesta[0] = "Normal";
                        break;
                    case R.id.radio_horroroso:
                        respuesta[0] = "Horroroso";
                    default:
                        break;
                }

            }
        });

        envviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent databack = new Intent();
                Bundle sending = new Bundle();
                sending.putString("respuesta", respuesta[0]);
                databack.putExtras(sending);
                setResult(RESULT_OK,databack);
                finish();

            }
        });


    }
}