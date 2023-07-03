/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ed.pila;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.TopeException;
import Controlador.ed.lista.Exception.VacioException;

/**
 *
 * @author Juan_fer
 */
public class Pila<E>{
    private PilaImplementacion<E> pilaI;
    
    public Pila(Integer cima) {
        this.pilaI = new PilaImplementacion<>(cima);
    }
    
    public Integer getCIma(){
        return pilaI.getCima();
    }
    
    public void push(E obj) throws TopeException{
        pilaI.push(obj);
    }
    
    public E pop() throws VacioException, PosicionException{
        return pilaI.pop(); 
    }
    
    public void print() throws VacioException{
        pilaI.imprimir();
    }

    /**
     * @return the pilaI
     */
    public PilaImplementacion<E> getPilaI() {
        return pilaI;
    }

    /**
     * @param pilaI the pilaI to set
     */
    public void setPilaI(PilaImplementacion<E> pilaI) {
        this.pilaI = pilaI;
    }
    
    
}
