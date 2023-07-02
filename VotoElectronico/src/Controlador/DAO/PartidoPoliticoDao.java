/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.PartidoPolitico;
import modelo.PartidoPolitico;

/**
 *
 * @author alejandro
 */
public class PartidoPoliticoDao extends AdaptadorDAO<PartidoPolitico> {

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

    public void guardar() throws IOException {
        partidoPolitico.setId(generarId());
        this.guardar(partidoPolitico);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(partidoPolitico, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
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
}
