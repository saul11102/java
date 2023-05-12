/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Controlador.ed.lista.ListaEnlazada;
import Modelo.Sucursal;
import Modelo.Venta;

/**
 *
 * @author alejandro
 */
public class SucursalControl {
    private ListaEnlazada<Sucursal> listaSucursal;
    private Sucursal sucursal;
    private Venta venta;

    public SucursalControl() {
        this.listaSucursal = null;
    }

    public SucursalControl(ListaEnlazada<Sucursal> listaSucursal, Sucursal sucursal, Venta venta) {
        this.listaSucursal = listaSucursal;
        this.sucursal = sucursal;
        this.venta = venta;
    }

    /**
     * @return the listaSucursal
     */
    public ListaEnlazada<Sucursal> getListaSucursal() {
        return listaSucursal;
    }

    /**
     * @param listaSucursal the listaSucursal to set
     */
    public void setListaSucursal(ListaEnlazada<Sucursal> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }

    /**
     * @return the sucursal
     */
    public Sucursal getSucursal() {
        if (sucursal == null){
            sucursal = new Sucursal();
        }
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

   public boolean registrar() {
       return true;
   }
    
}
