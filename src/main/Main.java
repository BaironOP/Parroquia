/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Control.*;
import model.Fachada;
import vista.Parroquia;

/**
 *
 * @author Usuario
 */
public class Main {
    
    public static void main (String[] args){
        
        Parroquia parroquia = new Parroquia();
        Fachada fachada = new Fachada();
        registroFeligresController regF = new registroFeligresController(parroquia, fachada);
        registroDiezmoController regD = new registroDiezmoController (parroquia, fachada);
        parroquia.setVisible(true);
        
    }
    
}
