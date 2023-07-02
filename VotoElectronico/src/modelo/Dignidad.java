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
 * @author alejandro
 */


public class Dignidad {
    private int id;
    private String nombre;
    private ListaEnlazada<Candidato> candidatos;

    public Dignidad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.candidatos = new ListaEnlazada<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ListaEnlazada<Candidato> getCandidatos() {
        return candidatos;
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
