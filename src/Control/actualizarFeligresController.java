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
public class actualizarFeligresController implements ActionListener {
    
    private Parroquia p = null;
    private Fachada fachada = null;

    public actualizarFeligresController(Parroquia parroquia, Fachada fachada) {
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
            int e = -1;
            if (event.getActionCommand().contentEquals("Actualizar")){
                if (p.estadoTextField.equals("Deudor")||p.estadoTextField.equals("deudor")){
                    e=0;
                }else if (p.estadoTextField.equals("Cumplido")||p.estadoTextField.equals("cumplido")){
                    e=1;
                }
                fachada.actualizarFeligres(p.cedulaTextField.getText(), p.nombreTextField.getText(), p.direccionTextField.getText(), p.telefonoTextField.getText(), Integer.parseInt(p.etratoTextField.getText()), e);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
