/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Eleccion;

/**
 *
 * @author alejandro
 */
public class EleccionDao extends AdaptadorDAOBDD<Eleccion> {

    private Eleccion eleccion;

    public EleccionDao() {
        super(Eleccion.class);
    }

    public Eleccion getEleccion() {
        if (this.eleccion == null) {
            this.eleccion = new Eleccion();
        }
        return eleccion;
    }

    public void setEleccion(Eleccion eleccion) {
        this.eleccion = eleccion;
    }

    public void guardar() throws IOException, Exception {
        this.guardar(eleccion);
    }

    public void modificar(Integer pos) throws Exception {
        if (eleccion == null || eleccion.getId() == null) {
            throw new IllegalArgumentException("El partido político no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Eleccion> lista = listar();

        if (pos < 0 || pos >= lista.size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }

        Eleccion aux = lista.get(pos);
        

        this.modificar(aux);
    }

    private Integer generateID() {
        return listar().size() + 1;
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
            if (aux.getEstado() ==  1) {
                return aux;
            }
        }
        return null;
    }
}


