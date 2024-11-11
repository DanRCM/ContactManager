/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */
public class RedSocial {
    private String redSocial;
    private String identificador;  // Ejemplo: @usuario

    // Constructor
    public RedSocial(String redSocial, String identificador) {
        this.redSocial = redSocial;
        this.identificador = identificador;
    }

    // Métodos getter
    public String getRedSocial() {
        return redSocial;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        return redSocial + ": " + identificador;
    }
}
