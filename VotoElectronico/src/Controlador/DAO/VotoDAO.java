/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import java.util.ArrayList;
import java.util.List;
import modelo.Voto;

/**
 *
 * @author jostin
 */
public class VotoDAO {

    private ListaEnlazada<Voto> listaVotos;

    public VotoDAO() {
        listaVotos = new ListaEnlazada<>();
    }

    public void insertarVoto(Voto voto) {
        listaVotos.insertarNodo(voto);
    }

    public List<Voto> obtenerVotosPorEleccion(int eleccionId) throws VacioException {
        List<Voto> votosEleccion = new ArrayList<>();

        for (int i = 1; i <= listaVotos.size(); i++) {
            try {
                Voto voto = listaVotos.get(i);
                if (voto.getEleccionId().equals(eleccionId)) {
                    votosEleccion.add(voto);
                }
            } catch (PosicionException e) {

                e.printStackTrace();
            }
        }

        return votosEleccion;
    }

    public List<Voto> obtenerVotosPorVotante(int votanteId) throws VacioException {
        List<Voto> votosVotante = new ArrayList<>();

        for (int i = 1; i <= listaVotos.size(); i++) {
            try {
                Voto voto = listaVotos.get(i);
                if (voto.getVotanteId().equals(votanteId)) {
                    votosVotante.add(voto);
                }
            } catch (PosicionException e) {
                e.printStackTrace();
            }
        }

        return votosVotante;
    }

    public List<Voto> obtenerVotosPorCandidato(int candidatoId) throws VacioException {
        List<Voto> votosCandidato = new ArrayList<>();

        for (int i = 1; i <= listaVotos.size(); i++) {
            try {
                Voto voto = listaVotos.get(i);
                if (voto.getCandidatoId().equals(candidatoId)) {
                    votosCandidato.add(voto);
                }
            } catch (PosicionException e) {
                e.printStackTrace();
            }
        }

        return votosCandidato;
    }

    public void eliminarVotosPorEleccion(int eleccionId) throws VacioException, PosicionException {
        List<Voto> votosAEliminar = new ArrayList<>();

        for (int i = 1; i <= listaVotos.size(); i++) {
            try {
                Voto voto = listaVotos.get(i);
                if (voto.getEleccionId().equals(eleccionId)) {
                    votosAEliminar.add(voto);
                }
            } catch (PosicionException e) {
                e.printStackTrace();
            }
        }

        for (Voto voto : votosAEliminar) {
            listaVotos.delete(listaVotos.getIndex(voto));
        }
    }

    public int obtenerTotalVotosPorEleccion(int eleccionId) throws VacioException {
        int totalVotos = 0;

        for (int i = 1; i <= listaVotos.size(); i++) {
            try {
                Voto voto = listaVotos.get(i);
                if (voto.getEleccionId().equals(eleccionId)) {
                    totalVotos++;
                }
            } catch (PosicionException e) {
                e.printStackTrace();
            }
        }

        return totalVotos;
    }

    public Voto obtenerVotoPorId(int votoId) throws VacioException {
        for (int i = 1; i <= listaVotos.size(); i++) {
            try {
                Voto voto = listaVotos.get(i);
                if (voto.getId().equals(votoId)) {
                    return voto;
                }
            } catch (PosicionException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
