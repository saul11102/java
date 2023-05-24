/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.ed.lista.exception;

/**
 *
 * @author jostin
 */
public class PosicionException extends Exception{

    /**
     * Creates a new instance of <code>PosicionEception</code> without detail
     * message.
     */
    public PosicionException() {
        super("NO existe la posicion");
    }

    /**
     * Constructs an instance of <code>PosicionEception</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PosicionException(String msg) {
        super(msg);
    }
}
