
package com.portfolio.mgb.security.controller;


public class Mensaje {
    private String mensaje;
    
    //Contructor vacio 

    public Mensaje() {
    }
    
    //Constructor con datos

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    //Getters y setters

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}

