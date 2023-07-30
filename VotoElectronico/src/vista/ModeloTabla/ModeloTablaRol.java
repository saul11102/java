/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import Controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Rol;

/**
 *
 * @author jostin
 */
public class ModeloTablaRol extends AbstractTableModel {

    private ListaEnlazada<Rol> lista = new ListaEnlazada<>();

    public ListaEnlazada<Rol> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Rol> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Rol r = null;
        try {
            r = lista.get(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (i1) {
            case 0:
                return (r != null) ? r.getNombre() : "No definido";
            case 1:
                return (r != null) ? r.getDescripcion() : "No definido";
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
                return "Descripción";
            default:
                return null;
        }
    }

}
