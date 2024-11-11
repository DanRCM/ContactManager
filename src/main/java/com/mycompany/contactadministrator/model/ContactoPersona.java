/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactadministrator.model;

import com.mycompany.contactadministrator.util.OurArrayList;

/**
 *
 * @author EIMMY OCHOA
 */
public class ContactoPersona extends Contacto {
    //atributos 
    Nombre nombre ;
    Apellido apellido ;
    Direccion direccion ;
    OurArrayList<Email> l_emails ; 
    OurArrayList<Telefono> l_telefonos ;
    OurArrayList<RedSocial> l_redes ;
    OurArrayList<Foto> l_fotos ;
    OurArrayList<Fecha> l_fechas ;
    //no se si poner notas 
    
    
    //Constructor
    //No se si el constructor este bien asi, pero al inicalizar es el crear 
    public ContactoPersona(){
        crearContacto() ;
        l_emails = new OurArrayList<>(Email.class) ;
        l_telefonos = new OurArrayList<>(Telefono.class) ;
        l_redes = new OurArrayList<>(RedSocial.class) ;
        l_fotos = new OurArrayList<>(Foto.class) ;
        l_fechas = new OurArrayList<>(Fecha.class) ;
    }
    
    //Metodos de manejo
    public void crearContacto(){
        
    }
    
    public void editarContacto() {
        
    }
    
}
