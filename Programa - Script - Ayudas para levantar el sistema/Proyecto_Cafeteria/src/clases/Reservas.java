/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que nos permite tener la informacion de una Reserva, ayudara a 
 * poder guardar la informacion de una Reserva
 * 
 */
public class Reservas {
    private int numero;
    private String cliente;
    private String telefono;
    private int cantidad;
    private int dia;
    private int mes;
    private int anio;
    
    /*
    Constructor default
    */
    public Reservas(){}

    
    /*
    Contructor sobrecargado con los atributos:
    numero-> numero asignado a la reserva
    cliente-> nombres del cliente que realizo la reserva
    telefono-> numero telefonico del cliente que realizo la reserva
    cantidad-> cantidad de personas que van acudir a la reseva
    dia-> dia de la reserva
    mes-> mes de la reserva
    anio-> año de la reserva
    */
    public Reservas(int numero, String cliente, String telefono, int cantidad, int dia, int mes, int anio) {
        this.numero = numero;
        this.cliente = cliente;
        this.telefono = telefono;
        this.cantidad = cantidad;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    
    /*
    Metodos getter y setter de los diferentes atributos
    */
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
}
