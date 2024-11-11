package com.mycompany.contactadministrator.model;

public class Telefono {
    private String telefono;

    public Telefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Telefono: " + telefono;
    }
}
