/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exception.EspacioException;
import java.util.ArrayList; // Importa la clase ArrayList
import java.util.List;
import modelo.EnumMes;
import modelo.Sucursal;
import modelo.Venta;
/**
 *
 * @author jostin
 */
public class SucursalControl {
    private List<Sucursal> sucursales;
    private Sucursal sucursal;
    private List<Venta> ventas; // Cambia el tipo de dato a List<Venta>

    public SucursalControl() {
        sucursales = new ArrayList<>(); // Inicializa la lista de sucursales
        ventas = new ArrayList<>(); // Inicializa la lista de ventas
    }

    public Sucursal getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal();
        }
        return sucursal;
    }

    public List<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public List<Venta> getVentas() { // Cambia el tipo de dato del getter
        return ventas;
    }

    public void setVentas(List<Venta> ventas) { // Cambia el tipo de dato del setter
        this.ventas = ventas;
    }


    
    /*
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
            venta.setId((i + 1));
            venta.setMes(EnumMes.values()[i]);
            venta.setValor(0.0);
            sucursal.getVentas()[i] = venta;

        }

        sucursales[pos] = sucursal;
        return true;

    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException{
        /*
        Sucursal sucursal = getSucursal();
        int mesIndex = posVenta - 1;
        Venta venta = sucursal.getVentas()[mesIndex];
        venta.setValor(valor);
        return true;
        }
        */
        /*  
        if (this.sucursal != null) {
            if (posVenta <= this.sucursal.getVentas().length - 1) {
                sucursal.getVentas()[posVenta].setValor(valor);

            } else {
                throw new EspacioException();
            }
        } else {
            throw new NullPointerException("Debe selleccionar una sucursal");
        }

        return true;
        
    }
        */
}
