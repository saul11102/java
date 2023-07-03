/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import modelo.Cuenta;

/**
 *
 * @author santiago
 */
public class CuentaDAO extends AdaptadorDAO<Cuenta> {

    public CuentaDAO() {
        super(Cuenta.class);
    }

    public void guardar(String username, String contrasena) throws IOException {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(generarId());
        cuenta.setUsername(username);
        cuenta.setContrasena(contrasena);
        super.guardar(cuenta);
    }

    public Cuenta buscar(String username, String password) throws VacioException, PosicionException {
        AdaptadorDAO<Cuenta> adaptadorDao = new AdaptadorDAO<>(Cuenta.class);
        ListaEnlazada<Cuenta> listaCuentas = adaptadorDao.listar();
        for (int i = 0; i < listaCuentas.size(); i++) {
            Cuenta cuenta = listaCuentas.get(i);
            if (cuenta.getUsername().equals(username) && cuenta.getContrasena().equals(password)) {
                return cuenta;
            }
        }
        return null;
    }

    public Cuenta getCuenta() {
        return obtener(1);
    }
}
