/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import vista.VistaMenuSTY;
import control.*;
import javax.swing.JOptionPane;
import modelo.*;
import vista.VistaPropietario;

/*
 *
 * @author UNIVALLE
 *
 */
public class ControlMenuSTYGui implements ActionListener {
    
    private VistaMenuSTY vistaMenSTY;
    private VistaPropietario vistaPropietario;
    
    //Listas de objetos de las clases modelo
    private List<Vehiculo> listaVehiculos= new ArrayList<>();
    private List<Propietario> listaPropietarios= new ArrayList<>();
    private List<TarjetaPropiedad> listaTarjetasPropiedad= new ArrayList<>();
    
    
    public ControlMenuSTYGui(){
                
        this.vistaMenSTY= new VistaMenuSTY();
        
        this.vistaMenSTY.setVisible(true);
        
        this.vistaMenSTY.jbtn_vehiculo.addActionListener(this);
        this.vistaMenSTY.jbtn_listarVehiculos.addActionListener(this);
        
        this.vistaMenSTY.jbtn_propietario.addActionListener(this);
        this.vistaMenSTY.jbtn_listarPropietarios.addActionListener(this);
        
        this.vistaMenSTY.jbtn_tarjetaPropiedad.addActionListener(this);
        this.vistaMenSTY.jbtn_listarTarjetas.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Boton Ingresar Vehiculo
        if(e.getSource() == this.vistaMenSTY.jbtn_vehiculo){
            ControlVehiculoGui unControlVehiGui= new ControlVehiculoGui(this.listaVehiculos);            
        }
        
        //Boton Listar Vehiculos
        if(e.getSource() == this.vistaMenSTY.jbtn_listarVehiculos){
            
            String vehiculos="";
            if(this.listaVehiculos.size()>0){                
                for(int i=0; i<this.listaVehiculos.size(); i++){
                    vehiculos += "Placa: "+this.listaVehiculos.get(i).getPlaca()+"\n";
                    vehiculos += "Marca: "+this.listaVehiculos.get(i).getMarca()+"\n";
                    vehiculos += "AñoFab: "+this.listaVehiculos.get(i).getAnhoFab()+"\n";
                    vehiculos += "-----------------------------\n";
                }
                JOptionPane.showMessageDialog(vistaMenSTY, vehiculos);
            }else{            
                System.out.println("No se han ingresado vehículos");
            }
        }
        
        //Boton Ingresar Propietario
        if(e.getSource() == this.vistaMenSTY.jbtn_propietario){
            ControlPropietarioGui unControlPropietarioGui= new ControlPropietarioGui(this.listaPropietarios);
        }
        
        //Boton Listar Propietarios
        if(e.getSource() == this.vistaMenSTY.jbtn_listarPropietarios){
            
            String propietarios="";
            if(this.listaPropietarios.size()>0){                
                for(int i=0; i<this.listaPropietarios.size(); i++){
                    propietarios += "DNI: "+this.listaPropietarios.get(i).getDni()+"\n";
                    propietarios += "Nobmres: "+this.listaPropietarios.get(i).getNombres()+"\n";
                    propietarios += "Apellidos: "+this.listaPropietarios.get(i).getApellidos()+"\n";
                    propietarios += "Dirección: "+this.listaPropietarios.get(i).getDireccion()+"\n";
                    propietarios += "-----------------------------\n";
                }
                JOptionPane.showMessageDialog(vistaMenSTY, propietarios);
            }else{            
                System.out.println("No se han ingresado Propietarios");
            }
        }
        
        //Boton Ingresar Tarjeta Propiedad
        if(e.getSource() == this.vistaMenSTY.jbtn_tarjetaPropiedad){
            ControlTarjetaPropiedadGui unControlPropietarioGui= new ControlTarjetaPropiedadGui(this.listaVehiculos, this.listaPropietarios, this.listaTarjetasPropiedad);
        }
        
        //Boton Listar Tarjetas de Propiedad
        if(e.getSource() == this.vistaMenSTY.jbtn_listarTarjetas){
            
            if(this.listaTarjetasPropiedad.size()>0){                
                for(int i=0; i<this.listaTarjetasPropiedad.size(); i++){
                    System.out.println(this.listaTarjetasPropiedad.get(i).getVehiculo());
                    System.out.println(this.listaTarjetasPropiedad.get(i).getPropietario());
                    System.out.println(this.listaTarjetasPropiedad.get(i).getCodigo());
                    System.out.println(this.listaTarjetasPropiedad.get(i).getFechaExp()+"");
                    System.out.println();
                }
            }else{            
                System.out.println("No se han ingresado Propietarios");
            }
        }
    }
    
}
