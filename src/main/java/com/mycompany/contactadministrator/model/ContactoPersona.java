package com.mycompany.contactadministrator.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ContactoPersona extends Contacto{
    private static final long serialVersionUID = -5148453023L;
    private String tipoRelacion;
    private LocalDate fechaNacimiento; // Cambiar a LocalDate

    public ContactoPersona(String nombre, String apellido, Direccion direccion, String tipoRelacion, LocalDate fechaNacimiento) {
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Tipo de relación: ").append(tipoRelacion).append("\n");
        sb.append("Fecha de Nacimiento: ").append(fechaNacimiento).append("\n");
        return sb.toString();
    }

    // Método para convertir String a LocalDate
    public static LocalDate convertirStringADate(String fechaStr) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de fecha
            return LocalDate.parse(fechaStr, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha inválido: " + e.getMessage());
            return null; // O manejar el error de otra manera
        }
    }
}