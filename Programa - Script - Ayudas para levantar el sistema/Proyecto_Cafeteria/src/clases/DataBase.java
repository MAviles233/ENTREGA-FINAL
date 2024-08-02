/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase donde se gestiona la conexion del netbeans con la base de datos, solamente
 * se realiza una conexion entre ambas
 * 
 */
public class DataBase {
    
    private Connection con;
    
    //Metodo para conectar o realizar la conexion a la Base de datos desde netbeans
    public Connection conexion(){
        String conexionUrl = "jdbc:sqlserver://LAPTOP-OGCF46E5\\SQLEXPRESS:1433;" 
                + "database=Proyecto_Cafeteria;"
                + "user=sa;"
                + "password=12345678;"
                + "loginTimeout=30";
        
        try{
            con = DriverManager.getConnection(conexionUrl);
            return con;
        }catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
    }
    
    //Metodo para cerrar la conexion de la Base de datos una vez que esta conectada el programa con la base
    public void cerrar(){
         try{
            con.close();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }       
    }
}
