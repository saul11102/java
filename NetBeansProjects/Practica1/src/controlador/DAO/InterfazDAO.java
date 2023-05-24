/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DAO;

import java.io.IOException;

/**
 *
 * @author jostin
 */
public interface InterfazDAO<T> {

    //Metodo que permite guardar
    public void guardar(T obj) throws IOException;

    //Permite modificar los datos en un repositorio de datos
    public void modificar(T obj, Integer pos);

    //Permite listar los elementos
    public T[] listar();

    //Permite obtener un elemento del arreglo
    //param id Posicion
    //return returna un dato
    public T obtener(Integer id);
}
