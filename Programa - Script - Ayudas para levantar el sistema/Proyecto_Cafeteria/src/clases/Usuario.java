/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que nos permite tener la informacion de un Usuario, 
 * ayudara a poder guardar la informacion de un Usuario
 * 
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String usuario_ingreso;
    private String contrasenia;
    private String correo;
    private String telefono;
    private String cedula;
    private String rol;
    
    
    /*
    Constructor default
    */
    public Usuario(){}
    
    
    /*
    Contructor sobrecargado con los atributos:
    nombre-> Nombres del Usuario/Empleado
    apellido-> Apellidos del Usuario/Empleado
    usuario_ingreso-> Nombre de usuario para ingresar al sistema
    contrasenia-> Contraseña para ingresar al sistema
    correo-> Correo electronico del Usuario/Empleado
    telf-> Numero telefonico del Usuario/Empleado
    cedu-> Numero de cedula del Usuario/Empleado
    rol-> Rol del Usuario/Empleado en el sistema que son ADMINISTRADOR O EMPLEADO
    */
    public Usuario(String nombre, String apellido, String usuario_ingreso, String contrasenia, String correo, String telf, String cedu, String rol){
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario_ingreso = usuario_ingreso;
        this.contrasenia = contrasenia;
        this.correo = correo;
        this.telefono = telf;
        this.cedula = cedu;
        this.rol = rol;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario_ingreso() {
        return usuario_ingreso;
    }

    public void setUsuario_ingreso(String usuario_ingreso) {
        this.usuario_ingreso = usuario_ingreso;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
}
