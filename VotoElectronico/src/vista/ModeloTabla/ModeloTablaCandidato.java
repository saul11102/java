/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.ModeloTabla;

import Controlador.DAO.DignidadDao;
import Controlador.DAO.PartidoPoliticoDao;
import Controlador.DAO.PersonaDAO;
import Controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Candidato;
import modelo.Dignidad;
import modelo.PartidoPolitico;
import modelo.Persona;

/**
 *
 * @author alejandro
 */
public class ModeloTablaCandidato extends AbstractTableModel {

    private ListaEnlazada<Candidato> lista = new ListaEnlazada<>();

    public ListaEnlazada<Candidato> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Candidato> lista) {
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
        Candidato c = null;
        Persona p = new Persona();
        PartidoPolitico pp = new PartidoPolitico();
        Dignidad d = new Dignidad();
        try {
            c = lista.get(i);
            p = new PersonaDAO().obtener(c.getId_Persona());
            pp = new PartidoPoliticoDao().obtener(c.getId_PartidoPolitico());
            d = new DignidadDao().obtener(c.getId_Dignidad());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        switch (i1) {
            case 0:
                return (c != null) ? p.getNombre() : "No definido";
            case 1:
                return (pp != null) ? p.getCedula() : "No definido";
            case 2:
                return (pp != null) ? pp.getNombre() : "No definido";
            case 3:
                return (d != null) ? d.getNombre() : "No definido";
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
                return "Cedula";
            case 2:
                return "Partido Político";
            case 3:
                return "Dignididad";
            default:
                return null;
        }
    }
}
