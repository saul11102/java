/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author Kevin
 */
public class PartidoPolitico {
    private Integer id;
    private String nombre;
    private String slogan;
    private String lider;
    private String sede;
    private ListaEnlazada<Candidato> candidatos;

    public PartidoPolitico() {
    }
    
    
    

    public PartidoPolitico(Integer id, String nombre, String slogan, String lider, String sede) {
        this.id = id;
        this.nombre = nombre;
        this.slogan = slogan;
        this.lider = lider;
        this.sede = sede;
        this.candidatos = new ListaEnlazada<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public ListaEnlazada<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ListaEnlazada<Candidato> candidatos) {
        this.candidatos = candidatos;
    }
    

    public void agregarCandidato(Candidato candidato) {
        candidatos.insertarNodo(candidato);
    }

    public void eliminarCandidato(Candidato candidato) {
    int index = candidatos.getIndex(candidato);
    if (index != -1) {
        try {
            candidatos.delete(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}
