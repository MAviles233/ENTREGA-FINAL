/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que nos permite tener la informacion de una Propina, ayudara a 
 * poder guardar la informacion de un Propina
 * 
 */
public class Propina {
    private int nroPedido;
    private double valorPropina;
    
    /*
    Constructor default
    */
    public Propina(){}

    
    /*
    Contructor sobrecargado con los atributos:
    nroPedido-> numero del pedido del cual se hizo la propina
    valorPropina-> valor/precio de la propina que fue adquirida
    */
    public Propina(int nroPedido, double valorPropina) {
        this.nroPedido = nroPedido;
        this.valorPropina = valorPropina;
    }

    
    /*
    Metodos getter y setter de los diferentes atributos
    */
    public int getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(int nroPedido) {
        this.nroPedido = nroPedido;
    }

    public double getValorPropina() {
        return valorPropina;
    }

    public void setValorPropina(double valorPropina) {
        this.valorPropina = valorPropina;
    }
    
}
