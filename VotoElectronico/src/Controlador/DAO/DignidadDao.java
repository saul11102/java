/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Dignidad;

/**
 *
 * @author Kevin
 */
public class DignidadDao extends AdaptadorDAO<Dignidad> {

    private Dignidad dignidad;

    public DignidadDao() {
        super(Dignidad.class);
    }

    public Dignidad getDignidad() {
        if (this.dignidad == null) {
            this.dignidad = new Dignidad();
        }
        return dignidad;
    }

    public void setDignidad(Dignidad dignidad) {
        this.dignidad = dignidad;
    }

    public void guardar() throws IOException {
        dignidad.setId(generarId());
        this.guardar(dignidad);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(dignidad, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public Dignidad buscarPorNombres(String dato) throws Exception{
        Dignidad resultado = null;
        ListaEnlazada<Dignidad> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Dignidad aux = lista.get(i);
            if (aux.getNombre().toLowerCase().equals(dato.toLowerCase())){
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
}


