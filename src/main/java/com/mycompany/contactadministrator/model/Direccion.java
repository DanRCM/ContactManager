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
public class Direccion implements Serializable {
    private static final long serialVersionUID = 300819007L;
    private String direccion;
    private String pais;
    private String enlaceGoogleMaps;

    // Constructor
    public Direccion(String pais, String direccion, String enlaceGoogleMaps) {
        this.direccion = direccion;
        this.pais = pais;
        this.enlaceGoogleMaps = enlaceGoogleMaps;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEnlaceGoogleMaps() {
        return enlaceGoogleMaps;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return (pais != null ? pais : " ") + direccion + (enlaceGoogleMaps != null ? " (" + enlaceGoogleMaps + ")" : "");
    }
}

