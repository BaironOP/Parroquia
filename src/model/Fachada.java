/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Fachada {
    
    private ArrayList <Feligres> feligreses = new ArrayList<>();
    private int totalDiezmo;

    public Fachada() {
        totalDiezmo = 0;
    }
    
    public void añadirFeligres(String cedula, String nombre, String direccion, String telefono, int estrato){
        Feligres n = new Feligres(cedula, nombre, direccion, telefono, estrato);
        feligreses.add(n);
    }
    
    public void eliminarFeligres(String cedula){
        for (int i=0; i<=feligreses.size(); i++){
            if (feligreses.get(i).getCedula().equals(cedula)){
                feligreses.remove(i);
                break;
            }
        }
    }
    
    public void actualizarFeligres(String cedula, String nombre, String direccion, String telefono, int estrato){
        for (int i=0; i<=feligreses.size(); i++){
            if (feligreses.get(i).getCedula().equals(cedula)){
                feligreses.get(i).setDireccion(direccion);
                feligreses.get(i).setNombre(nombre);
                feligreses.get(i).setTelefono(telefono);
                feligreses.get(i).setEstrato(estrato);
                break;
            }
        }
    }
    
    public String[] consultarFeligres (String cedula){
        String[] caracteristicas = new String[7];
        for (int i=0; i<=feligreses.size(); i++){
            if (feligreses.get(i).getCedula().equals(cedula)){
                caracteristicas[0] = feligreses.get(i).getCedula();
                caracteristicas[1] = feligreses.get(i).getNombre();
                caracteristicas[2] = feligreses.get(i).getDireccion();
                caracteristicas[3] = feligreses.get(i).getTelefono();
                caracteristicas[4] = (feligreses.get(i).getEstrato()+"");
                caracteristicas[5] = (feligreses.get(i).getEstado()+"");
                caracteristicas[6] = feligreses.get(i).getDiezmo()+"";
                break;
            }
        }
        return caracteristicas;
    }
    
    public void pagarDiezmo(String cedula){
        for (int i=0; i<=feligreses.size(); i++){
            if (feligreses.get(i).getCedula().equals(cedula)){
                if (feligreses.get(i).getCedula().equals(cedula)){
                    feligreses.get(i).setEstado(Estado.Cumplido);
                    totalDiezmo+=feligreses.get(i).getDiezmo();
                    break;
                }
            }
        }
    }

    public int getTotalDiezmo() {
        return totalDiezmo;
    }
    
    
}
