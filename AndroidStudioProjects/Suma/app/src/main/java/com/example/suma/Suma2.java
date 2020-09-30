package com.example.suma;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Suma2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma2);

        final TextView sumatorio = findViewById(R.id.miMensaje);
        Bundle miBundleRecoger = getIntent().getExtras();
        sumatorio.setText(miBundleRecoger.getString("Suma"));

        final Button mibotonvolver = findViewById(R.id.botonVolver);
        mibotonvolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(Suma2.this, MainActivity.class);
                startActivity(miIntent);
            }
        });

    }
}