/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Grupo 1 - Proyecto Cafeteria - Curso 6-2
 * 
 * Clase que contiene metodos de validacion de campos
 * 
 */
public class ValidacionDatos {
    
    //METODO QUE VALIDA QUE UNICAMENTE SE INTRODUZCAN NUMEROS
    /**
     * 
     * @param cedula -> Recibe como parametro una cedula el cual se tiene que validar
     * @return mensaje -> dependiendo del error que se presente nos mostrara un mensaje distinto
     */
     public static String cedula(String cedula) {
        String mensaje = null;
        try {
            ///Restricción 1
            if (cedula.length() == 10) {
                ///Restricción 3
                if ((Integer.parseInt(cedula.substring(0, 2)) <= 24) || (Integer.parseInt(cedula.substring(0, 2)) == 30)) {
                    int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int digitoVerificador = Integer.parseInt(cedula.substring(cedula.length() - 1, cedula.length()));
                    int suma = 0;
                    int digitoXcoeficiente = 0;
                    int modulo = 0;
                    ///Restricción 4
                    for (int i = 0; i < cedula.length() - 1; i++) {
                        ///Paso 1
                        digitoXcoeficiente = Integer.parseInt(cedula.substring(i, i + 1)) * coeficientes[i];
                        ///Paso 2
                        digitoXcoeficiente = (digitoXcoeficiente > 9) ? digitoXcoeficiente -= 9 : digitoXcoeficiente;
                        ///Paso 3
                        suma += digitoXcoeficiente;
                    }
                    ///Paso 4
                    modulo = suma % 10;
                    ///Paso 5
                    if ((10 - modulo) == digitoVerificador) {
                        //estado = true;
                    }
                    if (modulo == 0 & modulo == digitoVerificador) {
                        //estado = true;
                    }
                } else {///Fin Restricción 3
                    //estado = false;
                    mensaje = "*Su cédula no pertenece a ecuador";
                }
            } else {///Fin Restricción 1
                //estado = false;
                mensaje = "*Este campo debe contener 10 digitos";
            }
        } catch (NumberFormatException e) {
            //estado = false;
            mensaje = "*Error al intentar validar";
        }
        //return estado;
        return mensaje;
    }
     
     
    //Validacion de que el correo sea correcto
     /**
      * 
      * @param correo -> Recibe como parametro un correo el cual se va ha validar
      * @return mensaje -> nos retorna un mensaje segun la situacion que se presente
      */
    public static String correo(String correo) {
        String mensaje = null;
        Pattern patron = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
        Matcher comparador = patron.matcher(correo);
        if(!comparador.find()){
            mensaje = "*Introduce un correo electrónico válido";
        }
        return mensaje;
    }
    
    
    
    //Validacion de numero de telefono tenga 10 digitos
    /**
     * 
     * @param telefono -> Recibe como parametro un numero de telefono 
     * @return mensaje -> nos mostrara un mensaje que indica si faltan o se pasa
     *                    de la cantidad de digitos del numero telefonico
     */
    public static String telefono(String telefono){
        String mensaje = null;
        if(telefono.length()<10){
            mensaje = "*Este campo debe contener 10 digitos";
        }
        return mensaje;
    }
    
    
    
    //Validacion que compruebas que se ingresen caracteres normales
    /**
     * 
     * @param texto -> recibe como parametro un texto
     * @return mensaje -> si el texto contiene un caracter especial, nos avisara con un mensaje
     */
    public static String texto (String texto){
        String mensaje = null;
        Pattern patron = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher comparador = patron.matcher(texto);
        if(comparador.find()){
            mensaje = "*No se permiten caracteres especiales";
        }
        return mensaje;
    }
}
