package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */

public class ContactoEmpresa extends Contacto{
    private String nombreEmpresa;
    private String cargo;
    private String paisResidencia;

    // Constructor
    public ContactoEmpresa(String nombre, String apellido, Direccion direccion, String nombreEmpresa, String cargo,String paisResidencia) {
        super(nombre, apellido, direccion);
        this.nombreEmpresa = nombreEmpresa;
        this.cargo = cargo;
        this.paisResidencia = paisResidencia;
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

     public String getPaisResidencia() {
        return paisResidencia;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }
    // Método para mostrar detalles del contacto de empresa
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()); // Llama al método toString() de la clase padre
        sb.append("Nombre de la empresa: ").append(nombreEmpresa).append("\n");
        sb.append("Cargo: ").append(cargo).append("\n");
        return sb.toString();
    }
}
