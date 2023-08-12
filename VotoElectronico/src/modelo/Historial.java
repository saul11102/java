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

    private Integer id;
    private Date fecha;
    private Integer id_Cuenta;

    public Historial() {
    }

    public Historial(Integer id, Date fecha, Integer id_Cuenta) {
        this.id = id;
        this.fecha = fecha;
        this.id_Cuenta = id_Cuenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId_Cuenta() {
        return id_Cuenta;
    }

    public void setId_Cuenta(Integer id_Cuenta) {
        this.id_Cuenta = id_Cuenta;
    }

}
