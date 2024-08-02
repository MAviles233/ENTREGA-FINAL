/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que nos permite tener la informacion de un Turno de un empleado, 
 * ayudara a poder guardar la informacion de un Turno de un empleado
 * 
 */
public class Turno {
    private String empleado;
    private String tipoTurno;
    private int mes;
    private int anio;
    
    
    /*
    Constructor default
    */
    public Turno(){}

    
    /*
    Contructor sobrecargado con los atributos:
    empleado-> Nombres del empleado
    tipoTurno-> si es matutino, vespertino, nocturno
    mes-> mes que le toca ese turno
    anio-> año del cual pertenece el mes que le toco dicho turno
    */
    public Turno(String empleado, String tipoTurno, int mes, int anio) {
        this.empleado = empleado;
        this.tipoTurno = tipoTurno;
        this.mes = mes;
        this.anio = anio;
    }

    
    /*
    Metodos getter y setter de los diferentes atributos
    */
    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(String tipoTurno) {
        this.tipoTurno = tipoTurno;
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
