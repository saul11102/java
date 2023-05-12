/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.ed.lista;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;

/**
 *
 * @author alejandro
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size = 0;

    /**
     * @return the cabecera
     */
    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    /**
     * @param cabecera the cabecera to set
     */
    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * Método que devuelve un true si la lista enlazada está vacia y un false si
     * la lista contiene datos
     */
    public boolean isEmpty() {
        return cabecera == null;
    }

    /**
     * Método que devuelve el tamaño de la lista contada desde 0
     *
     * @return
     */
    private Integer size() {
        return size;
    }

    /**
     * Método que me permite insertar un nuevo nodo al final de la lista
     *
     * @param info objeto de la clase NodoLista
     */
    public void insertar(E info) {
        NodoLista<E> nuevo = new NodoLista<>(info, null);
        if (isEmpty()) {
            this.cabecera = null;
            this.size++;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
        }
    }

    /**
     * Método que inserta un nuevo nodo en la cabecera
     *
     * @param info objeto de la clase NodoLista
     */
    public void insertarInicio(E info) {
        if (isEmpty()) {
            insertar(info);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            this.size++;
        }
    }

    /**
     * Método que permite ingresar un nuevo desde una posición específica
     *
     * @param info objeto de la clase NodoLista
     * @param pos número entero que me indica la posición donde deseo ingresar
     * el nodo
     * @throws Controlador.ed.lista.Exception.PosicionException
     */
    public void insertarPosicion(E info, Integer pos) throws PosicionException {
        if (isEmpty()) {
            insertar(info);
        } else if (pos == 0) {
            insertarInicio(info);
        } else if (pos > 0 && pos < size()) {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < pos - 1; i++) {
                aux = aux.getSig();
            }
            NodoLista<E> sig = aux.getSig();
            aux.setSig(nuevo);
            nuevo.setSig(sig);
            this.size++;
        } else {
            throw new PosicionException();
        }
    }

    /**
     * método para eliminar un nodo de una posición arbitraria
     *
     * @param pos número entero que me indica la posición del nodo que deseo
     * eliminar
     * @throws PosicionException
     * @throws VacioException retorna la información borrada
     */
    public E delete(Integer pos) throws PosicionException, VacioException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                    cabecera = cabecera.getSig();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos - 1); i++) {
                        aux = aux.getSig();
                    }
                    //if (pos + 1 == size) {
                    NodoLista<E> aux1 = aux.getSig();
                    dato = aux1.getInfo();
                    //} else {
                    //dato = aux.getInfo();
                    //}
                    NodoLista<E> proximo = aux.getSig();
                    aux.setSig(proximo.getSig());
                    size--;
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }
    
    /**
     * método que obtiene la información del nodo especificando el índice
     * @param pos posición del nodo del cual se desea obtener el dato 
     * @return la información del nodo
     * @throws VacioException
     * @throws PosicionException 
     */
    public E get(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos - 1); i++) {
                        aux = aux.getSig();
                    }
                }
                }else{
                throw new VacioException();
            }
                return dato;
            }
        }
    
    /**
     * método para borrar toda la lista
     */
    public void deleteAll() {
        this.cabecera = null;
    }
    
    /**
     * método para imprimir la información de la lista
     * @throws VacioException 
     */
    public void imprimir() throws VacioException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            NodoLista<E> aux = cabecera;
            System.out.println("-----LISTA-----");
            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo() + "   ");
                aux = aux.getSig();
            }
            System.out.println("-----LISTA FIN-----");
        }
    }
}
