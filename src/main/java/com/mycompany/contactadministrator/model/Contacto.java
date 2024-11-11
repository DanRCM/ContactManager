/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */
public abstract class Contacto {
    
    public abstract void crearContacto() ;
    public abstract void editarContacto() ;
    public abstract void eliminarContacto() ;
    public abstract void asociarContacto(Contacto contacto) ;
    public abstract void verAsociados() ;
    
}
