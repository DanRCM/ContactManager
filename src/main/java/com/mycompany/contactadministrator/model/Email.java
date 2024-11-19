package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */

public class Email {
    private String direccion;
    private String tipo;

    public Email(String direccion, String tipo) {
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo + ": " + direccion;
    }
}
