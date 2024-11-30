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
public class Foto implements Serializable {
    private static final long serialVersionUID = -482848973L;
    private String url;

    // Constructor
    public Foto(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return !url.isEmpty() ? url: "No disponible";
    }
}
