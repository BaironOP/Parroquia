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
public class buscarFeligresController implements ActionListener{
    private Parroquia p = null;
    private Fachada fachada = null;

    public buscarFeligresController(Parroquia parroquia, Fachada fachada) {
        super();
        this.p = parroquia;
        this.fachada = fachada;
        actionListener(this);
    }
    
    public void actionListener (ActionListener control){
        p.buscarButton.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            Feligres f = fachada.consultarFeligres(p.cedulaTextField.getText());
            p.cuadroResultado.append("Cedula: "+f.getCedula()+"\n");
            p.cuadroResultado.append("Nombre: "+f.getNombre()+"\n");
            p.cuadroResultado.append("Direccion: "+f.getDireccion()+"\n");
            p.cuadroResultado.append("Telefono: "+f.getTelefono()+"\n");
            p.cuadroResultado.append("Estrato: "+f.getEstrato()+"\n");
            p.cuadroResultado.append("Estado: "+f.getEstado()+"\n");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
