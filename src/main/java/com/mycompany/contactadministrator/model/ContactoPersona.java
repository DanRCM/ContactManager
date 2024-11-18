package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */

public class ContactoPersona extends Contacto {
    private String tipoRelacion;

    public ContactoPersona(String nombre, String apellido, Direccion direccion, String tipoRelacion) {
        super(nombre, apellido, direccion);
        this.tipoRelacion = tipoRelacion;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }

    @Override
<<<<<<< HEAD
    public void mostrarContacto() {
        super.mostrarContacto();
        System.out.println("Tipo de relación: " + tipoRelacion);
=======
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); // Llama al método toString() de la clase padre
        sb.append("Tipo de relación: ").append(tipoRelacion).append("\n");
        return sb.toString();
>>>>>>> Eimmy
    }
}
