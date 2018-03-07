package com.example.humberto.blacklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.humberto.blacklist.Contactos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static final int PETICION_DE_USUARIO = 1;
    private ArrayList<String> llamadas = new ArrayList<>();
    private ArrayList<String> mensajes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seleccionar(View v){
        Intent tent = new Intent(this, Contactos.class);
        startActivityForResult(tent, PETICION_DE_USUARIO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == PETICION_DE_USUARIO){
            String telefono = data.getExtras().getString("telefono");
            String tipo = data.getExtras().getString("accion");
            if(tipo.equals("llamadas")){
                llamadas.add(telefono);
            }else if(tipo.equals("mensajes")){
                mensajes.add(telefono);
            }else if(tipo.equals("ambas")){
                llamadas.add(telefono);
                mensajes.add(telefono);
            }
            Toast.makeText(this, telefono + " - " + tipo, Toast.LENGTH_SHORT).show();
        }
    }
}
