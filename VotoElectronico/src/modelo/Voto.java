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
    private Integer id_tipoVoto;
    private String voto;
    private Integer id_Eleccion;
    private Integer dignidad;

    public Voto() {
    }

    public Voto(Integer id, Integer id_tipoVoto, String voto, Integer id_Eleccion, Integer dignidad) {
        this.id = id;
        this.id_tipoVoto = id_tipoVoto;
        this.voto = voto;
        this.id_Eleccion = id_Eleccion;
        this.dignidad = dignidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_tipoVoto() {
        return id_tipoVoto;
    }

    public void setId_tipoVoto(Integer id_tipoVoto) {
        this.id_tipoVoto = id_tipoVoto;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public Integer getId_Eleccion() {
        return id_Eleccion;
    }

    public void setId_Eleccion(Integer id_Eleccion) {
        this.id_Eleccion = id_Eleccion;
    }

    public Integer getDignidad() {
        return dignidad;
    }

    public void setDignidad(Integer dignidad) {
        this.dignidad = dignidad;
    }

    

    
}