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
import modelo.Vehiculo;
import vista.*;


/**
 *
 * @author UNIVALLE
 */
public class ControlVehiculoGui implements ActionListener{

    private VistaVehiculo vistaVehic;
    private VistaPropietario vistaProp;
    private Vehiculo vehiculo;
    private List<Vehiculo> listadoAutos= new ArrayList<>();
    
    public ControlVehiculoGui(List<Vehiculo> listaAuts){
        
        this.vistaVehic= new VistaVehiculo();
        this.vistaVehic.setVisible(true);
        
        this.vistaVehic.jbtn_aceptar.addActionListener(this);
        this.vistaVehic.jbtn_consultar.addActionListener(this);
        
        this.listadoAutos= listaAuts;
        
    }
    
    public Vehiculo getVehiculo(){
        return this.vehiculo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Boton Ingresar Vehiculo
        if(e.getSource() == this.vistaVehic.jbtn_aceptar){
            
            this.vehiculo= new Vehiculo();
            String placa=this.vistaVehic.jtf_placa.getText();
            
            if(placa.matches("^[A-Z]{3}[0-9]{3}$")){
                this.vehiculo.setPlaca(placa);                                
            }else{
                JOptionPane.showMessageDialog(vistaVehic, "Formato de placa\nNo válido\n ABC123");
            }
            
            this.vehiculo.setMarca(this.vistaVehic.jtf_marca.getText());            
            
            try{ 
                    this.vehiculo.setAnhoFab(Integer.parseInt(this.vistaVehic.jtf_anhoFab.getText()));  
                
            }catch(NumberFormatException exc){
                JOptionPane.showMessageDialog(vistaVehic, "Debe ingresar el año en números");
            }
            
            this.listadoAutos.add(vehiculo);
            
            limpiarCampos();
        }
        
        if(e.getSource() == this.vistaVehic.jbtn_consultar ){
            Vehiculo auxVehiculo= new Vehiculo();
            int band=0;
            limpiarCampos();
            for(int i=0; i<this.listadoAutos.size(); i++){
                auxVehiculo= this.listadoAutos.get(i);
                
                if(auxVehiculo.getPlaca().equals(auxVehiculo.getPlaca())){
                    band=1;
                    this.vistaVehic.jtf_marca.setText(auxVehiculo.getMarca());
                    this.vistaVehic.jtf_anhoFab.setText(auxVehiculo.getAnhoFab()+"");                  
                }
            }
            
            if(band==0){
                JOptionPane.showMessageDialog(vistaVehic, "Placa no existe!!!");
            }
        }
    }
    
    public void limpiarCampos(){
        this.vistaVehic.jtf_placa.setText("");
        this.vistaVehic.jtf_marca.setText("");
        this.vistaVehic.jtf_anhoFab.setText("");
    }
    
}
