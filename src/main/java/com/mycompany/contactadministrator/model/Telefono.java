package com.mycompany.contactadministrator.model;

import java.io.Serializable;

public class Telefono  implements Serializable{
    private static final long serialVersionUID = 646072426L;
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
