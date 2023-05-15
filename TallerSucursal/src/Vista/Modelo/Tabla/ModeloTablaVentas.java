/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista.Modelo.Tabla;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import Modelo.EnumMes;
import Modelo.Venta;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alejandro
 */
public class ModeloTablaVentas extends AbstractTableModel{
    ListaEnlazada<Venta> listaVentas = new ListaEnlazada<>();
    private int columnas = 2;
    private int meses = 12;

    public ListaEnlazada<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(ListaEnlazada<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
    
    @Override
    public int getRowCount() {
        return meses;
    }

    @Override
    public int getColumnCount() {
        return columnas;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        try {
            Venta s = listaVentas.get(i); 
            switch(i1){
            case 0: return (s != null) ? s.getMes() : "No definido";
            case 1: return (s != null) ? s.getValor() : 0.0;
            default: return null;
        }
        } catch (PosicionException | VacioException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "Mes"; 
            case 1: return "Venta Anual";
            default: return null;
        }
    }  
}
