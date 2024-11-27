package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.*;

public class DataLoader {

    public static OurCircularDoubleList<Contacto> cargarDatos() {
        OurCircularDoubleList<Contacto> contactos = new OurCircularDoubleList<>();

        // Crear contactos predeterminados
        Direccion direccionPersona = new Direccion("Calle Ficticia 123",
                "https://maps.google.com/?q=Calle+Ficticia+123");

        ContactoPersona contactoPersona = new ContactoPersona("Juan", "Pérez", direccionPersona, "Amigo", "2005-08-30");
        contactoPersona.agregarTelefono("123456789");
        contactoPersona.agregarEmail(new Email("juan@ejemplo.com", "personal"));
        contactoPersona.agregarRedSocial(new RedSocial("Twitter", "@juanperez"));
        contactoPersona.agregarFoto(new Foto("foto1.jpg"));

        Direccion direccionEmpresa = new Direccion("Avenida Empresa 456",
                "https://maps.google.com/?q=Avenida+Empresa+456");

        ContactoEmpresa contactoEmpresa = new ContactoEmpresa("Carlos", "Gómez", direccionEmpresa, "TechCorp",
                "Gerente de TI", "Estados Unidos");
        contactoEmpresa.agregarTelefono("987654321");
        contactoEmpresa.agregarEmail(new Email("carlos@techcorp.com", "corporativo"));
        contactoEmpresa.agregarRedSocial(new RedSocial("LinkedIn", "carlos-gomez"));
        contactoEmpresa.agregarFoto(new Foto("foto2.jpg"));

        // Añadir los contactos a la lista
        contactos.agregarUltimo(contactoPersona);
        contactos.agregarUltimo(contactoEmpresa);

        return contactos;
    }
}
