/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import Controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Cuenta;
import modelo.Persona;

/**
 *
 * @author santiago
 */
public class ModeloTablaCuenta extends AbstractTableModel {

    ListaEnlazada<Cuenta> lista = new ListaEnlazada<>();

    public ListaEnlazada<Cuenta> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Cuenta> lista) {
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
        Cuenta c = null;
        Persona p = null;
        try {
            c = lista.get(i);
            p = new PersonaDAO().obtener(c.getId_Persona());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (i1) {
            case 0:
                return (c != null) ?  p.getCedula(): "No definido";
            case 1:
                return (p != null) ? c.getContrasena(): "No definido";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Cedula";
            case 1:
                return "Contraseña";
            default:
                return null;

        }

    }
}
