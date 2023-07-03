/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador.DAO.InterfazDAO;

import Controlador.ed.lista.Exception.TopeException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.pila.Pila;
import java.io.IOException;

/**
 *
 * @author Juan_fer
 */
public interface InterfazDAOPila<E> {

    /**
     * permite guardar una lista enlazada hacia el el repositorio de datos
     *
     * @param obj
     * @throws IOException
     */
    public void push(E obj) throws IOException, TopeException;

    /**
     * permite listar los datos del repositorio de datos
     *
     * @return
     */
    public Pila<E> listar();

    /**
     * permite obtener los datos del repositorio de datos
     *
     * @param id
     * @return
     */
    public E obtener(Integer id);
    /**
     * elimina el primer elemento de la pila hacia el repositorio de datos
     * @throws VacioException 
     */
    public void pop() throws VacioException;
    /**
     * elimina el último elemento de lampila hacia el repositorio de datos
     * @throws VacioException 
     */
    public void eliminarPrimero() throws VacioException;
    
}
