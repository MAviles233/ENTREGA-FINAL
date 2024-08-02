/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import clases.DataBase;
import clases.Detalle_Pedido;
import clases.Pedido;
import clases.Propina;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import javax.swing.JComboBox;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que contiene los metodos para poder realizar los diferentes procesos de 
 * nuestro programa con la base de datos, ayudara a gestionar en este caso los 
 * pedidos realizados junto con sus respectivo detalles.
 * Usara un parametro de tipo DataBase el cual es la clase que nos ayudara a realizar
 * la conexion a nuestra Base de datos
 * 
 */
public class DB_Pedido {
    private DataBase db = new DataBase();
    
    
    /*
    Metodo el cual guardar toda la informacion necesario de un pedido directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param pedido -> parametro de tipo pedido
     */
    public void guardarPedido(Pedido pedido){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Pedido (id_pedido, nombres_Cliente, total)VALUES('"
                    +pedido.getNumero_pedido()+"', '"+pedido.getCliente()+"', '"+pedido.getTotal()+"')";
            sql.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "PEDIDO REGISTRADO");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " +ex);
        }
    }
    
    
    /*
    Metodo el cual guardar toda la informacion necesario de un detalle del pedido directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param detalle -> parametro de tipo Detalle_Pedido
     */
    public void guardarDetallePedido(Detalle_Pedido detalle){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Detalle_Pedido (id_pedido, menu, precio, cantidad, subtotal)VALUES('"
                    +detalle.getNumero_pedido()+"', '"+detalle.getMenu()+"', '"+detalle.getPrecio()+"', '"+detalle.getCantidad()+"', '"
                    +detalle.getSubTotal()+"')";
            sql.executeUpdate(query);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " +ex);
        }
    }
    
    
    /*
    Metodo el cual obtiene toda la informacion de los distintos Pedidos existentes
    y las muestra en una tabla en nuestro programa
    */
    /**
     * 
     * @param pedido-> parametro de tipo pedido
     * @param table -> Parametro de tipo DefaulTableModel el cual ayudara a 
     *                 reemplazar el modelo de la tabla para ser llenado
     */
    public void mostrarPedidos(Pedido pedido, DefaultTableModel table){
        List <Pedido> lstPedido = new ArrayList<Pedido>();
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Pedido";
            ResultSet r = sql.executeQuery(query);
            while(r.next()){
                pedido = new Pedido();
                pedido.setNumero_pedido(Integer.parseInt(r.getString(1)));
                pedido.setCliente(r.getString(2));
                pedido.setTotal(Double.parseDouble(r.getString(3)));
                lstPedido.add(pedido);
            }
            if(!lstPedido.isEmpty()){
                for(Pedido p : lstPedido){
                    Object [] datosPedido = new Object [3];
                    datosPedido[0]=p.getNumero_pedido();
                    datosPedido[1]=p.getCliente();
                    datosPedido[2]=p.getTotal();
                    table.addRow(datosPedido);
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS EN LA BASE DE DATOS");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error: " +ex);
        }
    }
    
    
    /*
    Metodo el cual obtiene la informacion en este caso el nombre de los menus existentes
    y los almacena un un comboBox para poder seleccionarlos
    */
    /**
     * 
     * @param comboBox -> recibe como parametro un dato de tipo JComboBox el 
     * cual sera llenado con los diferentes nombres de menus que existan en
     * la base datos
     */
    public void consultaMenus(JComboBox comboBox){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT nombre FROM Menu";
            ResultSet r = sql.executeQuery(query);
            
            while(r.next()){
                comboBox.addItem(r.getString(1));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: Problemas para cargar el menu" +ex);
        }
    }
    
    
    
    /*
    Metodo el cual guardar toda la informacion necesario de una propina directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param propina -> parametro de tipo propina
     */
    public void guardarPropina(Propina propina){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Propina (id_NroPedido, valor)VALUES('"
                    +propina.getNroPedido()+"', '"+propina.getValorPropina()+"')";
            sql.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "PROPINA REGISTRADA");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: " +ex);
        }
    }
    
    
    
    /*
    Metodo el cual obtiene toda la informacion de las propinas recibidas
    y las muestra en una tabla en nuestro programa
    */
    /**
     * 
     * @param propina -> parametro de tipo propina
     * @param table -> Parametro de tipo DefaulTableModel el cual ayudara a 
     *                 reemplazar el modelo de la tabla para ser llenado
     */
    public void mostrarPropinas(Propina propina, DefaultTableModel table){
        List<Propina> lstPropina = new ArrayList<Propina>();
        
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Propina";
            ResultSet r = sql.executeQuery(query);
            
            while(r.next()){
                propina = new Propina();
                propina.setNroPedido(Integer.parseInt(r.getString(1)));
                propina.setValorPropina(Double.parseDouble(r.getString(2)));
                lstPropina.add(propina);
            }
            if(!lstPropina.isEmpty()){
                for(Propina p : lstPropina){
                    Object [] datosPropina = new Object[2];
                    datosPropina[0]=p.getNroPedido();
                    datosPropina[1]=p.getValorPropina();
                    table.addRow(datosPropina);
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS EN LA BASE DE DATOS");              
            }           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: " +ex);
        }
    }
    
    
    
    /*
    Metodo el cual ayuda a saber cual fue el ultimo numero de pedido registrado
    en nuestra Base de Datos para que el sistema continues con la numeracion 
    */
    /**
     * 
     * @param nro -> parametro de tipo int
     * @return nro -> retorna un valor de tipo int que sera el ultimo numero de 
     *                pedido de nuestra base datos
     */
    public int consultaUltimoNroPedido(int nro){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT id_pedido FROM Pedido";
            ResultSet r = sql.executeQuery(query);
            
            while(r.next()){
                nro = Integer.parseInt(r.getString(1));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR: " +ex);
        }       
        return nro;
    }
}
