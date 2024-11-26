package com.mycompany.contactadministrator.model;

import java.io.Serializable;
import com.mycompany.contactadministrator.util.OurArrayList;

public class Contacto implements Serializable {
    private String nombre;
    private static final long serialVersionUID = 5483261784L;
    private String apellido;
    private Direccion direccion;
    private OurArrayList<String> telefonos;
    private OurArrayList<Email> emails;
    private OurArrayList<RedSocial> redesSociales;
    private OurArrayList<Foto> fotos;
    private OurArrayList<Contacto> contactosAsociados; // Nueva lista para contactos asociados

    // Constructor
    public Contacto(String nombre, String apellido, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefonos = new OurArrayList<>(String.class);
        this.emails = new OurArrayList<>(Email.class);
        this.redesSociales = new OurArrayList<>(RedSocial.class);
        this.fotos = new OurArrayList<>(Foto.class);
        this.contactosAsociados = new OurArrayList<>(Contacto.class); // Inicializar la lista
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
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

    public void setContactosAsociados(OurArrayList<Contacto> contactosAsociados) {
        this.contactosAsociados = contactosAsociados;
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

    public void agregarContactoAsociado(Contacto contacto) {
        contactosAsociados.agregar(contacto);
    }

    public OurArrayList<Contacto> getContactosAsociados() {
        return contactosAsociados;
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
        for (Email email : emails) {
            sb.append(" - ").append(email).append("\n");
        }

        sb.append("Redes Sociales: \n");
        for (RedSocial redSocial : redesSociales) {
            sb.append(" - ").append(redSocial).append("\n");
        }

        sb.append("Fotos: \n");
        for (Foto foto : fotos) {
            sb.append(" - ").append(foto).append("\n");
        }

        sb.append("Contactos Asociados: \n");
        if (contactosAsociados.estaVacia() || contactosAsociados == null) { // Comprobar si la lista está vacía
            sb.append(" - Sin contactos asociados\n");
        } else {
            for (Contacto asociado : contactosAsociados) {
                sb.append(" - ").append(asociado.getNombre()).append(" ").append(asociado.getApellido()).append("\n");
            }
        }

        return sb.toString();
    }
}