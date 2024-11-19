package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */

public class ContactoPersona extends Contacto {
    private String tipoRelacion;
    private String fechaCumpleaños;

    public ContactoPersona(String nombre, String apellido, Direccion direccion, String tipoRelacion,String fechaCumpleaños) {
        super(nombre, apellido, direccion);
        this.tipoRelacion = tipoRelacion;
        this.fechaCumpleaños = fechaCumpleaños;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }
    
    public String getFechaCumpleaños() {
        return fechaCumpleaños;
    }
    public void setFechaCumpleaños(String fechaCumpleaños) {
        this.fechaCumpleaños = fechaCumpleaños;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); // Llama al método toString() de la clase padre
        sb.append("Tipo de relación: ").append(tipoRelacion).append("\n");
        return sb.toString();
    }
}
