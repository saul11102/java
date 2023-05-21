/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.DAO.Conexion.Conexion;
import Controlador.DAO.InterfazDAO.InterfazDAOCola;
import Controlador.ed.Cola.Cola;
import Controlador.ed.Pila.Exception.TopeException;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Modelo.Reclamo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author alejandro
 */
public class AdaptadorDAOReclamo<E> implements InterfazDAOCola<E> {
    private int tope = 10;
    private Conexion conexion;
    private Class clazz;
    private String url;
    private long horaBorraReclamos = 3600;

    public AdaptadorDAOReclamo(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    @Override
    public void queue(E obj) throws IOException, TopeException {
        Cola<E> cola = listar();
        cola.queue(obj);
        conexion.getXstream().alias(cola.getClass().getName(), Cola.class);
        conexion.getXstream().toXML(cola, new FileWriter(url));
    }

    @Override
    public Cola<E> listar() {
        Cola<E> cola = new Cola<>(tope);
        try {
            cola = (Cola<E>) conexion.getXstream().fromXML(new File(url));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return cola;
    }

    @Override
    public void dequeue() throws VacioException {
        Cola<E> cola = listar();
        try {
            cola.dequeue();
            conexion.getXstream().alias(cola.getClass().getName(), Cola.class);
            conexion.getXstream().toXML(cola, new FileWriter(url));
        } catch (PosicionException | IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

    @Override
    public E obtener(Integer id) {
        Cola<E> cola = listar();
        return (E) cola;
    }

    public void eliminarReclamosAntiguos() throws PosicionException, VacioException, TopeException, IOException {
        Cola<Reclamo> colaReclamo = (Cola<Reclamo>) listar();
        Date fechaActual = new Date();
        Cola<Reclamo> nuevaColaReclamo = new Cola<>(tope);
        while (!colaReclamo.getCola().isFull()) {
            Reclamo reclamo = colaReclamo.dequeue();
            long diferenciaTiempo = fechaActual.getTime() - reclamo.getFecha().getTime();

            if (diferenciaTiempo < horaBorraReclamos) {
                nuevaColaReclamo.queue(reclamo);
            }
        }
        guardarCola((Cola<E>) nuevaColaReclamo);
    }
    
    @Override
    public void guardarCola(Cola<E> cola) throws IOException {
        conexion.getXstream().alias(cola.getClass().getName(), Cola.class);
        conexion.getXstream().toXML(cola, new FileWriter(url));
    }
}
