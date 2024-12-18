package com.mycompany.contactadministrator.model;

import java.io.Serializable;
import java.util.Scanner;

import com.mycompany.contactadministrator.util.OurArrayList;
import com.mycompany.contactadministrator.util.OurCircularDoubleList;

public class    Contacto implements Serializable {
    private String nombre;
    private static final long serialVersionUID = 5483261784L;
    private String apellido;
    private Direccion direccion;
    private OurArrayList<String> telefonos;
    private OurArrayList<Email> emails;
    private OurArrayList<RedSocial> redesSociales;
    private OurArrayList<Foto> fotos;
    private OurCircularDoubleList<Contacto> contactosAsociados; // Nueva lista para contactos asociados

    // Constructor
    public Contacto(String nombre, String apellido, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefonos = new OurArrayList<>(String.class);
        this.emails = new OurArrayList<>(Email.class);
        this.redesSociales = new OurArrayList<>(RedSocial.class);
        this.fotos = new OurArrayList<>(Foto.class);
        this.contactosAsociados = new OurCircularDoubleList<>(); // Inicializar la lista
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        while (nombre == null || nombre.isEmpty()) {
            System.out.println("Se necesita un nombre: ");
            Scanner scanner = new Scanner(System.in);
            nombre = scanner.nextLine();
        }
        this.nombre = nombre;
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

    public void setTelefonos(OurArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    public OurArrayList<Email> getEmails() {
        return emails;
    }

    public void setEmails(OurArrayList<Email> emails) {
        this.emails = emails;
    }

    public OurArrayList<RedSocial> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(OurArrayList<RedSocial> redesSociales) {
        this.redesSociales = redesSociales;
    }

    public OurArrayList<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(OurArrayList<Foto> fotos) {
        this.fotos = fotos;
    }

    public OurCircularDoubleList<Contacto> getContactosAsociados() {
        return contactosAsociados;
    }

    public void setContactosAsociados(OurCircularDoubleList<Contacto> contactosAsociados) {
        this.contactosAsociados = contactosAsociados;
    }

    // Métodos para agregar información
    public void agregarTelefono(String telefono) {
        Scanner scanner = new Scanner(System.in);
        while(!telefono.matches("[0-9]+")){
            System.out.println("Por favor ingrese un numero valido");
            telefono = scanner.nextLine();
        }
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

    public void agregarContactoAsociado(Contacto contacto) {
        contactosAsociados.agregarUltimo(contacto); // Agregar al final de la lista circular
    }

    // Método para mostrar detalles del contacto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Apellido: ").append(apellido).append("\n");
        sb.append("Dirección: ").append(direccion).append("\n");

        sb.append("Teléfonos: \n");
        for (String telefono : telefonos) {
            sb.append(" - ").append(telefono).append("\n");
        }

        sb.append("Emails: \n");
        if(emails.estaVacia()){
            sb.append("Sin emails disponibles \n");
        }else{
            for (Email email : emails) {
                sb.append(" - ").append(email).append("\n");
            }
        }

        sb.append("Redes Sociales: \n");
        for (RedSocial redSocial : redesSociales) {
            sb.append(" - ").append(redSocial).append("\n");
        }

        sb.append("Fotos: \n");
        if(fotos.estaVacia()){
            sb.append("Sin fotos disponibles\n");
        }else{
            for (Foto foto : fotos) {
                sb.append(" - ").append(foto).append("\n");
            }
        }
        sb.append("Contactos Asociados: \n");

        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactosAsociados.iterator();

        if(iterator.hasNext()){
            sb.append("-").append(iterator.peek().nombre).append(" ").append(iterator.peek().apellido).append("\n");
            iterator.next();
        }else{
            sb.append("- Sin Contactos Asociados\n");
        }

        return sb.toString();
    }
}