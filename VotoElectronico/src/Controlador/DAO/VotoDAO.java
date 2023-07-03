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

}
