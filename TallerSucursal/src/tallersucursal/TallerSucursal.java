/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallersucursal;

import Controlador.ed.Cola.Cola;
import Controlador.ed.Pila.Exception.TopeException;
import Controlador.ed.Pila.Pila;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import Modelo.EnumMes;
import Modelo.Sucursal;
import Modelo.Venta;

/**
 *
 * @author alejandro
 */
public class TallerSucursal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws VacioException, TopeException, PosicionException {
        Pila<Integer> pila = new Pila<>(5);
        Cola<Integer> cola = new Cola<>(5);
        try {
            pila.push(5);
            pila.push(56);
            pila.push(23);
            pila.push(123);
            pila.push(43);
            pila.print();
            pila.pop();
            pila.print();
            
            System.err.println("FILA --------------------------");
            
            cola.queue(5);
            cola.queue(56);
            cola.queue(23);
            cola.queue(123);
            cola.queue(43);
            cola.print();
            cola.dequeue();
            cola.print();
            
        } catch (VacioException e) {
            System.err.println(e.getMessage());
        }
    }

}
