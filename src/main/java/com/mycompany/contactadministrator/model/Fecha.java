/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */
import java.util.Date;

public class Fecha {
    private Date fecha;
    private String descripcion;  // Ejemplo: "Cumpleaños", "Aniversario", etc.

    public Fecha(Date fecha, String descripcion) {
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion + ": " + fecha.toString();
    }
}

