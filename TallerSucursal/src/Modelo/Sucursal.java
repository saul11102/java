/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

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
    }

    public Sucursal(Integer id, String nombre, ListaEnlazada<Venta> listaVenta) {
        this.id = id;
        this.nombre = nombre;
        this.listaVenta = listaVenta;
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

    
}
