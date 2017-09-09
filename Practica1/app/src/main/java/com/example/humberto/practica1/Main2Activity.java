package com.example.humberto.practica1;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText editText, editText2,editText3,editText6,editText7;
    Button Guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Guardar = (Button)findViewById(R.id.btnGuardar);
        editText=(EditText)findViewById(R.id.txtUser);
        editText2=(EditText)findViewById(R.id.txtEmail);
        editText3=(EditText)findViewById(R.id.txtTwitter);
        editText6=(EditText)findViewById(R.id.txtPhone);
        editText7=(EditText)findViewById(R.id.txtBirthday);



        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacto con = new Contacto(editText.getText().toString(),editText2.getText().toString(),editText3.getText().toString(),editText6.getText().toString(),editText7.getText().toString());
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra("obj",con);
                setResult(RESULT_OK,intent);
                finish();

            }
        });
    }
}
