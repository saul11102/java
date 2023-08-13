/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Historial;

/**
 *
 * @author Juan_fer
 */
public class HistorialDAO extends AdaptadorDAOBDD<Historial> {

    private Historial historial;

    public HistorialDAO() {
        super(Historial.class);
    }

    public Historial getHistorial() {
        if (this.historial == null) {
            this.historial = new Historial();
        }
        return historial;
    }

    
    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    /**
     * guarda un historial dentro de la base
     * @throws IOException
     * @throws Exception 
     */
    public void guardar() throws IOException, Exception {
        this.guardar(historial);
    }

    /**
     * modifica un historial dentro de la base
     * @param pos
     * @throws Exception 
     */
    public void modificar(Integer pos) throws Exception {
        if (historial == null || historial.getId() == null) {
            throw new IllegalArgumentException("El historial no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Historial> lista = listar();


        Historial aux = lista.get(pos);
        

        this.modificar(aux);
    }

}
