/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author alejandro
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private ListaEnlazada<Venta> listaVenta;

    public Sucursal() {
        this.listaVenta = new ListaEnlazada<Venta>();
    }

    public Sucursal(Integer id, String nombre, ListaEnlazada<Venta> listaVenta) {
        this.id = id;
        this.nombre = nombre;
        this.listaVenta = listaVenta;
    }

    @Override
    public String toString() {
        return getNombre().toString() + " " + getId();
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the listaVenta
     */
    public ListaEnlazada<Venta> getListaVenta() {
        return listaVenta;
    }

    /**
     * @param listaVenta the listaVenta to set
     */
    public void setListaVenta(ListaEnlazada<Venta> listaVenta) {
        this.listaVenta = listaVenta;
    }

    /**
     * Método que permite agregar 1 sola venta a la sucursal
     *
     * @param venta objeto de la clase Venta
     */
    public void setVenta(Venta venta) {
        listaVenta.insertarNodo(venta);
    }

    public Venta getVenta(int posicion) {
        try {
            return listaVenta.get(posicion);
        } catch (PosicionException | VacioException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
    
}
