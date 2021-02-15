package com.example.appmatriculacion.Fragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import com.example.appmatriculacion.DATA.Alumnos;
import com.example.appmatriculacion.R;

public class AlumnoFragment extends DialogFragment {

    public Alumnos alumnos;

    public AlumnoFragment(Alumnos alumnos){
        this.alumnos=alumnos;
    }
    public DialogFragmentupdate listener;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_alumno_edit, null);

        EditText nombre = view.findViewById(R.id.nombre_edit);
        EditText apellidos = view.findViewById(R.id.apellidos_edit);
        EditText dni = view.findViewById(R.id.dni_edit);

        nombre.setText(alumnos.getName_alumno());
        apellidos.setText(alumnos.getApellidos_alumno());
        dni.setText(alumnos.getDni_alumno());

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nuevonombre= nombre.getText().toString();
                        String nuevoapellido = apellidos.getText().toString();
                        //String nuevodni = dni.getText().toString();
                        alumnos.setName_alumno(nuevonombre);
                        alumnos.setApellidos_alumno(nuevoapellido);
                       // alumnos.setDni_alumno(nuevodni);

                        listener.onClickUpdate(alumnos);
                    }
                });








        return builder.create();
    }


    public interface DialogFragmentupdate{
        void onClickUpdate(Alumnos alumnos);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            listener = (AlumnoFragment.DialogFragmentupdate) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"No implemento el listener update");
        }
    }
}
