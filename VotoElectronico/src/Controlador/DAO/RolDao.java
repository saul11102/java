/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Rol;

/**
 *
 * @author jostin
 */
public class RolDao extends AdaptadorDAOBDD<Rol> {

    private Rol rol;

    public RolDao() {
        super(Rol.class);
    }

    public Rol getRol() {
        if (this.rol == null) {
            this.rol = new Rol();
        }
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    /**
     * guarda un rol dentro de la base de datos
     * @throws IOException
     * @throws Exception 
     */
    public void guardar() throws IOException, Exception {
        this.guardar(rol);
    }
    
    /**
     * modifica un rol dentro de la base de datos
     * @param pos
     * @throws Exception 
     */
    public void modificar(Integer pos) throws Exception {
        if (rol == null || rol.getId() == null) {
            throw new IllegalArgumentException("El rol no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Rol> lista = listar();

        Rol aux = lista.get(pos);

        this.modificar(aux);
    }
    
    /**
     * busca un rol de acuerdo al nombre 
     * @param dato nombre del rol a buscar
     * @return
     * @throws Exception 
     */
    public Rol buscarPorRol(String dato) throws Exception {
        Rol resultado = null;
        ListaEnlazada<Rol> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Rol aux = lista.get(i);
            if (aux.getNombre().toLowerCase().equals(dato.toLowerCase())) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
    
    /**
     * busca un rol de acuerdo a su id
     * @param dato id del rol
     * @return
     * @throws Exception 
     */
    public Rol buscarPorId(Integer dato) throws Exception {
        Rol resultado = null;
        ListaEnlazada<Rol> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Rol aux = lista.get(i);
            if (aux.getId().intValue() == dato.intValue()) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }
}
