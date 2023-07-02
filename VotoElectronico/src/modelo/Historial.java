/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Controlador.ed.lista.ListaEnlazada;
import java.util.Date;

/**
 *
 * @author juanfer
 */
public class Historial {

    private Integer id;
    private ListaEnlazada<Persona> persona;
    private Date fechaVotacion;
    private ListaEnlazada<Eleccion> elecciones;
    private ListaEnlazada<Voto> votos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ListaEnlazada<Persona> getPersona() {
        return persona;
    }

    public void setPersona(ListaEnlazada<Persona> persona) {
        this.persona = persona;
    }

    public Date getFechaVotacion() {
        return fechaVotacion;
    }

    public void setFechaVotacion(Date fechaVotacion) {
        this.fechaVotacion = fechaVotacion;
    }

    public ListaEnlazada<Eleccion> getElecciones() {
        return elecciones;
    }

    public void setElecciones(ListaEnlazada<Eleccion> elecciones) {
        this.elecciones = elecciones;
    }

    public ListaEnlazada<Voto> getVotos() {
        return votos;
    }

    public void setVotos(ListaEnlazada<Voto> votos) {
        this.votos = votos;
    }
}
