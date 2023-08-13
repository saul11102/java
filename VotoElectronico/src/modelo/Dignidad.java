/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Kevin
 */


public class Dignidad {
    private Integer id;
    private Integer nro;
    public Integer estado;
    private String nombre;
    private String vigencia;

    public Dignidad() {
    }

    public Dignidad(Integer id, Integer nro, Integer estado, String nombre, String vigencia) {
        this.id = id;
        this.nro = nro;
        this.estado = estado;
        this.nombre = nombre;
        this.vigencia = vigencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    
}
