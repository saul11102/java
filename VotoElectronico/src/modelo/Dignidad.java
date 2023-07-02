/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
/**
 *
 * @author Kevin
 */


public class Dignidad {
    private Integer id;
    private String nombre;
    private Integer candidato_Id;

    public Dignidad() {
    }
    

    public Dignidad(Integer id, String nombre, Integer candidato_Id) {
        this.id = id;
        this.nombre = nombre;
        this.candidato_Id = candidato_Id;
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

    public Integer getCandidato_Id() {
        return candidato_Id;
    }

    public void setCandidato_Id(Integer candidato_Id) {
        this.candidato_Id = candidato_Id;
    }
    
}
