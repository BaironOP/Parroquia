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
    private ArrayList<Feligres> feligreses;

    public Fachada() {
        feligreses = new ArrayList<>();
    }
    
    public void añadirFeligres(Feligres f){
        feligreses.add(f);
    }
    
    public void eliminarFeligres(String cedula){
        for (int i = 0; i<feligreses.size(); i++){
            if (feligreses.get(i).getCedula().equals(cedula)){
                feligreses.remove(i);
                break;
            }
        }
    }
    
    public void actualizarFeligres(String cedula, String nombre, String direccion, String telefono, int estrato, int estado){
        for (int i = 0; i<feligreses.size(); i++){
            if (feligreses.get(i).getCedula().equals(cedula)){
                Feligres n = new Feligres(cedula, nombre, direccion, telefono, estrato);
                if (estado==1){
                    n.setEstado(Estado.Deudor);
                }else if (estado==0){
                    n.setEstado(Estado.Cumplido);
                }
                feligreses.remove(i);
                feligreses.add(i, n);
                break;
            }
        }
    }
    
    public Feligres consultarFeligres(String cedula){
        Feligres r = null;
        for (int i = 0; i<feligreses.size(); i++){
            if (feligreses.get(i).getCedula().equals(cedula)){
                r = feligreses.get(i);
                break;
            }
        }
        return r;
    }
}
