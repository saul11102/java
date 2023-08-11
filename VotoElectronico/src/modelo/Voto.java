/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author alejandro
 */
public class Voto {
    private Integer id;
    private TipoVoto tipo;
    private String voto;
    private Integer id_Seleccion;
    private Integer dignidad;

    public Voto() {
    }

    public Voto(Integer id, TipoVoto tipo, String voto, Integer id_Seleccion, Integer dignidad) {
        this.id = id;
        this.tipo = tipo;
        this.voto = voto;
        this.id_Seleccion = id_Seleccion;
        this.dignidad = dignidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoVoto getTipo() {
        return tipo;
    }

    public void setTipo(TipoVoto tipo) {
        this.tipo = tipo;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public Integer getId_Seleccion() {
        return id_Seleccion;
    }

    public void setId_Seleccion(Integer id_Seleccion) {
        this.id_Seleccion = id_Seleccion;
    }

    public Integer getDignidad() {
        return dignidad;
    }

    public void setDignidad(Integer dignidad) {
        this.dignidad = dignidad;
    }
    

    
}