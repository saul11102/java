/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ed.Cola;

import Controlador.ed.Pila.Exception.TopeException;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;

/**
 *
 * @author alejandro
 */
public class Cola<E> {
    private ColaImplementacion<E> cola;
    
    public Cola(Integer tope) {
        cola = new ColaImplementacion<>(tope);
    }
    
    public void queue(E obj) throws TopeException{
        cola.queue(obj);
    }
    
    public E dequeue() throws VacioException, PosicionException{
        return  cola.dequeue();
    }
    
    public Integer getTope(){
        return cola.getTope();
    }
    
    public void print () throws VacioException{
        cola.imprimir();
    }

    /**
     * @return the cola
     */
    public ColaImplementacion<E> getCola() {
        return cola;
    }

    /**
     * @param cola the cola to set
     */
    public void setCola(ColaImplementacion<E> cola) {
        this.cola = cola;
    }
    
    
}
