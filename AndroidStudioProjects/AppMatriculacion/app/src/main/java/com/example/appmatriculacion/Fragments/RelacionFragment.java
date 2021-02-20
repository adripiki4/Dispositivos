package com.example.appmatriculacion.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.DialogFragment;

import com.example.appmatriculacion.DATA.AlumnoAsignatura;
import com.example.appmatriculacion.DATA.Asignaturas;
import com.example.appmatriculacion.R;

import java.util.ArrayList;
import java.util.List;

public class RelacionFragment extends DialogFragment {
    private List<Asignaturas>asignaturasList = new ArrayList<Asignaturas>();
    private View view;
    private String [] nombreasignaturas;
    private List<Asignaturas>mostrar;

    public RelacionFragment(List<Asignaturas>asignaturasList){
        mostrar= asignaturasList;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){

//        Asignaturas asignatura = new Asignaturas(01,"Programacion2");
//        Asignaturas asignaturas1 = new Asignaturas(02,"Sistemas");
//        Asignaturas asignaturas2 = new Asignaturas(03,"Entornos");
//        asignaturasList.add(asignatura);
//        asignaturasList.add(asignaturas1);
//        asignaturasList.add(asignaturas2);

        nombreasignaturas = new String[mostrar.size()];
        for (int i = 0; i< mostrar.size(); i++){
            nombreasignaturas[i] = mostrar.get(i).getName_asignatura();
        }
        for (Asignaturas a : mostrar){
            System.out.println("Fragment"+a.getName_asignatura());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.dialog_relacion, null);


        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.opciones_asignatura);
        for (String nombre : nombreasignaturas){
            RadioButton radioButton = crearRadioButton(nombre);
            radioGroup.addView(radioButton);
            System.out.println("Nombre puesto"+ nombre);
        }

        builder.setView(view);


        return builder.create();
    }

    private RadioButton crearRadioButton(String nombreAsignatura){
        RadioButton nuevoRadio = new RadioButton(this.getContext());
        LinearLayout.LayoutParams params = new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.MATCH_PARENT);
        nuevoRadio.setLayoutParams(params);
        nuevoRadio.setText(nombreAsignatura);
        nuevoRadio.setTag(nombreAsignatura);
        return nuevoRadio;

    }
}
