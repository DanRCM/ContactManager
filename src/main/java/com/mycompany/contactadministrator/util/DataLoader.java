package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.*;
import java.time.LocalDate;

public class DataLoader {

    public static OurCircularDoubleList<Contacto> cargarDatos() {
        OurCircularDoubleList<Contacto> contactos = new OurCircularDoubleList<>();

        // Crear contactos predeterminados
        Direccion direccionPersona = new Direccion("Ecuador","Calle Ficticia 123",
                "https://maps.google.com/?q=Calle+Ficticia+123");

        // Convertir la fecha de nacimiento de String a LocalDate
        LocalDate fechaNacimientoPersona1 = ContactoPersona.convertirStringADate("30/08/2005");
        ContactoPersona contactoPersona = new ContactoPersona("Juan", "Perez", direccionPersona, "Amigo", fechaNacimientoPersona1);
        contactoPersona.agregarTelefono("123456789");
        contactoPersona.agregarEmail(new Email("juan@ejemplo.com", "personal"));
        contactoPersona.agregarRedSocial(new RedSocial("Twitter", "@juanperez"));
        contactoPersona.agregarFoto(new Foto("foto1.jpg"));

        Direccion direccionPersona2 = new Direccion("Bolivia","Calle Ficticia 245",
                "https://maps.google.com/?q=Calle");

        // Convertir la fecha de nacimiento de String a LocalDate
        LocalDate fechaNacimientoPersona2 = ContactoPersona.convertirStringADate("10/05/2003");
        ContactoPersona contactoPersona2 = new ContactoPersona("Carlos", "Pereira", direccionPersona2, "Amigo", fechaNacimientoPersona2);
        contactoPersona2.agregarTelefono("0993827433");
        contactoPersona2.agregarEmail(new Email("carlos@ejemplo.com", "personal"));
        contactoPersona2.agregarRedSocial(new RedSocial("Twitter", "@carlosPereira"));
        contactoPersona2.agregarFoto(new Foto("foto2.jpg"));

        // Asociar contactos
        contactoPersona.agregarContactoAsociado(contactoPersona2);

        Direccion direccionEmpresa = new Direccion("Chile","Avenida Empresa 456",
                "https://maps.google.com/?q=Avenida+Empresa+456");

        ContactoEmpresa contactoEmpresa = new ContactoEmpresa("Pepe", "Gomez", direccionEmpresa, "TechCorp",
                "Gerente de TI");
        contactoEmpresa.agregarTelefono("987654321");
        contactoEmpresa.agregarEmail(new Email("pepe@techcorp.com", "corporativo"));
        contactoEmpresa.agregarRedSocial(new RedSocial("LinkedIn", "pepe-gomez"));
        contactoEmpresa.agregarFoto(new Foto("foto3.jpg"));
        contactoEmpresa.agregarContactoAsociado(contactoPersona);
        contactoEmpresa.agregarContactoAsociado(contactoPersona2);


        contactos.agregarUltimo(contactoPersona);
        contactos.agregarUltimo(contactoPersona2);
        contactos.agregarUltimo(contactoEmpresa);


        Direccion direccionPersona3 = new Direccion("Colombia", "Calle Real 567",
                "https://maps.google.com/?q=Calle+Real+567");

        LocalDate fechaNacimientoPersona3 = ContactoPersona.convertirStringADate("15/03/1998");
        ContactoPersona contactoPersona3 = new ContactoPersona("Mariana", "Lopez", direccionPersona3, "Amiga", fechaNacimientoPersona3);
        contactoPersona3.agregarTelefono("3209981234");
        contactoPersona3.agregarEmail(new Email("mariana@ejemplo.com", "personal"));
        contactoPersona3.agregarRedSocial(new RedSocial("Instagram", "@mariana_lopez"));
        contactoPersona3.agregarFoto(new Foto("foto4.jpg"));

        Direccion direccionPersona4 = new Direccion("Argentina", "Boulevard San Martin 987",
                "https://maps.google.com/?q=Boulevard+San+Martin+987");

        LocalDate fechaNacimientoPersona4 = ContactoPersona.convertirStringADate("22/11/1995");
        ContactoPersona contactoPersona4 = new ContactoPersona("Santiago", "Martinez", direccionPersona4, "Colega", fechaNacimientoPersona4);
        contactoPersona4.agregarTelefono("1156738890");
        contactoPersona4.agregarEmail(new Email("santiago@empresa.com", "corporativo"));
        contactoPersona4.agregarRedSocial(new RedSocial("LinkedIn", "santiago-martinez"));
        contactoPersona4.agregarFoto(new Foto("foto5.jpg"));

        contactoPersona3.agregarContactoAsociado(contactoPersona4);

        Direccion direccionEmpresa2 = new Direccion("Peru", "Avenida Sol 123",
                "https://maps.google.com/?q=Avenida+Sol+123");

        ContactoEmpresa contactoEmpresa2 = new ContactoEmpresa("Luis", "Hernandez", direccionEmpresa2, "Innovatech",
                "Director de Marketing");
        contactoEmpresa2.agregarTelefono("956789432");
        contactoEmpresa2.agregarEmail(new Email("luis@innovatech.com", "corporativo"));
        contactoEmpresa2.agregarRedSocial(new RedSocial("Twitter", "@luis_marketing"));
        contactoEmpresa2.agregarFoto(new Foto("foto6.jpg"));
        contactoEmpresa2.agregarContactoAsociado(contactoPersona3);
        contactoEmpresa2.agregarContactoAsociado(contactoPersona4);


        contactos.agregarUltimo(contactoPersona3);
        contactos.agregarUltimo(contactoPersona4);
        contactos.agregarUltimo(contactoEmpresa2);

        Direccion direccionPersona5 = new Direccion("Chile", "Paseo de la Costa 234",
                "https://maps.google.com/?q=Paseo+de+la+Costa+234");
        LocalDate fechaNacimientoPersona5 = ContactoPersona.convertirStringADate("08/07/1990");
        ContactoPersona contactoPersona5 = new ContactoPersona("Elena", "Rodriguez", direccionPersona5, "Compañera", fechaNacimientoPersona5);
        contactoPersona5.agregarTelefono("5512345678");
        contactoPersona5.agregarEmail(new Email("elena@correo.com", "personal"));
        contactoPersona5.agregarRedSocial(new RedSocial("Facebook", "elena.rodriguez"));
        contactoPersona5.agregarFoto(new Foto("foto7.jpg"));

        Direccion direccionPersona6 = new Direccion("Mexico", "Boulevard Cultura 456",
                "https://maps.google.com/?q=Boulevard+Cultura+456");
        LocalDate fechaNacimientoPersona6 = ContactoPersona.convertirStringADate("30/09/1985");
        ContactoPersona contactoPersona6 = new ContactoPersona("Carlos", "Garcia", direccionPersona6, "Mentor", fechaNacimientoPersona6);
        contactoPersona6.agregarTelefono("5587654321");
        contactoPersona6.agregarEmail(new Email("carlos@empresa.net", "corporativo"));
        contactoPersona6.agregarRedSocial(new RedSocial("Twitter", "@carlos_garcia"));
        contactoPersona6.agregarFoto(new Foto("foto8.jpg"));

        Direccion direccionEmpresa3 = new Direccion("Ecuador", "Calle Innovacion 789",
                "https://maps.google.com/?q=Calle+Innovacion+789");
        ContactoEmpresa contactoEmpresa3 = new ContactoEmpresa("Ana", "Fernandez", direccionEmpresa3, "TechSolutions",
                "Gerente de Proyectos");
        contactoEmpresa3.agregarTelefono("593987654321");
        contactoEmpresa3.agregarEmail(new Email("ana@techsolutions.com", "corporativo"));
        contactoEmpresa3.agregarRedSocial(new RedSocial("LinkedIn", "ana-fernandez"));
        contactoEmpresa3.agregarFoto(new Foto("foto9.jpg"));


        contactoPersona5.agregarContactoAsociado(contactoPersona6);
        contactoEmpresa3.agregarContactoAsociado(contactoPersona5);
        contactoEmpresa3.agregarContactoAsociado(contactoPersona6);

        contactos.agregarUltimo(contactoPersona5);
        contactos.agregarUltimo(contactoPersona6);
        contactos.agregarUltimo(contactoEmpresa3);

        return contactos;
    }
}