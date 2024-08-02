/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que nos permite tener la informacion de un Pedido, , ayudara a 
 * poder guardar la informacion de un Pedido
 * 
 */
public class Pedido {
    private int numero_pedido;
    private String cliente;
    private double total;
    
    /*
    Constructor default
    */
    public Pedido(){}

    
    /*
    Contructor sobrecargado con los atributos:
    numero_pedido-> numero del pedido realizado
    cliente-> nombres del cliente que realiza el pedido
    total-> valor de todo el pedido (incluye el iva)
    */
    public Pedido(int numero_pedido, String cliente, double total) {
        this.numero_pedido = numero_pedido;
        this.cliente = cliente;
        this.total = total;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
