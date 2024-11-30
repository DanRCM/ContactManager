/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactadministrator.model;

import java.io.Serializable;

/**
 *
 * @author daniel24
 */
public class RedSocial implements Serializable {
    private static final long serialVersionUID = 1643968930L;
    private String redSocialNombre;
    private String identificador;  // Ejemplo: @usuario

    // Constructor
    public RedSocial(String redSocial, String identificador) {
        this.redSocialNombre = redSocial;
        this.identificador = identificador;
    }

    // Métodos getter
    public String getRedSocialNombre() {
        return redSocialNombre;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();

        boolean tieneIdentificador = !identificador.isEmpty();
        boolean tieneRedSocialNombre = !redSocialNombre.isEmpty();

        if (!tieneIdentificador && !tieneRedSocialNombre) {
            return "Sin redes sociales";
        }

        if (tieneIdentificador) {
            if (tieneRedSocialNombre) {
                resultado.append(redSocialNombre).append(" : ").append(identificador);
            } else {
                resultado.append("Red social: ").append(identificador);
            }
        } else {
            resultado.append("Usuario de red social: ").append(identificador);
        }

        return resultado.toString();
    }
}
