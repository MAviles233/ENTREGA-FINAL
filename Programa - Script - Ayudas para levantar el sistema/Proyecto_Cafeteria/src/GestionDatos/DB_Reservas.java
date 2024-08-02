/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import clases.DataBase;
import clases.Reservas;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que contiene los metodos para poder realizar los diferentes procesos de 
 * nuestro programa con la base de datos, ayudara a gestionar la informacion de 
 * las reservas realizada por un cliente.
 * Usara un parametro de tipo DataBase el cual es la clase que nos ayudara a realizar
 * la conexion a nuestra Base de datos
 * 
 */
public class DB_Reservas {
    private DataBase db = new DataBase();
    
    
    
    /*
    Metodo el cual guardar toda la informacion necesario de una Reserva directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param reserva -> parametro de tipo reserva
     */
    public void guardarReserva(Reservas reserva){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Reserva (NroReserva, cliente, telefono, cantidad, dia, mes, anio)VALUES('"
                    +reserva.getNumero()+"', '"+reserva.getCliente()+"', '"+reserva.getTelefono()+"', '"+reserva.getCantidad()+
                    "', '"+reserva.getDia()+"', '"+reserva.getMes()+"', '"+reserva.getAnio()+"')";
            
            sql.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"RESERVA REGISTRADA EXISTOSAMENTE");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    
    /*
    Metodo el cual obtiene toda la informacion de los distintas reservas realizadas
    y las muestra en una tabla en nuestro programa
    */
    /**
     * 
     * @param reserva-> parametro de tipo reserva
     * @param table -> Parametro de tipo DefaulTableModel el cual ayudara a 
     *                 reemplazar el modelo de la tabla para ser llenado
     */
    public void mostrarReservas(Reservas reserva, DefaultTableModel table){
        List<Reservas> lstReserva = new ArrayList<Reservas>();
        
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Reserva";
            ResultSet r = sql.executeQuery(query);
            
            while(r.next()){
                reserva = new Reservas();
                reserva.setNumero(Integer.parseInt(r.getString(2)));
                reserva.setCliente(r.getString(3));
                reserva.setTelefono(r.getString(4));
                reserva.setCantidad(Integer.parseInt(r.getString(5)));
                reserva.setDia(Integer.parseInt(r.getString(6)));
                reserva.setMes(Integer.parseInt(r.getString(7)));
                reserva.setAnio(Integer.parseInt(r.getString(8)));
                lstReserva.add(reserva);
            }
            
            if(!lstReserva.isEmpty()){
                for(Reservas reser : lstReserva){
                    Object[] datosReserva = new Object[7];
                    datosReserva[0]=reser.getNumero();
                    datosReserva[1]=reser.getCliente();
                    datosReserva[2]=reser.getTelefono();
                    datosReserva[3]=reser.getCantidad();
                    datosReserva[4]=reser.getDia();
                    datosReserva[5]=reser.getMes();
                    datosReserva[6]=reser.getAnio();
                    table.addRow(datosReserva);
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS EN LA BASE DE DATOS");
            } 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: " +ex);
        }
    }
}
