/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que nos permite tener la informacion de un menu, , ayudara a 
 * poder guardar la informacion de un menu
 * 
 */
public class Menu {
    private String nombre;
    private double precio;
    private String categoria;
    private double calorias;
    private String ingredientes;
    private String descripcion;
    private String estado;
    
    
    /*
    Constructor default
    */
    public Menu(){}

    
    /*
    Contructor sobrecargado con los atributos:
    nombre-> el nombre del menu que se esta registrando
    precio-> valor/precio del menu
    categoria-> si es sopa, bebidad, postre, etc
    calorias-> valores como 500 kcal
    ingredientes-> ingredientes que se usan para el menu
    descripcion-> informacion adicional del menu
    estado-> Activo si esta disponinle, Inactivo si no hay disponibilidad
    */
    public Menu(String nombre, double precio, String categoria, double calorias, String ingredientes, String descripcion, String estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.calorias = calorias;
        this.ingredientes = ingredientes;
        this.descripcion = descripcion;
        this.estado = estado;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
