package com.mycompany.contactadministrator.model;

import com.mycompany.contactadministrator.util.OurArrayList;

public class Contacto {
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private OurArrayList<String> telefonos;
    private OurArrayList<Email> emails;
    private OurArrayList<RedSocial> redesSociales;
    private OurArrayList<Foto> fotos;

    // Constructor
    public Contacto(String nombre, String apellido, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefonos = new OurArrayList<>(String.class);
        this.emails = new OurArrayList<>(Email.class);
        this.redesSociales = new OurArrayList<>(RedSocial.class);
        this.fotos = new OurArrayList<>(Foto.class);
    }

    // Métodos para agregar información
    public void agregarTelefono(String telefono) {
        telefonos.agregar(telefono);
    }

    public void agregarEmail(Email email) {
        emails.agregar(email);
    }

    public void agregarRedSocial(RedSocial redSocial) {
        redesSociales.agregar(redSocial);
    }

    public void agregarFoto(Foto foto) {
        fotos.agregar(foto);
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public OurArrayList<String> getTelefonos() {
        return telefonos;
    }

    public OurArrayList<Email> getEmails() {
        return emails;
    }

    public OurArrayList<RedSocial> getRedesSociales() {
        return redesSociales;
    }

    public OurArrayList<Foto> getFotos() {
        return fotos;
    }

    // Método para mostrar detalles del contacto
    public void mostrarContacto() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dirección: " + direccion);
        System.out.println("Teléfonos: ");
        for (String telefono : telefonos) {
            System.out.println(" - " + telefono);
        }
        System.out.println("Emails: ");
        for (Email email : emails) {
            System.out.println(" - " + email);
        }
        System.out.println("Redes Sociales: ");
        for (RedSocial redSocial : redesSociales) {
            System.out.println(" - " + redSocial);
        }
        System.out.println("Fotos: ");
        for (Foto foto : fotos) {
            System.out.println(" - " + foto);
        }
    }
}
