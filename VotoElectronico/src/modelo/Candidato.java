/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jostin
 */
public class Candidato {
    private Integer id;
    private String nombre;
    private Integer id_PartidoPolitico;
    private Integer id_Dignidad;

    public Candidato() {
    }

    public Candidato(Integer id, String nombre, Integer id_PartidoPolitico, Integer id_Dignidad) {
        this.id = id;
        this.nombre = nombre;
        this.id_PartidoPolitico = id_PartidoPolitico;
        this.id_Dignidad = id_Dignidad;
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

    public Integer getId_PartidoPolitico() {
        return id_PartidoPolitico;
    }

    public void setId_PartidoPolitico(Integer id_PartidoPolitico) {
        this.id_PartidoPolitico = id_PartidoPolitico;
    }

    public Integer getId_Dignidad() {
        return id_Dignidad;
    }

    public void setId_Dignidad(Integer id_Dignidad) {
        this.id_Dignidad = id_Dignidad;
    }

    
    
}
