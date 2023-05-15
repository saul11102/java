/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
 
import controlador.exception.EspacioException;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author alejandro
 */
public class SucursalControl {

    private Sucursal[] sucursales;
    private Sucursal sucursal;
    private Venta venta;

    public SucursalControl() {
        sucursales = new Sucursal[4];
    }

    /**
     * @return the sucursal
     */
    public Sucursal getSucursal() {
        if (sucursal == null) {
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
     * @return the sucursales
     */
    public Sucursal[] getSucursales() {
        return sucursales;
    }

    /**
     * @param sucursales the sucursales to set
     */
    public void setSucursales(Sucursal[] sucursales) {
        this.sucursales = sucursales;
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

    public boolean registrar() throws EspacioException {
        int pos = -1;
        int cont = -1;
        for (Sucursal s : getSucursales()) {
            cont++;
            if (s == null) {
                pos = cont;
                break;
            }

        }

        if (pos == -1) {
            throw new EspacioException();
        }

        sucursal.setVentas(new Venta[EnumMes.values().length]);

        for (int i = 0; i < EnumMes.values().length; i++) {
            Venta venta = new Venta();
            venta.setId(i + 1);
            venta.setMes(EnumMes.values()[i]);
            venta.setValor(0.0);
            sucursal.getVentas()[i] = venta;
        }

        getSucursales()[pos] = getSucursal();
        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException {
        if (this.sucursal != null) {
            if (posVenta <= sucursal.getVentas().length + 1) {
                sucursal.getVentas()[posVenta].setValor(valor);
            } else {
                throw new EspacioException();
            }
        } else {
            throw new NullPointerException("Debe seleccionar una sucursal");
        }

        return true;
    }
}
