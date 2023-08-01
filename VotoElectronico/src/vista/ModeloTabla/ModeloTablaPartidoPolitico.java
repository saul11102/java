/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import Controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.PartidoPolitico;

/**
 *
 * @author Kevin
 */
public class ModeloTablaPartidoPolitico extends AbstractTableModel{
    private ListaEnlazada<PartidoPolitico> lista = new ListaEnlazada<>();
    
    public ListaEnlazada<PartidoPolitico> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<PartidoPolitico> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        PartidoPolitico p = null;
        try {
            p = lista.get(i);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (i1) {
            case 0:
                return (p != null) ? p.getNombre() : "No definido";
            case 1:
                return (p != null) ? p.getSlogan() : "No definido";
            case 2:
                return (p != null) ? p.getFoto() : "No definido";
            case 3:
                return (p != null) ? p.getSiglas() : "No definido";
            case 4:
                return (p != null) ? p.getLider() : "No definido";
            case 5:
                return (p != null) ? p.getSede() : "No definido";
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
                return "Slogan";
            case 2:
                return "Foto";
            case 3:
                return "Siglas";
            case 4:
                return "Lider";
            case 5:
                return "Sede";
            default:
                return null;
        }
    }  
}