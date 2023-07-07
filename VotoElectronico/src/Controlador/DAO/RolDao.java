/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import java.io.IOException;
import modelo.Rol;

/**
 *
 * @author alejandro
 */
public class RolDao extends AdaptadorDAO<Rol> {

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

    public void guardar() throws IOException {
        rol.setId(generarId());
        this.guardar(rol);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(rol, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
}