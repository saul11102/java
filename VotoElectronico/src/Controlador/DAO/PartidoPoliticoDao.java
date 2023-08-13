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
import modelo.PartidoPolitico;

/**
 *
 * @author Kevin
 */
public class PartidoPoliticoDao extends AdaptadorDAOBDD<PartidoPolitico> {

    private PartidoPolitico partidoPolitico;

    public PartidoPoliticoDao() {
        super(PartidoPolitico.class);
    }

    public PartidoPolitico getPartidoPolitico() {
        if (this.partidoPolitico == null) {
            this.partidoPolitico = new PartidoPolitico();
        }
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public void guardar() throws IOException, Exception {
        this.guardar(partidoPolitico);
    }

    public void modificar(Integer pos) throws Exception {
        if (partidoPolitico == null || partidoPolitico.getId() == null) {
            throw new IllegalArgumentException("El partido político no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<PartidoPolitico> lista = listar();

        if (pos < 0 || pos >= lista.size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }

        PartidoPolitico aux = lista.get(pos);
        aux.setNombre(partidoPolitico.getNombre());
        aux.setFoto(partidoPolitico.getFoto());
        aux.setLider(partidoPolitico.getLider());
        aux.setNroLista(partidoPolitico.getNroLista());
        aux.setSede(partidoPolitico.getSede());
        aux.setSiglas(partidoPolitico.getSiglas());
        aux.setSlogan(partidoPolitico.getSlogan());
        

        this.modificar(aux);
    }


    public PartidoPolitico buscarPorNombres(String dato) throws Exception {
        PartidoPolitico resultado = null;
        ListaEnlazada<PartidoPolitico> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            PartidoPolitico aux = lista.get(i);
            if (aux.getNombre().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

    public PartidoPolitico buscarPorId(Integer dato) throws Exception {
        PartidoPolitico resultado = null;
        ListaEnlazada<PartidoPolitico> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            PartidoPolitico aux = lista.get(i);
            if (aux.getId().intValue() == dato.intValue()) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

    public ListaEnlazada<PartidoPolitico> listaPartidosDignidad(Integer id_dignidad) throws VacioException, PosicionException {
        ListaEnlazada<PartidoPolitico> lista = new ListaEnlazada<>();
        ListaEnlazada<Candidato> listaC = new CandidatoDao().listar();
        for (int i = 0; i < listaC.size(); i++) {
            Candidato c = listaC.get(i);
            if (c.getId_Dignidad().intValue() == id_dignidad.intValue()) {
                if (lista.isEmpty() || !estaLista(c.getId_PartidoPolitico(), lista)) {
                    lista.insertarNodo(obtener(c.getId_PartidoPolitico()));
                }
            }
        }
        return lista;
    }

    private boolean estaLista(Integer id_PartidoPolitico, ListaEnlazada<PartidoPolitico> lista) throws VacioException, PosicionException {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId().intValue() == id_PartidoPolitico.intValue()) {
                return true;
            }
        }
        return false;
    }
}
