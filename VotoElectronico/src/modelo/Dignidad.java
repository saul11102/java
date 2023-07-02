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
    private Integer Candidato_Id;
    private ListaEnlazada<Candidato> candidatos;

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
        return Candidato_Id;
    }

    public void setCandidato_Id(Integer Candidato_Id) {
        this.Candidato_Id = Candidato_Id;
    }

    public ListaEnlazada<Candidato> getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(ListaEnlazada<Candidato> candidatos) {
        this.candidatos = candidatos;
    }

    

    public void agregarCandidato(Candidato candidato) {
        candidatos.insertarNodo(candidato);
    }

    public void eliminarCandidato(Candidato candidato) {
        try {
            int index = candidatos.getIndex(candidato);
            if (index != -1) {
                candidatos.delete(index);
            }
        } catch (PosicionException | VacioException e) {
            e.printStackTrace();
        }
    }
}
