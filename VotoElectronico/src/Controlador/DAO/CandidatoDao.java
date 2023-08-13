/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Candidato;

/**
 *
 * @author alejandro
 */
public class CandidatoDao extends AdaptadorDAOBDD<Candidato> {

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

    public void guardar() throws IOException, Exception {
        this.guardar(candidato);
    }

    public void modificar(Integer pos) throws Exception {
        if (candidato == null || candidato.getId() == null) {
            throw new IllegalArgumentException("El partido político no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Candidato> lista = listar();

        if (pos < 0 || pos >= lista.size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }

        Candidato aux = lista.get(pos);
        
        

        this.modificar(aux);
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

    public ListaEnlazada<Candidato> buscarPorDignidad(Integer id_dignidad) throws VacioException, PosicionException {
        ListaEnlazada<Candidato> lista = new ListaEnlazada<>();
        ListaEnlazada<Candidato> listado = listar();
        for (int i = 0; i < listado.size(); i++) {
            Candidato aux = listado.get(i);
            if (aux.getId_Dignidad().intValue() == id_dignidad.intValue()) {
                lista.insertarNodo(aux);
            }
        }
        return lista;
    }

    public ListaEnlazada<Candidato> buscarPorDignidadPartido(Integer id_Dignidad, Integer id_partidoPolitico) throws VacioException, PosicionException {
        ListaEnlazada<Candidato> lista = new ListaEnlazada<>();
        ListaEnlazada<Candidato> listado = listar();
        for (int i = 0; i < listado.size(); i++) {
            Candidato aux = listado.get(i);
            if (aux.getId_Dignidad().intValue() == id_Dignidad.intValue() && aux.getId_PartidoPolitico().intValue() == id_partidoPolitico.intValue()) {
                lista.insertarNodo(aux);
            }
        }
        return lista;
    }
}
