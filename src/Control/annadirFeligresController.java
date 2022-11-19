/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Feligres;
import vista.Parroquia;

/**
 *
 * @author Usuario
 */
public class annadirFeligresController implements ActionListener{
    
    private Parroquia p = null;
    private Feligres f = null;

    public annadirFeligresController(Parroquia parroquia, Feligres feligres) {
        super();
        this.f = feligres;
        this.p = parroquia;
        actionListener(this);
    }
    
    public void actionListener (ActionListener control){
        p.guardarButton.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            if (event.getActionCommand().contentEquals("Guardar")){
                f.setCedula(this.p.cedulaTextField.getText());
                f.setDireccion(this.p.direccionTextField.getText());
                f.setEstrato(Integer.parseInt(this.p.etratoTextField.getText()));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
