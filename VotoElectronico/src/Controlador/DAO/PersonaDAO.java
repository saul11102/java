/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Persona;

/**
 *
 * @author Juan_fer
 */
public class PersonaDAO extends AdaptadorDAOBDD<Persona>{
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

    public void guardar() throws IOException, Exception {
        this.guardar(persona);
    }

    public void modificar(Integer pos) throws Exception {
        if (persona == null || persona.getId() == null) {
            throw new IllegalArgumentException("El partido político no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Persona> lista = listar();



        Persona aux = this.buscarPorId(pos);
      
        aux.setEstado(1);
        

        this.modificar(aux);
    }

    public Persona buscarPorCedula(String dato) throws Exception {
        Persona resultado = null;
        ListaEnlazada<Persona> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Persona aux = lista.get(i);
            if (aux.getCedula().equalsIgnoreCase(dato)) {
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
