/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import Controlador.DAO.RolDao;
import Controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Persona;
import modelo.Rol;

/**
 *
 * @author Juan_fer
 */
public class ModeloTablaPersona extends AbstractTableModel{
    private ListaEnlazada<Persona> lista = new ListaEnlazada<>();
    
    public ListaEnlazada<Persona> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Persona> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona p = null;
        Rol r = null;
        try {
            p = lista.get(i);
            r = new RolDao().obtener(p.getId_Rol());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (i1) {
            case 0:
                return (p != null) ? p.getCedula() : "No definido";
            case 1:
                return (p != null) ? p.getApellido() : "No definido";
            case 2:
                return (p != null) ? p.getNombre() : "No definido";
            case 3:
                return (p != null) ? p.getDireccion() : "No definido";
            case 4:
                return (p != null) ? p.getCorreoElectronico() : "No definido";
            case 5:
                return (p != null) ? p.getNumeroTelefono() : "No definido";
            case 6:
                return (p != null) ? p.getEstado() : "No definido";
            case 7:
                return (p != null) ? r.getNombre() : "No definido";
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Cédula";
            case 1:
                return "Apellido";
            case 2:
                return "Nombre";
            case 3:
                return "Dirección";
            case 4:
                return "Correo Electrónico";
            case 5:
                return "Teléfono";
            case 6:
                return "Estado Votación";
            case 7:
                return "Rol";
            default:
                return null;
        }
    }
    
}
