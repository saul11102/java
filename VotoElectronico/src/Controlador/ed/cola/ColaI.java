/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ed.cola;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.TopeException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author santiago
 */
public class ColaI<E> extends ListaEnlazada<E> {

    private Integer tope;

    public ColaI(Integer tope) {
        this.tope = tope;
    }

    ColaI() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Boolean isFull() {
        return (size() >= tope);

    }
    
    public void queue (E dato) throws TopeException{
        if (isFull())
            throw new TopeException("cola sin espacio");
        else this.insertarNodo(dato);
    }

    public E dequeue() throws VacioException, PosicionException{
        E dato =null;
        if(isEmpty()){
            throw new VacioException("Cola vacia");
        }else {
            return this.delete(0);
        }
    }
    
    public Integer getTope(){
        return tope;
    }
}
