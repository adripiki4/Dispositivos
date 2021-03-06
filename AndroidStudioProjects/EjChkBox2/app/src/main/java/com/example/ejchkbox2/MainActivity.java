package com.example.ejchkbox2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chkBoxCycling;
    CheckBox chkBoxTeaching;
    CheckBox chkBoxBlogging;
    Button btnHoby;
    TextView txtHobby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialUISetup();
    }

    public void initialUISetup(){
        chkBoxCycling = (CheckBox) findViewById(R.id.chkBoxCyling);
        chkBoxTeaching = (CheckBox) findViewById(R.id.chkBoxTeaching);
        chkBoxBlogging = (CheckBox) findViewById(R.id.chkBoxBlogging);

        TextView txtHobby = (TextView)findViewById(R.id.txtHobby);
        chkBoxCycling.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxTeaching.setOnCheckedChangeListener(new myCheckBoxChangeClicker());
        chkBoxBlogging.setOnCheckedChangeListener(new myCheckBoxChangeClicker());

    }

    class myCheckBoxChangeClicker implements CheckBox.OnCheckedChangeListener
    { @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if(isChecked)
        {
            if(buttonView==chkBoxCycling)
            {
                showTextNotification("Cycling");
            }
            if(buttonView==chkBoxTeaching)
            {
                showTextNotification("Teaching");
            }
            if(buttonView==chkBoxBlogging)
            {
                showTextNotification("BlackBlogging");
            }
        }
    }
    }// clase interna
    public void showTextNotification(String msgToDisplay)
    { Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();
    }
}