package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.*;

import java.util.Scanner;

public class ContactFactory {

    private Scanner input;

    public ContactFactory() {
        input = new Scanner(System.in);
    }

    public ContactoPersona crearContactoPersona() {
        System.out.println("Ingresa el nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingresa el apellido: ");
        String apellido = input.nextLine();
        System.out.println("Ingresa la dirección: ");
        String direccion = input.nextLine();
        System.out.println("Ingresa el link de la dirección: ");
        String direccionLink = input.nextLine();
        Direccion direccionFinal = new Direccion(direccion, direccionLink);
        System.out.println("Ingresa la relación con la persona: ");
        String relacion = input.nextLine();
        System.out.println("Ingresa su fecha de nacimiento: ");
        String fechaNacimiento = input.nextLine();

        ContactoPersona contacto = new ContactoPersona(nombre, apellido, direccionFinal, relacion, fechaNacimiento);
        agregarDetallesContacto(contacto);
        return contacto;
    }

    public ContactoEmpresa crearContactoEmpresa() {
        System.out.println("Ingresa el nombre: ");
        String nombre = input.nextLine();
        System.out.println("Ingresa el apellido: ");
        String apellido = input.nextLine();
        System.out.println("Ingresa la dirección: ");
        String direccion = input.nextLine();
        System.out.println("Ingresa el link de la dirección: ");
        String linkDireccion = input.nextLine();
        Direccion direccionFinal = new Direccion(direccion, linkDireccion);
        System.out.println("Ingresa el nombre de la empresa: ");
        String nombreEmpresa = input.nextLine();
        System.out.println("Ingresa el cargo en la empresa: ");
        String cargo = input.nextLine();
        System.out.println("Ingresa el país de la empresa: ");
        String pais = input.nextLine();

        ContactoEmpresa contacto = new ContactoEmpresa(nombre, apellido, direccionFinal, nombreEmpresa, cargo, pais);
        agregarDetallesContacto(contacto);
        return contacto;
    }

    private void agregarDetallesContacto(Contacto contacto) {
        System.out.println("Ingresa el teléfono: ");
        String t = input.nextLine();
        contacto.agregarTelefono(t);

        System.out.println("Ingresa el email: ");
        String e1 = input.nextLine();
        System.out.println("Ingresa el tipo de email: ");
        String e2 = input.nextLine();
        contacto.agregarEmail(new Email(e1, e2));

        System.out.println("Ingresa el usuario de una red social: ");
        String s1 = input.nextLine();
        System.out.println("Ingresa el nombre de la red social: ");
        String s2 = input.nextLine();
        contacto.agregarRedSocial(new RedSocial(s2, s1));

        System.out.println("Ingresa la dirección de una foto: ");
        String f = input.nextLine();
        contacto.agregarFoto(new Foto(f));
    }
}