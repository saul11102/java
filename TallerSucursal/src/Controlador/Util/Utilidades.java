/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Util;

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
}
