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

    /**
     * guarda dentro de la base al candidato
     *
     * @throws IOException
     * @throws Exception
     */
    public void guardar() throws IOException, Exception {
        this.guardar(candidato);
    }

    /**
     * Modifica un candidato dentro de la base de datos
     *
     * @param pos
     * @throws Exception
     */
    public void modificar(Integer pos) throws Exception {
        if (candidato == null || candidato.getId() == null) {
            throw new IllegalArgumentException("El candidato no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Candidato> lista = listar();

        Candidato aux = lista.get(pos);

        this.modificar(aux);
    }

    /**
     * Busca un candidato por su id
     *
     * @param dato
     * @return
     * @throws Exception
     */
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

    /**
     * busca un candidato de acuerdo a la dignidad que pertenece
     *
     * @param id_dignidad
     * @return
     * @throws VacioException
     * @throws PosicionException
     */
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

    /**
     * Busca un candidato de acuerdo a su dignidad y partido político al que
     * pertenece
     *
     * @param id_Dignidad
     * @param id_partidoPolitico
     * @return
     * @throws VacioException
     * @throws PosicionException
     */
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
