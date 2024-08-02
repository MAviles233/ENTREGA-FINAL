/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que nos permite tener la informacion de un ingrediente, , ayudara a 
 * poder guardar la informacion de un ingrediente
 * 
 */

public class Ingrediente {
    private String nombre;
    private String proveedor;
    private int cantidad;
    private double costo;
    private String medida;
    private String detalles;
    
    /*
    Constructor default
    */
    public Ingrediente(){}

    /*
    Contructor sobrecargado con los atributos:
    nombre-> el nombre del ingrediente que se esta registrando
    proveedor-> el nombre del proveedor que nos proporciona ese ingrediente
    cantidad-> cantidad numerica de ese ingrediente
    costo-> valor/precio del ingrediente
    medida-> medida del ingrediente como puede ser libra, kilos, etc
    detalles-> informacion adicional del ingrediente
    */
    public Ingrediente(String nombre, String proveedor, int cantidad, double costo, String medida, String detalles) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.costo = costo;
        this.medida = medida;
        this.detalles = detalles;
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
    
}
