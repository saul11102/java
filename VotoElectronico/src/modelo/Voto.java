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
    private Integer votanteId;
    private Integer candidatoId;
    private Date fechaVoto;
    private Integer eleccionId;

    public Voto() {
    }

    public Voto(Integer id, Integer votanteId, Integer candidatoId, Date fechaVoto, Integer eleccionId) {
        this.id = id;
        this.votanteId = votanteId;
        this.candidatoId = candidatoId;
        this.fechaVoto = fechaVoto;
        this.eleccionId = eleccionId;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVotanteId() {
        return votanteId;
    }

    public void setVotanteId(Integer votanteId) {
        this.votanteId = votanteId;
    }

    public Integer getCandidatoId() {
        return candidatoId;
    }

    public void setCandidatoId(Integer candidatoId) {
        this.candidatoId = candidatoId;
    }

    public Date getFechaVoto() {
        return fechaVoto;
    }

    public void setFechaVoto(Date fechaVoto) {
        this.fechaVoto = fechaVoto;
    }

    public Integer getEleccionId() {
        return eleccionId;
    }

    public void setEleccionId(Integer eleccionId) {
        this.eleccionId = eleccionId;
    }
    
}
