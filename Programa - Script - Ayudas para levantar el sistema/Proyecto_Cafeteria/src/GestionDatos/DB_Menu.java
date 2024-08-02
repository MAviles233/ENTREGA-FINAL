/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import clases.DataBase;
import clases.Menu;
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
 * nuestro programa con la base de datos, ayudara a gestionar en este caso los Menus.
 * Usara un parametro de tipo DataBase el cual es la clase que nos ayudara a realizar
 * la conexion a nuestra Base de datos
 * 
 */
public class DB_Menu {
    private DataBase db = new DataBase();
    
    
    /*
    Metodo el cual guardar toda la informacion necesario de un menu directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param menu -> Recibe como parametro un atributo de tipo menu  
     */
    public void guardarMenu(Menu menu){
        
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Menu (nombre, precio, categoria, calorias, ingredientes, descripcion, estado)VALUES('"
                    +menu.getNombre()+"', '"+menu.getPrecio()+"', '"+menu.getCategoria()+"', '"+menu.getCalorias()+
                    "', '"+menu.getIngredientes()+"', '"+menu.getDescripcion()+"', '"+menu.getEstado()+"')";
            
            sql.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"MENU REGISTRADO EXISTOSAMENTE");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    /*
    Metodo el cual elimina un menu de la base de datos
    */
    /**
     * 
     * @param nombre -> recibe como parametro un atributo de tipo String el cual
     * sera un nombre de un menu para poder eliminarlo
     */
    public void eliminarMenu(String nombre){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "DELETE FROM Menu WHERE nombre = '"+nombre+"'";           
            int afirmacion = sql.executeUpdate(query);

            if(afirmacion == 1){
                JOptionPane.showMessageDialog(null,"MENU ELIMINADO");
            }else{
                JOptionPane.showMessageDialog(null,"NO SE PUEDE ELIMINAR EL MENU, COMPRUEBE EL INGRESO DEL NOMBRE DEL MENU");
            }        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    
    /*
    Metodo el cual busca un menu y determina si existe o no
    */
    /**
     * 
     * @param nombre -> Recibe como parametro un atributo de tipo String que sera
     * un nombre de un menu para poder buscarlo en la base de datos
     */
    public void buscarMenu(String nombre){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Menu WHERE nombre = '"+nombre+"'";      
            ResultSet r = sql.executeQuery(query);
            if(r.next()){
                JOptionPane.showMessageDialog(null,"MENU ECONTRADO");
            }else{
                JOptionPane.showMessageDialog(null,"EL MENU INGRESADO NO EXISTE");
            }         
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    
    /*
    Metodo el cual obtiene toda la informacion de los distintos menus existentes
    y las muestra en una tabla en nuestro programa
    */
    /**
     * 
     * @param menu -> parametro de tipo menu
     * @param table -> Parametro de tipo DefaulTableModel el cual ayudara a 
     *                 reemplazar el modelo de la tabla para ser llenado
     */
    public void mostrarMenu(Menu menu, DefaultTableModel table){
        List<Menu> lstMenu = new ArrayList<Menu>();
        int cont = 1;
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Menu";
            ResultSet r = sql.executeQuery(query);
            
            while(r.next()){
                menu = new Menu();
                menu.setNombre(r.getString(2));
                menu.setPrecio(Double.parseDouble(r.getString(3)));
                menu.setCategoria(r.getString(4));
                menu.setCalorias(Double.parseDouble(r.getString(5)));
                menu.setIngredientes(r.getString(6));
                menu.setDescripcion(r.getString(7));
                menu.setEstado(r.getString(8));
                lstMenu.add(menu);
            }
            
            if(!lstMenu.isEmpty()){
                for(Menu m : lstMenu){
                    Object[] datosMenu = new Object[8];
                    datosMenu[0]= cont;
                    datosMenu[1]=m.getNombre();
                    datosMenu[2]=m.getPrecio();
                    datosMenu[3]=m.getCategoria();
                    datosMenu[4]=m.getCalorias();
                    datosMenu[5]=m.getIngredientes();
                    datosMenu[6]=m.getDescripcion();
                    datosMenu[7]=m.getEstado();
                    table.addRow(datosMenu);
                    cont=cont+1;
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS EN LA BASE DE DATOS");
            } 
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: " +ex);
        }
    }
    
    
    
    /*
    Metodo el cual permite modificar cierta informacion de un menu en nuestra
    base datos
    */
    /**
     * 
     * @param nombre -> parametro de tipo String el cual es el nombre de menu
     * @param estado -> parametro de tipo String el cual es el estado del menu ya
     *                  sea activo o inactivo
     * @param precio -> paramatro de tipo double el cual sera un precio/valor
     * |                del menu
     */
    public void editarMenu(String nombre, String estado, double precio){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "UPDATE Menu set precio =" +precio+ ", estado ='" +estado+ "' where nombre = '"+nombre+"'";
            sql.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"MENU ACTUALIZADO");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: No se pudo actualizar el registro, " +ex);
        }
    }
}
