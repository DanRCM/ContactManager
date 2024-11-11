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
public class ContactoPersona implements Contacto {
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
    public ContactoPersona(){
        
    }
    
    //Metodos de manejo
    public void crearContacto() {
        
    }
    
    public void editarContacto() {
        
    }
    
    public void eliminarContacto() {
        
    }
    
    public void asociarContacto(Contacto contacto) {
        
    }
    
    public  void verAsociados() {
        
    }
    
}
