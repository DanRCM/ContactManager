package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */

public class ContactoPersona extends Contacto {
    private static final long serialVersionUID = -5148453023L;
    private String tipoRelacion;
    private String fechaNacimiento;

    public ContactoPersona(String nombre, String apellido, Direccion direccion, String tipoRelacion,String fechaNacimiento) {
        super(nombre, apellido, direccion);
        this.tipoRelacion = tipoRelacion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoRelacion() {
        return tipoRelacion;
    }

    public void setTipoRelacion(String tipoRelacion) {
        this.tipoRelacion = tipoRelacion;
    }
    
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tipo de relación: ").append(tipoRelacion).append("\n");
        return sb.toString();
    }
}
