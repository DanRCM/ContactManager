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
public class ContactoEmpresa extends Contacto {
    //atributos 
    Nombre nombre ;
    Direccion direccion ;
    OurArrayList<Email> l_emails ;
    OurArrayList<Telefono> l_telefonos ;
    
    //estos atributos no se si si o no
    //OurArrayList<RedSocial> l_redes ;
    //OurArrayList<Foto> l_fotos ;
    //OurArrayList<Fecha> l_fechas ;
    
    //Constructor
    //no se x2
    public ContactoEmpresa(){
        crearContacto();
        l_emails = new OurArrayList<>(Email.class) ;
        l_telefonos = new OurArrayList<>(Telefono.class) ;
    }
    
    //Metodos
    public void crearContacto(){
        
    }

    public void editarContacto() {
        
    }
    
    
}
