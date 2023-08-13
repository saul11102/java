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

    /**
     * guarda dentro de la base de datos a la elección
     *
     * @throws IOException
     * @throws Exception
     */
    public void guardar() throws IOException, Exception {
        this.guardar(eleccion);
    }

    /**
     * modifica la elección dentro de la base
     *
     * @param pos posición de la elección
     * @throws Exception
     */
    public void modificar(Integer pos) throws Exception {
        if (eleccion == null || eleccion.getId() == null) {
            throw new IllegalArgumentException("La elección no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Eleccion> lista = listar();

        Eleccion aux = lista.get(pos);

        this.modificar(aux);
    }

    /**
     * busca una elección de acuerdo a su nombre
     *
     * @param dato nombre de la elección
     * @return
     * @throws Exception
     */
    public Eleccion buscarPorNombres(String dato) throws Exception {
        Eleccion resultado = null;
        ListaEnlazada<Eleccion> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Eleccion aux = lista.get(i);
            if (aux.getNombre().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

    /**
     * Obtiene la elección activa de la base de datos
     *
     * @return eleccion activa
     * @throws VacioException
     * @throws PosicionException
     */
    public Eleccion obtenerEleccionActiva() throws VacioException, PosicionException {
        ListaEnlazada<Eleccion> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Eleccion aux = lista.get(i);
            if (aux.getEstado() == 1) {
                return aux;
            }
        }
        return null;
    }
}
