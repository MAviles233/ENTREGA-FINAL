/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que nos permite tener la informacion de un Proveedor, ayudara a 
 * poder guardar la informacion de un Proveedor
 * 
 */
public class Proveedor {
    private String nombre;
    private String contacto;
    private String correo;
    
    /*
    Constructor default
    */
    public Proveedor(){}

    
    /*
    Contructor sobrecargado con los atributos:
    nombre-> nombre/compañia del proveedor
    contacto-> numero telefonico del proveedor
    correo-> correo del proveedor
    */
    public Proveedor(String nombre, String contacto, String correo) {
        this.nombre = nombre;
        this.contacto = contacto;
        this.correo = correo;
    }

    
    /*
    Metodos getter y setter de los diferentes atributos
    */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
