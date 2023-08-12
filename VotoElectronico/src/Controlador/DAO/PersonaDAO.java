/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.DAO.AdaptadorDAO;
import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Persona;

/**
 *
 * @author Juan_fer
 */
public class PersonaDAO extends AdaptadorDAO<Persona>{
    private Persona persona;

    public PersonaDAO() {
        super(Persona.class);
    }

    public Persona getPersona() {
        if (this.persona == null) {
            this.persona = new Persona();
        }
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void guardar() throws IOException {
        persona.setId(generarId());
        this.guardar(persona);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(persona, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
    public Persona buscarPorCedula(String dato) throws Exception {
        Persona resultado = null;
        ListaEnlazada<Persona> lista = listar();
        for (int i = 0; i <= lista.size(); i++) {
            Persona aux = lista.get(i);
            if (aux.getCedula().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }   
    
    public Persona buscarPorId(Integer dato) throws Exception {
        Persona resultado = null;
        ListaEnlazada<Persona> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Persona aux = lista.get(i);
            if (aux.getId().intValue() == dato.intValue()) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
}
