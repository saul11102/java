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
public class VotoDAO extends AdaptadorDAOBDD<Voto> {

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
    
    /**
     * método para guardar el voto
     * @throws IOException
     * @throws Exception 
     */
    public void guardar() throws IOException, Exception {
        this.guardar(voto);
    }
    
    /**
     * método para modificar el voto dentro de la base de datos
     * @param pos
     * @throws Exception 
     */
    public void modificar(Integer pos) throws Exception {
        if (voto == null || voto.getId() == null) {
            throw new IllegalArgumentException("El partido político no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Voto> lista = listar();

        if (pos < 0 || pos >= lista.size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }

        Voto aux = lista.get(pos);
        

        this.modificar(aux);
    }


    private Integer generateID() {
        return listar().size() + 1;
    }
    
    /**
     * guarda el voto dependiendo el tipo que es, guarda el voto en una estructura de datos
     * @param mapa
     * @return el voto en una lista
     * @throws VacioException
     * @throws PosicionException
     * @throws Exception 
     */
    
    public ListaEnlazada<Voto> listaVotoGuardar(HashMap<Integer, String> mapa) throws VacioException, PosicionException, Exception {
        ListaEnlazada<Voto> lista = new ListaEnlazada<>();
        ListaEnlazada<TipoVoto> tipos = new TipoVotoDao().listar();
        for (Map.Entry<Integer, String> set : mapa.entrySet()) {
            Eleccion e = new EleccionDao().obtenerEleccionActiva();
            Dignidad d = new DignidadDao().obtener(set.getKey());
            Voto v = new Voto();
            v.setDignidad(d.getId());
            v.setVoto(set.getValue());
            v.setId_Eleccion(e.getId());
            if (set.getValue().equalsIgnoreCase("")) {
                v.setId_tipoVoto(new TipoVotoDao().buscarPorTipoVoto("Blanco").getId());
            } else {
                String aux[] = set.getValue().split(";");
                if (aux.length <= d.getNro()) {
                    v.setId_tipoVoto(new TipoVotoDao().buscarPorTipoVoto("Valido").getId());
                } else {
                    v.setId_tipoVoto(new TipoVotoDao().buscarPorTipoVoto("Nulo").getId());
                }
            }
            lista.insertarNodo(v);
        }
        return lista;

    }
    
    /**
     * método que guardar el voto dentro de la base de datos
     * @param listaVotoGuardar
     * @throws VacioException
     * @throws PosicionException
     * @throws IOException
     * @throws Exception 
     */
    public void votar(ListaEnlazada<Voto> listaVotoGuardar) throws VacioException, PosicionException, IOException, Exception {
        try {
            for (int i = 0; i < listaVotoGuardar.size(); i++) {
                Voto voto = listaVotoGuardar.get(i);
                guardar(voto); // Guardar cada voto en la base de datos
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Otra lógica de manejo de excepciones, si es necesario.
        }
    }
}
