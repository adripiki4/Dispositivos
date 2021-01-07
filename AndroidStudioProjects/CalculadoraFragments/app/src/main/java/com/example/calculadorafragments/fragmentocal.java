package com.example.calculadorafragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class fragmentocal  extends Fragment{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private double resultado;
    private String operador,reserva,mostrar;
    private boolean punto = false;
    private boolean entra = true;

    public fragmentocal() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentocal.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentocal newInstance(String param1, String param2) {
        fragmentocal fragment = new fragmentocal();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragmentocal, container, false);

        final TextView Resultado = view.findViewById(R.id.txtprincipal);

        final Button btncero = view.findViewById(R.id.numero_cero);
        final Button btnuno = view.findViewById(R.id.numero_1);
        final Button btndos = view.findViewById(R.id.numero_2);
        final Button btntres = view.findViewById(R.id.numero_3);
        final Button btncuatro = view.findViewById(R.id.numero_4);
        final Button btncinco = view.findViewById(R.id.numero_5);
        final Button btnseis = view.findViewById(R.id.numero_6);
        final Button btnsiete = view.findViewById(R.id.numero_7);
        final Button btnocho = view.findViewById(R.id.numero_8);
        final Button btnnueve = view.findViewById(R.id.numero_9);

        final Button btnpunto = view.findViewById(R.id.punto);
        final Button btnigual = view.findViewById(R.id.signo_igual);
        final Button btndivide = view.findViewById(R.id.signo_divide);
        final Button btnpor = view.findViewById(R.id.signo_por);
        final Button btnsuma = view.findViewById(R.id.signo_mas);
        final Button btnmenos = view.findViewById(R.id.signo_menos);
        final Button btnborra = view.findViewById(R.id.signo_borra);
        final Button btndelete = view.findViewById(R.id.signo_borrauno);


        //Funcionalidad de los botones

        //1
        btnuno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "1";
                Resultado.setText(mostrar);
            }
        });

        //2
        btndos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "2";
                Resultado.setText(mostrar);
            }
        });

        //3
        btntres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "3";
                Resultado.setText(mostrar);
            }
        });

        //4
        btncuatro.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "4";
                Resultado.setText(mostrar);
            }
        });

        //5
        btncinco.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "5";
                Resultado.setText(mostrar);
            }
        });

        //6
        btnseis.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "6";
                Resultado.setText(mostrar);
            }
        });

        //7
        btnsiete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "7";
                Resultado.setText(mostrar);
            }
        });

        //8
        btnocho.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "8";
                Resultado.setText(mostrar);
            }
        });

        //9
        btnnueve.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "9";
                Resultado.setText(mostrar);
            }
        });

        //0
        btncero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "0";
                Resultado.setText(mostrar);
            }
        });

        //Punto
        btnpunto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Comprueba que haya algun numero para no insetar un punto al principio
                mostrar = Resultado.getText().toString();
                if (mostrar.length()<=0){
                    entra=false;
                }
                if(punto==false&&entra==true){
                    mostrar = Resultado.getText().toString();
                    mostrar = mostrar + ".";
                    Resultado.setText(mostrar);
                    punto=true;
                }
                entra=true;
            }
        });

        //Suma
        btnsuma.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                reserva = Resultado.getText().toString();
                operador = "+";
                Resultado.setText("");
            }
        });

        //Resta
        btnmenos.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                reserva = Resultado.getText().toString();
                operador = "-";
                Resultado.setText("");
            }
        });

        //Multiplica
        btnpor.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                reserva = Resultado.getText().toString();
                operador = "*";
                Resultado.setText("");
            }
        });

        //Divide
        btndivide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                reserva = Resultado.getText().toString();
                operador = "/";
                Resultado.setText("");
            }
        });

        //Borrar
        btnborra.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = "";
                Resultado.setText(mostrar);
                reserva = "";
                operador = "";
                punto = false;
            }
        });

        //Borrar uno
        btndelete.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                //Comprueba si borra un punto para que deje volver a insertarlo
                char ultimo = mostrar.charAt(mostrar.length()-1);
                String compara = String.valueOf(ultimo);
                if (compara.equals(".")) {
                    punto=false;
                }
                mostrar = mostrar.substring(0,mostrar.length()-1);
                Resultado.setText(mostrar);
            }
        });

        //Igual
        btnigual.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mostrar = Resultado.getText().toString();
                mostrar = mostrar + "1";
                punto = false;
                if(operador.equals("-")){
                    resultado = Double.parseDouble(reserva) - Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if(operador.equals("+")){
                    resultado = Double.parseDouble(reserva) + Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if(operador.equals("/")){
                    resultado = Double.parseDouble(reserva) / Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
                if(operador.equals("*")){
                    resultado = Double.parseDouble(reserva) * Double.parseDouble(Resultado.getText().toString());
                    Resultado.setText(String.valueOf(resultado));
                }
            }
        });

        return view;
    }


}
