package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */

public class ContactoPersona extends Contacto {
    private static final long serialVersionUID = -5148453023L;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); // Llama al método toString() de la clase padre
        sb.append("Tipo de relación: ").append(tipoRelacion).append("\n");
        return sb.toString();
    }
}
