/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GestionDatos;

import clases.DataBase;
import clases.Usuario;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que contiene los metodos para poder realizar los diferentes procesos de 
 * nuestro programa con la base de datos, ayudara a gestionar en este caso la 
 * informacion de los usuarios/empleados.
 * Usara un parametro de tipo DataBase el cual es la clase que nos ayudara a realizar
 * la conexion a nuestra Base de datos
 * 
 */
public class DB_Usuario {
    
    private DataBase db = new DataBase();
    
    
    /*
    Metodo el cual guardar toda la informacion necesario de un pedido directamente
    a nuestra Base de datos
    */
    /**
     * 
     * @param user -> parametro de tipo Usuario
     */
    public void guardarUsuario(Usuario user){
        
        try{
            Statement sql = db.conexion().createStatement();
            String query = "INSERT INTO Usuario (nombre, apellido, usuario_ingreso, contrasenia, correo, telefono, cedula, rol )VALUES('"
                    +user.getNombre()+"', '"+user.getApellido()+"', '"+user.getUsuario_ingreso()+"', '"+user.getContrasenia()+
                    "', '"+user.getCorreo()+"', '"+user.getTelefono()+"', '"+user.getCedula()+"', '"+user.getRol()+"')";
            
            sql.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"USUARIO INGRESADO");
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    
    /*
    Metodo el cual elimina un usuario/empleado de la base de datos
    */
    /**
     * 
     * @param cedula -> recibe como parametro un atributo de tipo String el cual
     * sera la cedula de un usuario/empleado para poder eliminarlo
     */
    public void eliminarUsuario(String cedula){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "DELETE FROM Usuario WHERE cedula = '"+cedula+"'";           
            int afirmacion = sql.executeUpdate(query);
            
            if(afirmacion == 1){
                JOptionPane.showMessageDialog(null,"USUARIO ELIMINADO");
            }else{
                JOptionPane.showMessageDialog(null,"NO SE PUEDE ELIMINAR EL USUARIO, COMPRUEBA SI LA CEDULA ES CORRECTA");
            }           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error:" +ex);
        }
    }
    
    
    
    /*
    Metodo el cual busca un usuario/empleado y determina si existe o no
    */
    /**
     * 
     * @param cedula -> Recibe como parametro un atributo de tipo String que sera
     * una cedula de un usuario/empleado para poder buscarlo en la base de datos
     */
    public void buscarUsuario(String cedula){
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Usuario WHERE cedula = '"+cedula+"'";            
            ResultSet r = sql.executeQuery(query);
            
            if(r.next()){
                JOptionPane.showMessageDialog(null,"USUARIO ECONTRADO");
            }else{
                JOptionPane.showMessageDialog(null,"EL USUARIO INGRESADO NO EXISTE");
            }  
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: Usuario no encontrado " +ex);
        }
    }
    
    
    
    /*
    Metodo el cual obtiene toda la informacion de los usuarios/empleados existentes
    y las muestra en una tabla en nuestro programa
    */
    /**
     * 
     * @param user-> parametro de tipo Usuario
     * @param table -> Parametro de tipo DefaulTableModel el cual ayudara a 
     *                 reemplazar el modelo de la tabla para ser llenado
     */
    public void mostrarUsuarios(Usuario user, DefaultTableModel table){
        List<Usuario> lstUser = new ArrayList<Usuario>();
        int cont = 1;
        try{
            Statement sql = db.conexion().createStatement();
            String query = "SELECT * FROM Usuario";
            ResultSet r = sql.executeQuery(query);
            while(r.next()){
                user = new Usuario();
                user.setNombre(r.getString(2));
                user.setApellido(r.getString(3));
                user.setUsuario_ingreso(r.getString(4));
                user.setContrasenia(r.getString(5));
                user.setCorreo(r.getString(6));
                user.setTelefono(r.getString(7));
                user.setCedula(r.getString(8));
                user.setRol(r.getString(9));
                lstUser.add(user);
            }    
            if(!lstUser.isEmpty()){
                for(Usuario u : lstUser){
                    Object[] datosUser = new Object[9];
                    datosUser[0]= cont;
                    datosUser[1]=u.getNombre();
                    datosUser[2]=u.getApellido();
                    datosUser[3]=u.getUsuario_ingreso();
                    datosUser[4]=u.getContrasenia();
                    datosUser[5]=u.getCorreo();
                    datosUser[6]=u.getTelefono();
                    datosUser[7]=u.getCedula();
                    datosUser[8]=u.getRol();
                    table.addRow(datosUser);
                    cont=cont+1;
                }
            }else{
                JOptionPane.showMessageDialog(null, "NO HAY REGISTROS EN LA BASE DE DATOS");
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: " +ex);
        }
    }
}
