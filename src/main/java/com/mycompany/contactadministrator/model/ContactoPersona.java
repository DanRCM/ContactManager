package com.mycompany.contactadministrator.model;

import java.util.Date;

/**
 *
 * @author daniel24
 */

public class ContactoPersona extends Contacto {
    private static final long serialVersionUID = -5148453023L;
    private String tipoRelacion;
    private Date fechaNacimiento;

    public ContactoPersona(String nombre, String apellido, Direccion direccion, String tipoRelacion,Date fechaNacimiento) {
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
    
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(Date fechaNacimiento) {
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
