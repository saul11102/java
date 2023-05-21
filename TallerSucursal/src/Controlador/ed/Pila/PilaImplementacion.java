/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ed.Pila;

import Controlador.ed.Pila.Exception.TopeException;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author alejandro
 */
public class PilaImplementacion<E> extends ListaEnlazada<E>{
    private Integer cima;

    public PilaImplementacion() {
    }

    public PilaImplementacion(Integer cima) {
        this.cima = cima;
    }
    
    public boolean isFull(){
        return (size() >= getCima());
    }

    public void push (E info)throws TopeException{
        if (!isFull())
            insertarInicio(info);
        else
            throw new TopeException();
    }
    
    public E pop() throws VacioException, PosicionException{
        E dato = null;
        if (isEmpty())
            throw new VacioException();
        else
            return delete(0);
    }
    
    /**
     * @return the cima
     */
    public Integer getCima() {
        return cima;
    }

    /**
     * @param cima the cima to set
     */
    public void setCima(Integer cima) {
        this.cima = cima;
    }
    
    
}
