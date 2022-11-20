/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Fachada;
import model.Feligres;
import vista.Parroquia;

/**
 *
 * @author Usuario
 */
public class consultarFeligresController implements ActionListener{
    
    private Parroquia p = null;
    private Fachada fachada = null;

    public consultarFeligresController(Parroquia parroquia, Fachada fachada) {
        super();
        this.p = parroquia;
        this.fachada = fachada;
        actionListener(this);
    }
    
    public void actionListener (ActionListener control){
        p.actualizarButton.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            Feligres f = fachada.consultarFeligres(p.consultaDCedulaTextField.getText());
            p.consultaDiezmoTextField.setText(f.getDiezmo()+"");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
