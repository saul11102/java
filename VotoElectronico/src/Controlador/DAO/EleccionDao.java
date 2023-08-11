/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import modelo.Eleccion;

/**
 *
 * @author jostin
 */
public class EleccionDao extends AdaptadorDAO<Eleccion> {
    private Eleccion eleccion;
    
    public EleccionDao() {
        super(Eleccion.class);
    }
    
    
    
    
    public Eleccion buscarPorNombres(String dato) throws Exception{
        Eleccion resultado = null;
        ListaEnlazada<Eleccion> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Eleccion aux = lista.get(i);
            if (aux.getNombre().toLowerCase().equals(dato.toLowerCase())){
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
    
    public Eleccion obtenerEleccionActiva() throws VacioException, PosicionException{
        ListaEnlazada<Eleccion> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Eleccion aux = lista.get(i);
            if (aux.getEstado()) {
                return aux;
            }
        }
        return null;
    }
}
