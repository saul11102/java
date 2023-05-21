/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador.DAO.InterfazDAO;

import Controlador.ed.Cola.Cola;
import Controlador.ed.Pila.Exception.TopeException;
import Controlador.ed.Pila.Pila;
import Controlador.ed.lista.Exception.VacioException;
import java.io.IOException;

/**
 *
 * @author alejandro
 */
public interface InterfazDAOCola<E> {

    /**
     * permite guardar una lista enlazada hacia el el repositorio de datos
     *
     * @param obj
     * @throws IOException
     */
    public void queue(E obj) throws IOException, TopeException;

    /**
     * permite listar los datos del repositorio de datos
     *
     * @return
     */
    public Cola<E> listar();

    /**
     * elimina el primer elemento de la pila hacia el repositorio de datos
     *
     * @throws VacioException
     */
    public void dequeue() throws VacioException;
    
    public E obtener(Integer id);
    
    public void guardarCola(Cola<E> cola) throws IOException;
}
