package com.humberto.prueba_soporte;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
// librerias de soporte para plataformas anteriores de android
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Locale locale;
    private Button buttonn;
    private EditText lbl1;
    private EditText lbl2;
    private EditText lbl3;

    private Configuration config = new Configuration();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonn = ((Button)findViewById(R.id.btnCambiarIdioma));
        lbl1 = ((EditText) findViewById(R.id.lbl1));
        lbl2 = ((EditText) findViewById(R.id.lbl2));
        lbl3 = ((EditText) findViewById(R.id.lbl3));

        buttonn.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View view) {
                        showDialog();
                    }});

    }

    //abrimos el cuadro de dialogo para cambiar idioma
    private void showDialog(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setTitle(getResources().getString(R.string.change));
        //obtiene los idiomas del arreglo que hicimos en strings.xml
        String[] types = getResources().getStringArray(R.array.Lenguajes);
        b.setItems(types, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                //switch para cambiar el idioma elegido
                switch(which){
                    case 0:
                        locale = new Locale("en");
                        config.locale =locale;
                        break;
                    case 1:
                        locale = new Locale("es");
                        config.locale =locale;
                        break;
                    case 2:
                        locale = new Locale("fr");
                        config.locale =locale;
                        break;
                }
                //actualiza el idioma de los componentes de la aplicacion en base al idioma que elegimos
                getResources().updateConfiguration(config, null);
                Intent refresh = new Intent(MainActivity.this, MainActivity.class);
                startActivity(refresh);
                finish();
            }

        });

        b.show();
    }



}
