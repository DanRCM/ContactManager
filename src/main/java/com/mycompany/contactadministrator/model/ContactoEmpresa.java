package com.mycompany.contactadministrator.model;

/**
 *
 * @author daniel24
 */

public class ContactoEmpresa extends Contacto{
    private static final long serialVersionUID = -1925388865L;
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
    // Method para mostrar detalles del contacto de empresa
    @Override
    public String toString() {
        String sb = super.toString() + // Llama al método toString() de la clase padre
                "Nombre de la empresa: " + nombreEmpresa + "\n" +
                "Cargo: " + cargo + "\n";
        return sb;
    }
}
