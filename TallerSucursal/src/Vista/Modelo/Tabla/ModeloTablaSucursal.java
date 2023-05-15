/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo.Tabla;

import Controlador.Util.Utilidades;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import Modelo.Sucursal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alejandro
 */
public class ModeloTablaSucursal extends AbstractTableModel {
    private ListaEnlazada<Sucursal> listaSucursal = new ListaEnlazada<>();
    private Integer columnas = 3;

    public ListaEnlazada<Sucursal> getListaSucursal() {
        return listaSucursal;
    }

    public void setListaSucursal(ListaEnlazada<Sucursal> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }

    @Override
    public int getRowCount() {
        return listaSucursal.size();    
    }

    @Override
    public int getColumnCount() {
        return columnas;
    }
    /**
     * Método para definir el valor de las filas
     * @param i
     * @param i1
     * @return 
     */
    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Sucursal s = listaSucursal.get(i);
            switch (i1) {
                case 0:
                    return (s != null) ? s.getNombre() : "No definido";
                case 1:
                    return (s != null) ? Utilidades.sumarVentas(s) : 0;
                case 2:
                    return (s != null) ? Utilidades.mediaVentas(s) : 0;
                default:
                    return null;
            }
        } catch (VacioException | PosicionException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    /**
     * método para definir el nombre de las columnas
     * @param column
     * @return 
     */
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Sucursal"; 
            case 1: return "Venta Anual";
            case 2: return "Venta promedio";
            default: return null;
        }
    }
}
