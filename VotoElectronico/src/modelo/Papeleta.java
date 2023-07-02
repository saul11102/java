/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Controlador.ed.lista.ListaEnlazada;


/**
 *
 * @author alejandro
 */
public class Papeleta {
    private Integer id;
    private String informacion;
    private ListaEnlazada <Dignidad> dignidades;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public ListaEnlazada<Dignidad> getDignidades() {
        return dignidades;
    }

    public void setDignidades(ListaEnlazada<Dignidad> dignidades) {
        this.dignidades = dignidades;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "id=" + id + ", informacion='" + informacion + '}';
    }
    
    
    
    
    
}
