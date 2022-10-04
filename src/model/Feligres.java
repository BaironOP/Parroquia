/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Usuario
 */
public class Feligres {
    private String cedula;
    private String nombre;
    private String direccion;
    private String telefono;
    private int estrato;
    private Estado estado;
    private int diezmo;

    public Feligres() {
    }

    public Feligres(String cedula, String nombre, String direccion, String telefono, int estrato) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estrato = estrato;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getDiezmo() {
        if (estrato==1){
            diezmo = 250000;
        }else if (estrato>=2 && estrato<=3){
            diezmo = 500000;
        }else if (estrato>3){
            diezmo = 1000000;
        }
        return diezmo;
    }
    
}
