package com.mycompany.contactadministrator.model;

import java.text.ParseException;
import java.util.Date;

import com.mycompany.contactadministrator.util.DateParser;

/**
 *
 * @author daniel24
 */

public class ContactoPersona extends Contacto {
    private static final long serialVersionUID = -5148453023L;
    private String tipoRelacion;
    private Date fechaNacimiento;



    /**
     * @param nombre
     * @param apellido String; DEBE SER EN FORMATO AÑO-MES-DIA (yyyy-MM-dd)
     * @param direccion
     * @param tipoRelacion
     * @param fechaNacimiento
     */
    public ContactoPersona(String nombre, String apellido, Direccion direccion, String tipoRelacion,String fechaNacimiento) {
        super(nombre, apellido, direccion);
        this.tipoRelacion = tipoRelacion;
        try {
            this.fechaNacimiento = DateParser.stringToDate(fechaNacimiento);
        } catch (ParseException e) {
            System.out.println("Error al ingresar la fecha.");
            try {
                this.fechaNacimiento = DateParser.stringToDate("1970-01-01");
            } catch (ParseException e1) {
                // nunca vamos a llegar aca
                e1.printStackTrace();
            }
        }
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
    /**
     * @param fechaNacimiento String; DEBE SER EN FORMATO AÑO-MES-DIA (yyyy-MM-dd)
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        try {
            this.fechaNacimiento = DateParser.stringToDate(fechaNacimiento);
        } catch (ParseException e) {
            System.out.println("Error al ingresar la fecha");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        
        sb.append("Fecha de nacimiento:").append("\n").append(DateParser.dateToString(fechaNacimiento,"yyyy-MM-dd")).append("\n");
        
        sb.append("Tipo de relación: ").append(tipoRelacion).append("\n");
        return sb.toString();
    }
}
