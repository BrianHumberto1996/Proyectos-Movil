package com.humberto.practicafragmentos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActividadConFragmentHardcoded extends AppCompatActivity implements Comunicador{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_con_fragment_hardcoded);



    }



    @Override
    public void responder(String datos){

        android.app.FragmentManager fragmentManager = getFragmentManager();

        FragmentoDos fragmentoDos = (FragmentoDos) fragmentManager.findFragmentById(R.id.fragDos);
        fragmentoDos.cambiarTexto(datos);

    }



}
