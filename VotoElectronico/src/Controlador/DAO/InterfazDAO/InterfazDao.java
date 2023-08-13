/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controlador.DAO.InterfazDAO;

import Controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author saul_
 */
public interface InterfazDao<T> {
    /**
     * Metodo que permite realizar el guardaddo
     * @param obj Objeto del modelo
     * @return El id generado producto del guardado
     */
    public Integer guardar(T obj) throws Exception;
    /**
     * Permite modificar los datos en un repositorio de datos
     * @param obj Objeto a modificar     
     */
    public void modificar(T obj) throws Exception;
    /**
     * LIstado de objetos en la BD
     * @return Una ListaEnlazada
     */
    public ListaEnlazada<T> listar();
    public T obtener(Integer id);
}
