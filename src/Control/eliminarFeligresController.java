/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Fachada;
import vista.Parroquia;

/**
 *
 * @author Usuario
 */
public class eliminarFeligresController implements ActionListener{
    
    private Parroquia p = null;
    private Fachada fachada = null;

    public eliminarFeligresController(Parroquia parroquia, Fachada fachada) {
        super();
        this.p = parroquia;
        this.fachada = fachada;
        actionListener(this);
    }
    
    public void actionListener (ActionListener control){
        p.guardarButton.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            if (event.getActionCommand().contentEquals("Eliminar")){
                fachada.eliminarFeligres(p.cedulaTextField.getText());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
