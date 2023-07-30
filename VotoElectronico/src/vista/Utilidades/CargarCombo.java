/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import Controlador.DAO.DignidadDao;
import Controlador.DAO.PartidoPoliticoDao;
import Controlador.DAO.PersonaDAO;
import Controlador.DAO.RolDao;
import Controlador.ed.lista.ListaEnlazada;
import javax.swing.JComboBox;
import modelo.Dignidad;
import modelo.PartidoPolitico;
import modelo.Persona;
import modelo.Rol;

/**
 *
 * @author alejandro
 */
public class CargarCombo {
    public static void cargarPartidoPolitico(JComboBox cbx, PartidoPoliticoDao ppd) throws Exception {
        cbx.removeAllItems();
        ListaEnlazada<PartidoPolitico> lista = ppd.listar();
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.get(i).getNombre());
        }
    }
    
    public static void cargarDignidad(JComboBox cbx, DignidadDao ppd) throws Exception{
        cbx.removeAllItems();
        ListaEnlazada<Dignidad> lista = ppd.listar();
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.get(i).getNombre());
        }
    }
    
    public static void cargarRol(JComboBox cbx, RolDao rd) throws Exception{
        cbx.removeAllItems();
        ListaEnlazada<Rol> lista = rd.listar();
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.get(i).getNombre());
        }
    }
    
    public static void cargarPersona(JComboBox cbx, PersonaDAO rd) throws Exception{
        cbx.removeAllItems();
        ListaEnlazada<Persona> lista = rd.listar();
        for (int i = 0; i < lista.size(); i++) {
            cbx.addItem(lista.get(i).getCedula());
        }
    }
}
