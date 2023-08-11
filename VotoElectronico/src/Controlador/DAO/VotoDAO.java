/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.Dignidad;
import modelo.Eleccion;
import modelo.TipoVoto;
import modelo.Voto;

/**
 *
 * @author jostin
 */
public class VotoDAO extends AdaptadorDAO<Voto> {

    private Voto voto;

    public VotoDAO() {
        super(Voto.class);
    }

    public Voto getVoto() {
        if (this.voto == null) {
            this.voto = new Voto();
        }
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    public void guardar() throws IOException {
        voto.setId(generarId());
        this.guardar(voto);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(voto, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    public ListaEnlazada<Voto> listaVotoGuardar(HashMap<Integer, String> mapa) throws VacioException, PosicionException {
        ListaEnlazada<Voto> lista = new ListaEnlazada<>();
        for (Map.Entry<Integer, String> set : mapa.entrySet()) {
            Eleccion e = new EleccionDao().obtenerEleccionActiva();
            Dignidad d = new DignidadDao().obtener(set.getKey());
            Voto v = new Voto();
            v.setDignidad(d.getId());
            v.setVoto(set.getValue());
            v.setId_Seleccion(e.getId());
            if (set.getValue().equalsIgnoreCase("")) {
                v.setTipo(TipoVoto.BLANCO);
            } else {
                String aux[] = set.getValue().split(";");
                if (aux.length <= d.getNro()) {
                    v.setTipo(TipoVoto.VALIDO);
                } else {
                    v.setTipo(TipoVoto.NULO);
                }
            }
            lista.insertarNodo(v);
        }
        return lista;

    }

    public void votar(ListaEnlazada<Voto> listaVotoGuardar) throws VacioException, PosicionException, IOException {
        try {
            for (int i = 0; i < listaVotoGuardar.size(); i++) {
                Voto voto = listaVotoGuardar.get(i);
                voto.setId(generarId()); // Asignar un nuevo ID al voto antes de guardarlo (si es necesario)
                guardar(voto); // Guardar cada voto en la base de datos
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Otra lógica de manejo de excepciones, si es necesario.
        }
    }
}
