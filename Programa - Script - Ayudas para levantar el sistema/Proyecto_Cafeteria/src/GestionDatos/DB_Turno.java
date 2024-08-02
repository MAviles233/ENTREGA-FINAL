/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import clases.DataBase;
import clases.Turno;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que contiene los metodos para poder realizar los diferentes procesos de 
 * nuestro programa con la base de datos, ayudara a gestionar en este caso la
 * informacion de los turnos de un empleado.
 * Usara un parametro de tipo DataBase el cual es la clase que nos ayudara a realizar
 * la conexion a nuestra Base de datos
 * 
 */
public class DB_Turno {
    private DataBase db = new DataBase();
    
    
    /*
    Metodo el cual guardar toda la informacion necesario de un pedido directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param turno -> parametro de tipo turno
     */
    public void guardarTurno(Turno turno){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Turno (nombreEmpleado, tipoTurno, mes, anio)VALUES('"
                    +turno.getEmpleado()+"', '"+turno.getTipoTurno()+"', '"+turno.getMes()+"', '"+turno.getAnio()+"')";
            
            sql.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"TURNO REGISTRADO EXISTOSAMENTE");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    /*
    Metodo el cual obtiene toda la informacion de los distintos Pedidos existentes
    y las muestra en una tabla en nuestro programa
    */
    /**
     * 
     * @param turno-> parametro de tipo turno
     * @param table -> Parametro de tipo DefaulTableModel el cual ayudara a 
     *                 reemplazar el modelo de la tabla para ser llenado
     */
    public void mostrarTurnos(Turno turno, DefaultTableModel table){
        List<Turno> lstTurno = new ArrayList<Turno>();
        
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Turno";
            ResultSet r = sql.executeQuery(query);
            
            while(r.next()){
                turno = new Turno();
                turno.setEmpleado(r.getString(2));
                turno.setTipoTurno(r.getString(3));
                turno.setMes(Integer.parseInt(r.getString(4)));
                turno.setAnio(Integer.parseInt(r.getString(5)));
                lstTurno.add(turno);
            }
            
            if(!lstTurno.isEmpty()){
                for(Turno t : lstTurno){
                    Object[] datosTurno = new Object[4];
                    datosTurno[0]=t.getEmpleado();
                    datosTurno[1]=t.getTipoTurno();
                    datosTurno[2]=t.getMes();
                    datosTurno[3]=t.getAnio();
                    table.addRow(datosTurno);
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS EN LA BASE DE DATOS");
            } 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: " +ex);
        }
    }
}
