/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import modelo.Propietario;
import vista.VistaPropietario;



/**
 *
 * @author UNIVALLE
 */
public class ControlPropietarioGui implements ActionListener{

    private VistaPropietario vistaProp;
    private Propietario unPropietario;    
    private List<Propietario> listaPropietarios= new ArrayList<>();
    
    public ControlPropietarioGui(List<Propietario> listaPropitars){
        
        this.vistaProp= new VistaPropietario();
        this.vistaProp.setVisible(true);
        
        this.vistaProp.jbtn_aceptar.addActionListener(this);
        this.vistaProp.jbtn_consultar.addActionListener(this);
        this.vistaProp.jbtn_eliminar.addActionListener(this);
        this.vistaProp.jbtn_modificar.addActionListener(this);
        
        this.listaPropietarios= listaPropitars;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()== this.vistaProp.jbtn_aceptar){
            this.unPropietario= new Propietario();
            
            try{
                this.unPropietario.setDni(Integer.parseInt(this.vistaProp.jtf_dni.getText()));
            }catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(this.vistaProp,"Ingrese Valores Numéricos\nPara el DNI");
            }
            
            this.unPropietario.setNombres(this.vistaProp.jtf_nombres.getText());
            this.unPropietario.setApellidos(this.vistaProp.jtf_apellidos.getText());
            this.unPropietario.setDireccion(this.vistaProp.jtf_direccion.getText());
            
            this.listaPropietarios.add(unPropietario);
            
            JOptionPane.showMessageDialog(this.vistaProp,"El propietario ha sido ingresado\nExitosamente");
                  
            limpiarCampos();
        }
        
        if(e.getSource() == this.vistaProp.jbtn_consultar){
            int band=0;
            Propietario auxPropietario= new Propietario();
            
            for(int i=0; i<this.listaPropietarios.size();i++){
                auxPropietario=this.listaPropietarios.get(i);
                
                if(auxPropietario.getDni() == Integer.parseInt(this.vistaProp.jtf_dni.getText())){
                    band=1;
                    this.vistaProp.jtf_nombres.setText(auxPropietario.getNombres());
                    this.vistaProp.jtf_apellidos.setText(auxPropietario.getApellidos());
                    this.vistaProp.jtf_direccion.setText(auxPropietario.getDireccion());                    
                }
            }
            
            if(band==0){
                JOptionPane.showMessageDialog(this.vistaProp,"El propietario no existe");
            }
            
        }
        
        if(e.getSource() == this.vistaProp.jbtn_eliminar){
            int band=0;
            Propietario auxPropietario= new Propietario();
            
            for(int i=0; i<this.listaPropietarios.size();i++){
                auxPropietario=this.listaPropietarios.get(i);
                
                if(auxPropietario.getDni() == Integer.parseInt(this.vistaProp.jtf_dni.getText())){
                    band=1;
                    this.listaPropietarios.remove(i);
                    JOptionPane.showMessageDialog(this.vistaProp,"El propietario ha sido borrado\nde la lista");
                    limpiarCampos();
                }
            }
            
            if(band==0){
                JOptionPane.showMessageDialog(this.vistaProp,"El propietario no existe");
            }
        }
        
        if(e.getSource() == this.vistaProp.jbtn_modificar){
            int band=0;
            Propietario auxPropietario= new Propietario();
            
            for(int i=0; i<this.listaPropietarios.size();i++){
                auxPropietario=this.listaPropietarios.get(i);
                
                if(auxPropietario.getDni() == Integer.parseInt(this.vistaProp.jtf_dni.getText())){
                    band=1;
                    
                    this.listaPropietarios.get(i).setNombres(this.vistaProp.jtf_nombres.getText());
                    this.listaPropietarios.get(i).setApellidos(this.vistaProp.jtf_apellidos.getText());
                    this.listaPropietarios.get(i).setDireccion(this.vistaProp.jtf_direccion.getText());
                    
                    JOptionPane.showMessageDialog(this.vistaProp,"El propietario ha sido Actualizado");
                }
            }
            
            if(band==0){
                JOptionPane.showMessageDialog(this.vistaProp,"El propietario no existe");
            }
            
        }
        
    }
    
    public void limpiarCampos(){        
            this.vistaProp.jtf_dni.setText("");
            this.vistaProp.jtf_nombres.setText("");
            this.vistaProp.jtf_apellidos.setText("");
            this.vistaProp.jtf_direccion.setText(""); 
    }
    
}
