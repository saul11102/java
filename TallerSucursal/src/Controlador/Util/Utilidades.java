/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Util;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import Controlador.ed.lista.NodoLista;
import Modelo.Sucursal;
import Modelo.Venta;

/**
 *
 * @author alejandro
 */
public class Utilidades {
    /**
     * Método que suma las ventas de cada sucursal
     * @param s objeto de la clase Sucursal
     * @return la suma
     */
    public static Double sumarVentas(Sucursal s) {
        double suma = 0.0;
        ListaEnlazada<Venta> listaVentas = s.getListaVenta();

        NodoLista<Venta> nodo = listaVentas.getCabecera();
        while (nodo != null) {
            Venta venta = nodo.getInfo();
            suma += venta.getValor();
            nodo = nodo.getSig();
        }

        return suma;
    }
    
    /**
     * Método que devuelve la media de las ventas
     * @param s objeto de la clase sucursal
     * @return retorna la media
     */
    public static Double mediaVentas(Sucursal s) {
        Double suma = sumarVentas(s);
        ListaEnlazada<Venta> listaVentas = s.getListaVenta();
        
        if (suma == 0) {
            return suma;
        } else {
            return suma / listaVentas.size();
        }
    }
    
    /**
     * Método para obtener el valor de la venta mayor entre todos los meses
     * @param s
     * @return returna el valor de la venta mayor
     * @throws PosicionException
     * @throws VacioException 
     */
    public static Double obtenerMayorVenta(Sucursal s)throws PosicionException, VacioException{
        ListaEnlazada<Venta> listaVentas = s.getListaVenta();
        NodoLista<Venta> nodo = listaVentas.getCabecera();
        Double ventas = 0.0;
        while (nodo != null){
            Venta v = nodo.getInfo();
            if(v.getValor() > ventas)
                ventas = v.getValor();
            nodo = nodo.getSig();
        }
        return ventas;
    }
    
    /**
     * Método para calcular el mes con menor ventas de todos
     * @param s
     * @return el mes que se obtuvieron menos ventas
     * @throws PosicionException
     * @throws VacioException 
     */
    public static String calcularMenorVenta(Sucursal s)throws PosicionException, VacioException{
        ListaEnlazada<Venta> listaVentas = s.getListaVenta();
        Double ventas = obtenerMayorVenta(s);
        NodoLista<Venta> nodo = listaVentas.getCabecera();
        String ventaMenor = "";
        
        while (nodo != null){
            Venta v = nodo.getInfo();
            if (ventas > v.getValor()){
                ventas = v.getValor();
                ventaMenor = v.getMes().name();
            }
            nodo = nodo.getSig();
        }
        
        return ventaMenor;
    }
}
