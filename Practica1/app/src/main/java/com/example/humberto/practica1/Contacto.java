package com.example.humberto.practica1;

import java.io.Serializable;
/**
 * Created by Dios on 05/09/2017.
 */

public class Contacto implements Serializable{

    private String usuario,correo, twitter, telefono, cumpleaños;

    public Contacto(String usuario, String correo, String twitter, String telefono, String cumpleaños) {
        this.usuario = usuario;
        this.correo = correo;
        this.twitter = twitter;
        this.telefono = telefono;
        this.cumpleaños = cumpleaños;
    }

    @Override
    public String toString(){
        return usuario +"\n"+correo;
    }
}
