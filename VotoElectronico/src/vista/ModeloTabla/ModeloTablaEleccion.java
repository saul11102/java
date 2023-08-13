/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Eleccion;

/**
 *
 * @author alejandro
 */
public class ModeloTablaEleccion extends AbstractTableModel {

    private ListaEnlazada<Eleccion> lista = new ListaEnlazada<>();

    public ListaEnlazada<Eleccion> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Eleccion> lista) {
        this.lista = lista;
    }

    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Eleccion e = null;
        
        try {
            e = lista.get(i);
        } catch (VacioException|PosicionException ex) {
            Logger.getLogger(ModeloTablaEleccion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        switch (i1) {
            case 0:
                return (e != null) ? e.getNombre() : "No definido";
            case 1:
                return (e != null) ? e.getFecha() : "No definido";
            case 2:
                return (e != null) ? e.getUbicacion() : "No definido";
            case 3:
                return (e != null) ? e.getEstado() : "No definido";
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nombre";
            case 1:
                return "Fecha";
            case 2:
                return "Dirección";
            case 3:
                return "Estado";
            default:
                return null;
        }
    }
}
