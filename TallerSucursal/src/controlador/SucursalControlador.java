/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Controlador.ed.lista.ListaEnlazada;
import Modelo.Sucursal;
import Modelo.Venta;

/**
 *
 * @author alejandro
 */
public class SucursalControlador {
    private ListaEnlazada<Sucursal> sucursales;
    private Sucursal sucursal;
    private Venta venta;

    public SucursalControlador() {
        this.sucursales = new ListaEnlazada<>();
    }

    public SucursalControlador(ListaEnlazada<Sucursal> sucursales, Sucursal sucursal, Venta venta) {
        this.sucursales = sucursales;
        this.sucursal = sucursal;
        this.venta = venta;
    }

    /**
     * @return the sucursales
     */
    public ListaEnlazada<Sucursal> getSucursales() {
        return sucursales;
    }

    /**
     * @param sucursales the sucursales to set
     */
    public void setSucursales(ListaEnlazada<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    /**
     * @return the sucursal
     */
    public Sucursal getSucursal() {
        return sucursal;
    }

    /**
     * @param sucursal the sucursal to set
     */
    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    /**
     * @return the venta
     */
    public Venta getVenta() {
        return venta;
    }

    /**
     * @param venta the venta to set
     */
    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
}
