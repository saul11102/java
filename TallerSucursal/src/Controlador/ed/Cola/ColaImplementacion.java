/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ed.Cola;

import Controlador.ed.Pila.Exception.TopeException;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author alejandro
 */
public class ColaImplementacion<E> extends ListaEnlazada<E>{
    private Integer tope;

    public ColaImplementacion() {
    }

    public ColaImplementacion(Integer tope) {
        this.tope = tope;
    }
    
    public Boolean isFull(){
        return (size() >= tope); 
    }
    
    public void queue(E dato) throws TopeException{
        if (isFull()) 
            throw new TopeException("Cola sin espacio");
        
        else 
            this.insertarNodo(dato);
        
    }
    
    public E dequeue() throws VacioException, PosicionException{
        if(isEmpty()){
            throw new VacioException("Cola vacia");
        }
        else {
            return this.delete(0);
        }
    }

    /**
     * @return the tope
     */
    public Integer getTope() {
        return tope;
    }

    /**
     * @param tope the tope to set
     */
    public void setTope(Integer tope) {
        this.tope = tope;
    }
    
    
}
