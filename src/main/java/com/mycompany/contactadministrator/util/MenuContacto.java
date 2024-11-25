package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.Contacto;
import com.mycompany.contactadministrator.model.ContactoEmpresa;
import com.mycompany.contactadministrator.model.ContactoPersona;

public class MenuContacto {

    public static void añadirContacto(OurCircularDoubleList<Contacto> contactos) {
        mostrarOpcionesContacto();
        System.out.print("Ingrese el número del contacto a crear: ");
        int n = Inputs.pedirInputNumerico();
        ContactFactory contactFactory = new ContactFactory();

        if (n == 1) {
            ContactoPersona persona = contactFactory.crearContactoPersona();
            contactos.agregarUltimo(persona);
        } else if (n == 2) {
            ContactoEmpresa empresa = contactFactory.crearContactoEmpresa();
            contactos.agregarUltimo(empresa);
        } else {
            System.out.println("Opción no válida.");
        }

        System.out.println();
        contactos.printList();
    }

    public static void mostrarOpcionesContacto() {
        System.out.println("");
        System.out.println("Opciones de contacto: ");
        System.out.println("1. Persona");
        System.out.println("2. Empresa");
        System.out.println("");
    }
}