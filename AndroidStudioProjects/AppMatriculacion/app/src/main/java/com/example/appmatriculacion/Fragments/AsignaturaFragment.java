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

import com.example.appmatriculacion.AppMatricula.ActivityAsignaturas;
import com.example.appmatriculacion.DATA.Asignaturas;
import com.example.appmatriculacion.R;

public class AsignaturaFragment extends DialogFragment {
    public Asignaturas asignaturas;

    public AsignaturaFragment(Asignaturas asignaturas){
        this.asignaturas= asignaturas;
    }

    public DialogFragmentupdate listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_signin, null);

        EditText id = view.findViewById(R.id.id_edit);
        EditText name = view.findViewById(R.id.name_edit);

        id.setText(asignaturas.getId_asignatura()+"");
        name.setText(asignaturas.getName_asignatura());



        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //String nuevoid = id.getText().toString();
                        String nuevonombre = name.getText().toString();
                        //asignaturas.setId_asignatura(nuevoid);
                        asignaturas.setName_asignatura(nuevonombre);
                        listener.onClickUpdate(asignaturas);
                    }
                });








        return builder.create();
    }

    public interface DialogFragmentupdate{
        void onClickUpdate(Asignaturas asignaturas);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            listener = (DialogFragmentupdate) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+"No implemento el listener update");
        }
    }
}
