/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Controlador.DAO.PersonaDAO;

/**
 *
 * @author alejandro
 */
public class Candidato {
    private Integer id;
    private String foto;
    private Integer id_Persona;
    private Integer id_PartidoPolitico;
    private Integer id_Dignidad;

    public Candidato() {
    }

    public Candidato(Integer id, String foto, Integer id_Persona, Integer id_PartidoPolitico, Integer id_Dignidad) {
        this.id = id;
        this.foto = foto;
        this.id_Persona = id_Persona;
        this.id_PartidoPolitico = id_PartidoPolitico;
        this.id_Dignidad = id_Dignidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Integer id_Persona) {
        this.id_Persona = id_Persona;
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
