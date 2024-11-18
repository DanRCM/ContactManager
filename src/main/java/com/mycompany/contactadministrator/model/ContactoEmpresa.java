package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */

public class ContactoEmpresa extends Contacto{
    private String nombreEmpresa;
    private String cargo;

    // Constructor
    public ContactoEmpresa(String nombre, String apellido, Direccion direccion, String nombreEmpresa, String cargo) {
        super(nombre, apellido, direccion);
        this.nombreEmpresa = nombreEmpresa;
        this.cargo = cargo;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Método para mostrar detalles del contacto de empresa
    @Override
<<<<<<< HEAD
    public void mostrarContacto() {
        super.mostrarContacto();  // Llamamos al método de la clase padre
        System.out.println("Nombre de la empresa: " + nombreEmpresa);
        System.out.println("Cargo: " + cargo);
=======
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); // Llama al método toString() de la clase padre
        sb.append("Nombre de la empresa: ").append(nombreEmpresa).append("\n");
        sb.append("Cargo: ").append(cargo).append("\n");
        return sb.toString();
>>>>>>> Eimmy
    }
}
