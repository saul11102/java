/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador.DAO.InterfazDAO;

import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;

/**
 *
 * @author alejandro
 */
public interface InterfazDAO <T>{
    /**
     * permite guardar una lista enlazada hacia el el repositorio de datos 
     * @param obj
     * @throws IOException 
     */
    public void guardar (T obj) throws IOException;
    /**
     * permite modificar los datos en un repositorio de datos
     * @param obj
     * @param pos 
     */
    public void modificar (T obj, Integer pos);
    /**
     * permite listar los datos del repositorio de datos
     * @return 
     */
    public ListaEnlazada<T> listar ();
    /**
     * permite obtener los datos del repositorio de datos
     * @param id
     * @return 
     */
    public T obtener(Integer id);
}
