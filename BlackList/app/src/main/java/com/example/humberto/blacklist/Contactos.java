package com.example.humberto.blacklist;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Contactos extends AppCompatActivity {

    ListView lista;
    Cursor c;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        lista = findViewById(R.id.lista);

        c  = getContentResolver().query (
                ContactsContract.Data.CONTENT_URI,
                new String[]
                {
                        ContactsContract.Data._ID,
                        ContactsContract.Data.DISPLAY_NAME,
                        ContactsContract.CommonDataKinds.Phone.NUMBER,
                        ContactsContract.CommonDataKinds.Phone.TYPE
                },
                ContactsContract.Data.MIMETYPE + "='"+
                ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE + "' AND "+
                ContactsContract.CommonDataKinds.Phone.NUMBER + " IS NOT NULL",
                null,null );


        SimpleCursorAdapter sca = new SimpleCursorAdapter
                (this, android.R.layout.simple_list_item_2,
                        c,
                        new String[]{
                                ContactsContract.Data.DISPLAY_NAME,
                                ContactsContract.CommonDataKinds.Phone.NUMBER
                        },
                        new int[]{android.R.id.text1,android.R.id.text2},
                        SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
                );

        lista.setAdapter(sca);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                c.moveToPosition(i);
                final Intent tent = new Intent();
                tent.putExtra("telefono", c.getString(2));
                setResult(1, tent);

                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setTitle("Tipo de bloqueo");
                builder.setItems(new CharSequence[]
                                {"Llamadas", "Mensajes", "Ambas"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        tent.putExtra("accion", "llamadas");
                                        finish();
                                        break;
                                    case 1:
                                        tent.putExtra("accion", "mensajes");
                                        finish();
                                        break;
                                    case 2:
                                        tent.putExtra("accion", "ambas");
                                        finish();
                                        break;
                                }
                            }
                        });
                builder.create().show();








            }
        });
    }
}
