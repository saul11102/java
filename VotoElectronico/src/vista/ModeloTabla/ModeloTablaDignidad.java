/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import Controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Dignidad;

/**
 *
 * @author Kevin
 */
public class ModeloTablaDignidad extends AbstractTableModel {

    private ListaEnlazada<Dignidad> lista = new ListaEnlazada<>();

    public ListaEnlazada<Dignidad> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Dignidad> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Dignidad d = null;
        try {
            d = lista.get(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (i1) {
            case 0:
                return (d != null) ? d.getId() : "No definido";
            case 1:
                return (d != null) ? d.getNro() : "No definido";
            case 2:
                return (d != null) ? d.getEstado() : "No definido";
            case 3:
                return (d != null) ? d.getNombre() : "No definido";
            case 4:
                return (d != null) ? d.getVigencia() : "No definido";
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nro";
            case 2:
                return "Estado";
            case 3:
                return "Nombre";
            case 4:
                return "Vigencia";
            default:
                return null;
        }
    }
}
