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
public class registroFeligresController implements ActionListener{
    private Parroquia p = null;
    private Fachada fachada = null;

    public registroFeligresController(Parroquia parroquia, Fachada fachada) {
        super();
        this.p = parroquia;
        this.fachada = fachada;
        actionListener(this);
    }
    
    public void actionListener (ActionListener control){
        p.actualizarButton.addActionListener(control);
        p.guardarButton.addActionListener(control);
        p.eliminarButton.addActionListener(control);
        p.buscarButton.addActionListener(control);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try{
            int e = -1;
            if (event.getActionCommand().contentEquals("Actualizar")){
                if (p.estadoTextField.getText().equals("Deudor")||p.estadoTextField.getText().equals("deudor")){
                    e=0;
                }else if (p.estadoTextField.getText().equals("Cumplido")||p.estadoTextField.getText().equals("cumplido")){
                    e=1;
                }
                fachada.actualizarFeligres(p.cedulaTextField.getText(), p.nombreTextField.getText(), p.direccionTextField.getText(), p.telefonoTextField.getText(), Integer.parseInt(p.etratoTextField.getText()), e);
                p.cuadroResultado.append("Feligres actualizado"+"\n");
            }else if (event.getActionCommand().contentEquals("Guardar")){
                Feligres f = new Feligres();
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
                this.p.cuadroResultado.append("Feligres añadido"+"\n");
            }else if (event.getActionCommand().contentEquals("Eliminar")){
                fachada.eliminarFeligres(p.cedulaTextField.getText());
            }else if (event.getActionCommand().contentEquals("Buscar")){
                Feligres f = fachada.consultarFeligres(p.cedulaTextField.getText());
                p.cuadroResultado.append("Cedula: "+f.getCedula()+"\n");
                p.cuadroResultado.append("Nombre: "+f.getNombre()+"\n");
                p.cuadroResultado.append("Direccion: "+f.getDireccion()+"\n");
                p.cuadroResultado.append("Telefono: "+f.getTelefono()+"\n");
                p.cuadroResultado.append("Estrato: "+f.getEstrato()+"\n");
                p.cuadroResultado.append("Estado: "+f.getEstado()+"\n");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
