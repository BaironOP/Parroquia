/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Estado;
import model.Fachada;
import model.Feligres;
import vista.Parroquia;

/**
 *
 * @author Usuario
 */
public class annadirFeligresController implements ActionListener{
    
    private Parroquia p = null;
    private Feligres f = null;
    private Fachada fachada = null;

    public annadirFeligresController(Parroquia parroquia, Feligres feligres, Fachada fachada) {
        super();
        this.f = feligres;
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
            if (event.getActionCommand().contentEquals("Guardar")){
                f.setCedula(this.p.cedulaTextField.getText());
                f.setDireccion(this.p.direccionTextField.getText());
                f.setEstrato(Integer.parseInt(this.p.etratoTextField.getText()));
                f.setNombre(this.p.nombreTextField.getText());
                f.setTelefono(this.p.telefonoTextField.getText());
                if (this.p.estadoTextField.getText().equals("Deudor")||this.p.estadoTextField.getText().equals("deudor")){
                    f.setEstado(Estado.Deudor);
                }else if (this.p.estadoTextField.getText().equals("Cumplido")||this.p.estadoTextField.getText().equals("cumplido")){
                    f.setEstado(Estado.Cumplido);
                }
                fachada.añadirFeligres(f);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
