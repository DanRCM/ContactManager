package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.*;
import java.time.LocalDate;

public class DataLoader {

    public static OurCircularDoubleList<Contacto> cargarDatos() {
        OurCircularDoubleList<Contacto> contactos = new OurCircularDoubleList<>();

        // Crear contactos predeterminados
        Direccion direccionPersona = new Direccion("Calle Ficticia 123",
                "https://maps.google.com/?q=Calle+Ficticia+123");

        // Convertir la fecha de nacimiento de String a LocalDate
        LocalDate fechaNacimientoPersona1 = ContactoPersona.convertirStringADate("30/08/2005");
        ContactoPersona contactoPersona = new ContactoPersona("Juan", "Pérez", direccionPersona, "Amigo", fechaNacimientoPersona1);
        contactoPersona.agregarTelefono("123456789");
        contactoPersona.agregarEmail(new Email("juan@ejemplo.com", "personal"));
        contactoPersona.agregarRedSocial(new RedSocial("Twitter", "@juanperez"));
        contactoPersona.agregarFoto(new Foto("foto1.jpg"));

        Direccion direccionPersona2 = new Direccion("Calle Ficticia 245",
                "https://maps.google.com/?q=Calle");

        // Convertir la fecha de nacimiento de String a LocalDate
        LocalDate fechaNacimientoPersona2 = ContactoPersona.convertirStringADate("10/05/2003");
        ContactoPersona contactoPersona2 = new ContactoPersona("Carlos", "Péreira", direccionPersona2, "Amigo", fechaNacimientoPersona2);
        contactoPersona2.agregarTelefono("0993827433");
        contactoPersona2.agregarEmail(new Email("carlos@ejemplo.com", "personal"));
        contactoPersona2.agregarRedSocial(new RedSocial("Twitter", "@carlosPereira"));
        contactoPersona2.agregarFoto(new Foto("foto2.jpg"));

        // Asociar contactos
        contactoPersona.agregarContactoAsociado(contactoPersona);
        contactoPersona.agregarContactoAsociado(contactoPersona2);

        Direccion direccionEmpresa = new Direccion("Avenida Empresa 456",
                "https://maps.google.com/?q=Avenida+Empresa+456");

        ContactoEmpresa contactoEmpresa = new ContactoEmpresa("Pepe", "Gómez", direccionEmpresa, "TechCorp",
                "Gerente de TI", "Estados Unidos");
        contactoEmpresa.agregarTelefono("987654321");
        contactoEmpresa.agregarEmail(new Email("pepe@techcorp.com", "corporativo"));
        contactoEmpresa.agregarRedSocial(new RedSocial("LinkedIn", "pepe-gomez"));
        contactoEmpresa.agregarFoto(new Foto("foto3.jpg"));
        contactoEmpresa.agregarContactoAsociado(contactoPersona);
        contactoEmpresa.agregarContactoAsociado(contactoPersona2);

        // Añadir los contactos a la lista
        contactos.agregarUltimo(contactoPersona);
        contactos.agregarUltimo(contactoEmpresa);

        return contactos;
    }
}