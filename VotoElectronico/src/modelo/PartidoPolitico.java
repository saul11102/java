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
    private String foto;
    private String siglas;
    private String lider;
    private String sede;
    private Integer nroLista;

    public PartidoPolitico() {
    }

    public PartidoPolitico(Integer id, String nombre, String slogan, String foto, String siglas, String lider, String sede, Integer nroLista) {
        this.id = id;
        this.nombre = nombre;
        this.slogan = slogan;
        this.foto = foto;
        this.siglas = siglas;
        this.lider = lider;
        this.sede = sede;
        this.nroLista = nroLista;
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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
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

    public Integer getNroLista() {
        return nroLista;
    }

    public void setNroLista(Integer nroLista) {
        this.nroLista = nroLista;
    }

    
    
}

