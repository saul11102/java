/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Controlador.ed.lista.ListaEnlazada;
import java.util.Date;

/**
 *
 * @author juanfer
 */
public class Historial {

  private Voto voto;
    private Date fecha;

    public Historial() {
    }

    public Historial(Voto voto, Date fecha) {
        this.voto = voto;
        this.fecha = fecha;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the voto
     */
    public Voto getVoto() {
        return voto;
    }

    /**
     * @param voto the voto to set
     */
    public void setVoto(Voto voto) {
        this.voto = voto;
    }

}

