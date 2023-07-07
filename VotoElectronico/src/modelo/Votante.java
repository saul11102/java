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
public class Votante extends Voto{
    
    private Boolean estadoVotacion;
    
    public Votante() {
    }

    public Votante(Boolean estadoVotacion) {
        this.estadoVotacion = estadoVotacion;
    }

    public Votante(Boolean estadoVotacion, Integer id, Integer votanteId, Integer candidatoId, Date fechaVoto, Integer eleccionId) {
        super(id, votanteId, candidatoId, fechaVoto, eleccionId);
        this.estadoVotacion = estadoVotacion;
    }

    

    public Boolean getEstadoVotacion() {
        return estadoVotacion;
    }

    public void setEstadoVotacion(Boolean estadoVotacion) {
        this.estadoVotacion = estadoVotacion;
    }
    
    
    
}
