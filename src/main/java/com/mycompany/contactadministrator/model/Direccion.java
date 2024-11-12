/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */
public class Direccion {
    private String direccion;
    private String enlaceGoogleMaps;

    // Constructor
    public Direccion(String direccion, String enlaceGoogleMaps) {
        this.direccion = direccion;
        this.enlaceGoogleMaps = enlaceGoogleMaps;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEnlaceGoogleMaps() {
        return enlaceGoogleMaps;
    }

    @Override
    public String toString() {
        return direccion + (enlaceGoogleMaps != null ? " (" + enlaceGoogleMaps + ")" : "");
    }
}

