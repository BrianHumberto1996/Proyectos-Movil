package com.example.humberto.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String var;

    Button agregarContacto;
    ListView contactos;


    private ArrayList<Contacto> listacontacts;
    private ArrayAdapter<Contacto> adaptador1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Contacto co2 = (Contacto) data.getSerializableExtra("obj");
            listacontacts.add(co2);
            String[] u=new String[listacontacts.size()];
            for (int i=0;i<listacontacts.size(); i++){
                u[i]=listacontacts.get(i).toString();
            }
            ArrayAdapter<String>adp=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,u);
            contactos.setAdapter(adp);


        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarContacto=(Button)findViewById(R.id.btnAgregarContacto);
        contactos=(ListView)findViewById(R.id.lsContactos);

        listacontacts=new ArrayList<Contacto>();
        //listacontacts.add("Dios : 12345");



        agregarContacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivityForResult(intent,1);

            }
        });










    }
}
