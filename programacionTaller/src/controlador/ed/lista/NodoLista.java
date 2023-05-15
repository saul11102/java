    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista;

/**
 *
 * @author alejandro
 */
public class NodoLista <E> {
    private E info;
    private NodoLista sig;

    public NodoLista() {
        info = null;
        sig = null;
    }

    public NodoLista(E info, NodoLista sig) {
        this.info = info;
        this.sig = sig;
    }
    
    /**
     * @return the info
     */
    public E getInfo() {
        return info;
    }

    /**
     * @param info the info to set
     */
    public void setInfo(E info) {
        this.info = info;
    }

    /**
     * @return the sig
     */
    public NodoLista getSig() {
        return sig;
    }

    /**
     * @param sig the sig to set
     */
    public void setSig(NodoLista sig) {
        this.sig = sig;
    }
    
    
}