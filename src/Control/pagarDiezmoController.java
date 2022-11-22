/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import vista.Parroquia;

/**
 *
 * @author Usuario
 */
public class pagarDiezmoController implements ActionListener{
    private Parroquia p = null;
    private Fachada fachada = null;

    public pagarDiezmoController(Parroquia parroquia, Fachada fachada) {
        super();
        this.p = parroquia;
        this.fachada = fachada;
        actionListener(this);
    }
    
    public void actionListener (ActionListener control){
        p.pagarButton.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            fachada.pagar(p.consultaDCedulaTextField.getText());
            p.cuadroResultado.append("Pago realizado"+"\n");
            p.consultaDCedulaTextField.setText("");
            p.consultaDiezmoTextField.setText("");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
