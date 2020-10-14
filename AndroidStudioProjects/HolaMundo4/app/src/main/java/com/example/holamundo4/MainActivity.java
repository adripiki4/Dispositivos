package com.example.holamundo4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkboxBlogging;
    Button btnHobby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();


    }

    public void initialUISetup(){
        chkBoxCycling = findViewById(R.id.chkBoxCyling);
        chkBoxTeaching = findViewById(R.id.chkBoxTeaching);
        chkboxBlogging = findViewById(R.id.chkBoxBlogging);
        btnHobby = findViewById(R.id.btnHobby);
        txtHobby = findViewById(R.id.txtHobby);

        btnHobby.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getHobbyClick(v);
            }
        });
    }

    public void getHobbyClick(View v)
    {
        String strMessage = "";
        if(chkBoxCycling.isChecked())
        {
            strMessage+="Cycling ";
        }
        if(chkBoxTeaching.isChecked())
        {
            strMessage+="Teaching ";
        }
        if(chkboxBlogging.isChecked())
        {
            strMessage+="Blogging ";
        }
        showTextNotification(strMessage);
    }
    public void showTextNotification(String msgToDisplay)
    {
        txtHobby.setText(msgToDisplay);
//Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
}
