/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import modelo.Rol;

/**
 *
 * @author jostin
 */
public class RolDAO {

    private ListaEnlazada<Rol> listaRoles;

    public RolDAO() {
        listaRoles = new ListaEnlazada<>();
    }

    public class RolController {

        private Rol rol;

        public void crearRol(Integer id, String nombre, String descripcion) {
            Rol rol = new Rol();
            rol.setId(id);
            rol.setNombre(nombre);
            rol.setDescripcion(descripcion);

            if (verificarExistenciaRol(id)) {
                System.out.println("El rol con el ID " + id + " ya existe en el sistema.");
                return; 
            }

            listaRoles.insertarNodo(rol);
            System.out.println("El rol se ha creado exitosamente en el sistema.");
        }

        private boolean verificarExistenciaRol(Integer id) {
            try {
                for (int i = 0; i < listaRoles.size(); i++) {
                    Rol rol = listaRoles.get(i);
                    if (rol.getId().equals(id)) {
                        return true; // El rol ya existe en la lista
                    }
                }
            } catch (VacioException | PosicionException e) {
                e.printStackTrace();
            }
            return false; 
        }
    }

    public void actualizarRol(Integer id, String nombre, String descripcion) {
        
        Rol rol = buscarRolPorId(id);
        if (rol == null) {
            System.out.println("El rol con el ID " + id + " no existe en el sistema.");
            return; 
        }

        
        rol.setNombre(nombre);
        rol.setDescripcion(descripcion);

        
        System.out.println("El rol se ha actualizado exitosamente en el sistema.");
    }

    private Rol buscarRolPorId(Integer id) {
        try {
            for (int i = 0; i < listaRoles.size(); i++) {
                Rol rol = listaRoles.get(i);
                if (rol.getId().equals(id)) {
                    return rol; 
                }
            }
        } catch (VacioException | PosicionException e) {
            e.printStackTrace();
        }
        return null; 
    }

    public void eliminarRol() {
       
    }
}