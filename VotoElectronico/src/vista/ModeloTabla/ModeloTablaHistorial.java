/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import Controlador.DAO.CuentaDAO;
import Controlador.DAO.PersonaDAO;
import Controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Cuenta;
import modelo.Historial;
import modelo.Persona;

/**
 *
 * @author Juan_fer
 */
public class ModeloTablaHistorial extends AbstractTableModel {

    private ListaEnlazada<Historial> lista = new ListaEnlazada<>();

    public ListaEnlazada<Historial> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Historial> lista) {
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
        Historial h = null;
        Cuenta c = null;
        Persona p = null;
        try {
            h = lista.get(i);
            c = new CuentaDAO().obtener(h.getId_Cuenta());
            p = new PersonaDAO().obtener(c.getId_Persona());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (i1) {
            case 0:
                return (h != null) ? h.getFecha() : "No definido";
            case 1:
                return (p != null) ? p.getCedula(): "No definido";
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Fecha";
            case 1:
                return "Cedula Persona";
            default:
                return null;
        }
    }

}
