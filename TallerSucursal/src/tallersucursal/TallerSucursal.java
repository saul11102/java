/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallersucursal;

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
    public static void main(String[] args) throws VacioException {
        try {
            ListaEnlazada<Sucursal> listaSucursal = new ListaEnlazada<>();

            ListaEnlazada<Venta> listaVentas1 = new ListaEnlazada<>();
            Venta sucursal1venta1 = new Venta(1, 23.5, EnumMes.ENERO);
            Venta sucursal1venta2 = new Venta(2, 32.55, EnumMes.FEBRERO);
            listaVentas1.insertar(sucursal1venta1);
            listaVentas1.insertar(sucursal1venta2);

            Sucursal sucursal1 = new Sucursal(1, "Micromercado", listaVentas1);

            ListaEnlazada<Venta> listaVentas2 = new ListaEnlazada<>();
            Venta sucursal2venta1 = new Venta(1, 324.2, EnumMes.ENERO);
            Venta sucursal2venta2 = new Venta(2, 543.4, EnumMes.FEBRERO);
            listaVentas2.insertar(sucursal2venta1);
            listaVentas2.insertar(sucursal2venta2);

            Sucursal sucursal2 = new Sucursal(2, "Supermercado", listaVentas2);

            listaSucursal.insertar(sucursal1);
            listaSucursal.insertar(sucursal2);

            listaSucursal.imprimir();
        } catch (VacioException e) {
            System.err.println(e.getMessage());
        }

    }

}
