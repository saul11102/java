/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Controlador.ed.lista.ListaEnlazada;
import java.util.Date;


/**
 *
 * @author caim2
 */
public class Papeleta {
    private Integer id;
    private String numeroPapeleta;
    private String fechaEmision;
    private Integer id_Persona;
    private Integer id_Eleccion;

    public Papeleta() {
    }

    public Papeleta(Integer id, String numeroPapeleta, String fechaEmision, Integer id_Persona, Integer id_Eleccion) {
        this.id = id;
        this.numeroPapeleta = numeroPapeleta;
        this.fechaEmision = fechaEmision;
        this.id_Persona = id_Persona;
        this.id_Eleccion = id_Eleccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroPapeleta() {
        return numeroPapeleta;
    }

    public void setNumeroPapeleta(String numeroPapeleta) {
        this.numeroPapeleta = numeroPapeleta;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Integer getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Integer id_Persona) {
        this.id_Persona = id_Persona;
    }

    public Integer getId_Eleccion() {
        return id_Eleccion;
    }

    public void setId_Eleccion(Integer id_Eleccion) {
        this.id_Eleccion = id_Eleccion;
    }
    
}
