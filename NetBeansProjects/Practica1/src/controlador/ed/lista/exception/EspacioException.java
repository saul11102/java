/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista.exception;

/**
 *
 * @author jostin
 */
public class EspacioException extends Exception{

    public EspacioException(String message) {
        super(message);
    }
    
    public EspacioException() {
        super("No hay espacio suficiente, posicion invalida");
    }
    
    
}
