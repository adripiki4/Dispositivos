package com.example.sumaresta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText texto1 = findViewById(R.id.miTxt);
        final EditText texto2 = findViewById(R.id.miTxt2);
        final RadioGroup rg = findViewById(R.id.gruporb);
        final TextView muestra = findViewById(R.id.muestralo);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String resultado="";

                switch (rg.getCheckedRadioButtonId()){
                    case R.id.radio1:
                        resultado = resultado + (Integer.parseInt(String.valueOf(texto1.getText()))+ Integer.parseInt(String.valueOf(texto2.getText())));
                        break;
                    case R.id.radio2:
                        resultado = resultado + (Integer.parseInt(String.valueOf(texto1.getText())) - Integer.parseInt(String.valueOf(texto2.getText())));
                        break;
                    default:
                        break;

                }
                muestra.setText(resultado);
            }
        });

    }
}