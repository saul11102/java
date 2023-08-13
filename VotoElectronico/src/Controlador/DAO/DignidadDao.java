/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Dignidad;

/**
 *
 * @author Kevin
 */
public class DignidadDao extends AdaptadorDAOBDD<Dignidad> {

    private Dignidad dignidad;

    public DignidadDao() {
        super(Dignidad.class);
    }

    public Dignidad getDignidad() {
        if (this.dignidad == null) {
            this.dignidad = new Dignidad();
        }
        return dignidad;
    }

    public void setDignidad(Dignidad dignidad) {
        this.dignidad = dignidad;
    }

    /**
     * guarda dentro de la base a la dignidad
     * @throws IOException
     * @throws Exception 
     */
    public void guardar() throws IOException, Exception {
        this.guardar(dignidad);
    }

    /**
     * modifica una dignidad dentro de la base
     * @param pos
     * @throws Exception 
     */
    public void modificar(Integer pos) throws Exception {
        if (dignidad == null || dignidad.getId() == null) {
            throw new IllegalArgumentException("La dignidad no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Dignidad> lista = listar();

        Dignidad aux = lista.get(pos);
        

        this.modificar(aux);
    }

    /**
     * busca una dignidad de acuerdo a su nombre
     * @param dato nombre de la dignidad
     * @return
     * @throws Exception 
     */
    public Dignidad buscarPorNombres(String dato) throws Exception{
        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Dignidad aux = lista.get(i);
            if (aux.getNombre().toLowerCase().equals(dato.toLowerCase())){
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
}