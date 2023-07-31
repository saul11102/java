/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Candidato;

/**
 *
 * @author alejandro
 */
public class CandidatoDao extends AdaptadorDAO<Candidato> {

    private Candidato candidato;

    public CandidatoDao() {
        super(Candidato.class);
    }

    public Candidato getCandidato() {
        if (this.candidato == null) {
            this.candidato = new Candidato();
        }
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public void guardar() throws IOException {
        candidato.setId(generarId());
        this.guardar(candidato);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(candidato, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
    public Candidato buscarPorId(Integer dato) throws Exception {
        Candidato resultado = null;
        ListaEnlazada<Candidato> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Candidato aux = lista.get(i);
            if (aux.getId().intValue() == dato.intValue()) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
}
