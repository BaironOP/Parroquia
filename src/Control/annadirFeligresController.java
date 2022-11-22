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
    private Fachada fachada = null;

    public annadirFeligresController(Parroquia parroquia, Fachada fachada) {
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
            Feligres f = new Feligres();
            if (event.getActionCommand().contentEquals("Guardar")){
                f.setCedula(p.cedulaTextField.getText());
                this.p.cedulaTextField.setText("");
                f.setDireccion(p.direccionTextField.getText());
                this.p.direccionTextField.setText("");
                f.setEstrato(Integer.parseInt(p.etratoTextField.getText()));
                this.p.etratoTextField.setText("");
                f.setNombre(p.nombreTextField.getText());
                this.p.nombreTextField.setText("");
                f.setTelefono(p.telefonoTextField.getText());
                this.p.telefonoTextField.setText("");
                if (p.estadoTextField.getText().equals("Deudor")||p.estadoTextField.getText().equals("deudor")){
                    f.setEstado(Estado.Deudor);
                }else if (p.estadoTextField.getText().equals("Cumplido")||p.estadoTextField.getText().equals("cumplido")){
                    f.setEstado(Estado.Cumplido);
                }
                this.p.estadoTextField.setText("");
                fachada.añadirFeligres(f);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
