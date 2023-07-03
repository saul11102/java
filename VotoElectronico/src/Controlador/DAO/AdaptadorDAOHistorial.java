/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.DAO.Conexion.Conexion;
import Controlador.DAO.InterfazDAO.InterfazDAOPila;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.TopeException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.pila.Pila;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Juan_fer
 */
public class AdaptadorDAOHistorial<E> implements InterfazDAOPila<E> {

    private Conexion conexion;
    private Class clazz;
    private String url;

    public AdaptadorDAOHistorial(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    @Override
    public void push(E obj) throws IOException, TopeException {
            Pila<E> pila = listar();
            pila.push(obj);
            conexion.getXstream().alias(pila.getClass().getName(), Pila.class);
            conexion.getXstream().toXML(pila, new FileWriter(url));
    }

    @Override
    public void pop() throws VacioException {
        Pila<E> pila = listar();
        try {
            pila.pop();
            conexion.getXstream().alias(pila.getClass().getName(), Pila.class);
            conexion.getXstream().toXML(pila, new FileWriter(url));
        } catch (PosicionException | IOException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

    @Override
    public Pila<E> listar() {
        Pila<E> pila = new Pila<>(20);
        try {
            pila = (Pila<E>) conexion.getXstream().fromXML(new File(url));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return pila;
    }

    @Override
    public E obtener(Integer id) {
        Pila<E> pila = listar();
        return (E) pila;
    }

    @Override
    public void eliminarPrimero() throws VacioException{
        Pila<E> pila = listar();
        try {
            Pila<E> tempPila = new Pila<>(20); 
            
            while (!pila.getPilaI().isEmpty()) {
                tempPila.push(pila.pop());
            }

            tempPila.pop();

            while (!tempPila.getPilaI().isEmpty()){
                pila.push(tempPila.pop());
            }

            conexion.getXstream().alias(pila.getClass().getName(), Pila.class);
            conexion.getXstream().toXML(pila, new FileWriter(url));
        } catch (VacioException | IOException | TopeException | PosicionException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }

}
