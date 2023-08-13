/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.DAO.AdaptadorDAOBDD;
import Controlador.ed.lista.ListaEnlazada;
import modelo.TipoVoto;

/**
 *
 * @author jostin
 */
public class TipoVotoDao extends AdaptadorDAOBDD<TipoVoto>{
    private TipoVoto tipoVoto;

    public TipoVotoDao() {
        super(TipoVoto.class);
    }

    public TipoVoto getTipoVoto() {
        if (this.tipoVoto == null) {
            this.tipoVoto = new TipoVoto();
        }
        return tipoVoto;
    }

    public void setTipoVoto(TipoVoto tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    public void guardar() throws Exception {
        this.guardar(tipoVoto);
    }

    public void modificar(Integer pos) throws Exception {
        if (tipoVoto == null || tipoVoto.getId() == null) {
            throw new IllegalArgumentException("El partido político no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<TipoVoto> lista = listar();

        if (pos < 0 || pos >= lista.size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }

        TipoVoto aux = lista.get(pos);
        

        this.modificar(aux);
    }

    public TipoVoto buscarPorTipoVoto(String dato) throws Exception {
        TipoVoto resultado = null;
        ListaEnlazada<TipoVoto> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            TipoVoto aux = lista.get(i);
            if (aux.getNombre().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

    public TipoVoto buscarPorId(Integer dato) throws Exception {
        TipoVoto resultado = null;
        ListaEnlazada<TipoVoto> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            TipoVoto aux = lista.get(i);
            if (aux.getId().intValue() == dato.intValue()) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
}
