/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import clases.DataBase;
import clases.Ingrediente;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que contiene los metodos para poder realizar los diferentes procesos de 
 * nuestro programa con la base de datos, ayudara a gestionar en este caso los 
 * ingredientes.
 * Usara un parametro de tipo DataBase el cual es la clase que nos ayudara a realizar
 * la conexion a nuestra Base de datos
 * 
 */
public class DB_Ingrediente {
    private DataBase db = new DataBase();
    
    /*
    Metodo el cual guardar toda la informacion necesario de un ingrediente directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param ingrediente -> Recibe como parametro un atributo de tipo ingrediente  
     */
    public void guardarIngrediente(Ingrediente ingrediente){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Ingrediente (nombre, proveedor, cantidad, costo, medida, detalles)VALUES('"
                    +ingrediente.getNombre()+"', '"+ingrediente.getProveedor()+"', '"+ingrediente.getCantidad()+"', '"+ingrediente.getCosto()+
                    "', '"+ingrediente.getMedida()+"', '"+ingrediente.getDetalles()+"')";
            
            sql.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"INGREDIENTE REGISTRADO EXISTOSAMENTE");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    /*
    Metodo el cual obtiene la informacion que exista en nuestra Base de datos y la
    muestra en una tabla en el programa
    */
    /**
     * 
     * @param ingrediente -> Parametro de tipo Ingrediente 
     * @param table -> Parametro de tipo DefaulTableModel el cual ayudara a 
     *                 reemplazar el modelo de la tabla para ser llenado
     */
    public void mostrarIngrediente(Ingrediente ingrediente, DefaultTableModel table){
        List<Ingrediente> lstIngrediente = new ArrayList<Ingrediente>();
        
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Ingrediente";
            ResultSet r = sql.executeQuery(query);
            
            while(r.next()){
                ingrediente = new Ingrediente();
                ingrediente.setNombre(r.getString(2));
                ingrediente.setProveedor(r.getString(3));
                ingrediente.setCantidad(Integer.parseInt(r.getString(4)));
                ingrediente.setCosto(Double.parseDouble(r.getString(5)));
                ingrediente.setMedida(r.getString(6));
                ingrediente.setDetalles(r.getString(7));
                lstIngrediente.add(ingrediente);
            }
            
            if(!lstIngrediente.isEmpty()){
                for(Ingrediente i : lstIngrediente){
                    Object[] datosIngrediente = new Object[6];
                    datosIngrediente[0]= i.getNombre();
                    datosIngrediente[1]=i.getProveedor();
                    datosIngrediente[2]=i.getCantidad();
                    datosIngrediente[3]=i.getCosto();
                    datosIngrediente[4]=i.getMedida();
                    datosIngrediente[5]=i.getDetalles();
                    table.addRow(datosIngrediente);
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS EN LA BASE DE DATOS");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }

    
    /*
    Metodo el cual obtiene la informacion en este caso el nombre del proveedor y 
    los almacena un un comboBox para poder seleccionarlos
    */
    /**
     * 
     * @param comboBox -> recibe como parametro un dato de tipo JComboBox el 
     * cual sera llenado con los diferentes nombres de proveedores que existan en
     * la base datos
     */
    public void consultaProveedor(JComboBox comboBox){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT nombre FROM Proveedor";
            ResultSet r = sql.executeQuery(query);
            
            while(r.next()){
                comboBox.addItem(r.getString(1));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: Problemas al cargar los proveedores " +ex);
        }
    }
}
