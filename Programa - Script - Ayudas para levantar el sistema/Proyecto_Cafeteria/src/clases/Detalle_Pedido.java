/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que contiene todos los atributos que puede tener un detalle de un pedido
 * realizado, ayudara a poder guardar la informacion del pedido
 */

public class Detalle_Pedido {
    private int numero_pedido;
    private String menu;
    private double precio;
    private int cantidad;
    private double subTotal;
    
    /*
    Constructor default
    */
    public Detalle_Pedido(){}

    /*
    Contructor sobrecargado con los atributos:
    numero_pedido-> contendra el numero del pedido
    menu-> el nombre del menu que se va a consumir
    precio-> precio del menu que esta pidiendo
    cantidad-> cantidad numerica del menu que se esta pidiendo
    subtotal-> contiene el valor de los diferentes menu que se hayan pedido (no estara incluido el iva)
    */
    public Detalle_Pedido(int numero_pedido, String menu, double precio, int cantidad, double subTotal) {
        this.numero_pedido = numero_pedido;
        this.menu = menu;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    /*
    Metodos getter y setter de los diferentes atributos
    */
    
    public int getNumero_pedido() {
        return numero_pedido;
    }

    public void setNumero_pedido(int numero_pedido) {
        this.numero_pedido = numero_pedido;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
    
}
