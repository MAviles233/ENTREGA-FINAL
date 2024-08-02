/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import clases.DataBase;
import clases.Proveedor;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que contiene los metodos para poder realizar los diferentes procesos de 
 * nuestro programa con la base de datos, ayudara a gestionar en este caso los 
 * datos de los proveedores.
 * Usara un parametro de tipo DataBase el cual es la clase que nos ayudara a realizar
 * la conexion a nuestra Base de datos
 * 
 */
public class DB_Proveedor {
    private DataBase db = new DataBase();
    
    
    /*
    Metodo el cual guardar toda la informacion necesario de un proveedor directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param proveedor -> parametro de tipo proveedor
     */
    public void guardarProveedor(Proveedor proveedor){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Proveedor (nombre, contacto, correo)VALUES('"+proveedor.getNombre()+"', '"
                    +proveedor.getContacto()+"', '"+proveedor.getCorreo()+"')";
            sql.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"PROVEEDOR REGISTRADO EXISTOSAMENTE");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    
    /*
    Metodo el cual obtiene toda la informacion de los distintos Proveedores 
    existentes y las muestra en una tabla en nuestro programa
    */
    /**
     * 
     * @param proveedor-> parametro de tipo proveedor
     * @param table -> Parametro de tipo DefaulTableModel el cual ayudara a 
     *                 reemplazar el modelo de la tabla para ser llenado
     */
    public void mostrarProveedores(Proveedor proveedor, DefaultTableModel table){
        List<Proveedor> lstProveedor = new ArrayList<Proveedor>();
        
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Proveedor";
            ResultSet r = sql.executeQuery(query);
            while(r.next()){
                proveedor = new Proveedor();
                proveedor.setNombre(r.getString(2));
                proveedor.setContacto(r.getString(3));
                proveedor.setCorreo(r.getString(4));
                lstProveedor.add(proveedor);            
            }
            
            if(!lstProveedor.isEmpty()){
                for(Proveedor p : lstProveedor){
                    Object [] datosProveedor = new Object [3];
                    datosProveedor[0]=p.getNombre();
                    datosProveedor[1]=p.getContacto();
                    datosProveedor[2]=p.getCorreo();
                    table.addRow(datosProveedor);
                }
            }else{
                JOptionPane.showMessageDialog(null, "No existen registros en la base de datos");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
}
