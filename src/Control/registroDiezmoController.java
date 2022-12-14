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
public class registroDiezmoController implements ActionListener{
    
    private Parroquia p = null;
    private Fachada fachada = null;

    public registroDiezmoController(Parroquia parroquia, Fachada fachada) {
        super();
        this.p = parroquia;
        this.fachada = fachada;
        actionListener(this);
    }
    
    public void actionListener (ActionListener control){
        p.pagarButton.addActionListener(control);
        p.consultarButton.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            if (event.getActionCommand().contentEquals("Pagar")){
                int e=0;
                if (p.estadoTextField.getText().equals("Deudor")||p.estadoTextField.getText().equals("deudor")){
                    e=0;
                }else if (p.estadoTextField.getText().equals("Cumplido")||p.estadoTextField.getText().equals("cumplido")){
                    e=1;
                }
                fachada.actualizarFeligres(p.cedulaTextField.getText(), p.nombreTextField.getText(), p.direccionTextField.getText(), p.telefonoTextField.getText(), Integer.parseInt(p.etratoTextField.getText()), e);
                p.cuadroResultado.append("Feligres actualizado"+"\n");
            }else if (event.getActionCommand().contentEquals("Consultar")){
                Feligres f = fachada.consultarFeligres(p.consultaDCedulaTextField.getText());
                p.consultaDiezmoTextField.setText(f.getDiezmo()+"");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
