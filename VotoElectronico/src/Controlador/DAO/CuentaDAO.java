/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import modelo.Cuenta;

/**
 *
 * @author santiago
 */
public class CuentaDAO {

    private ListaEnlazada<Cuenta> listaCuentas;

    public CuentaDAO() {
        listaCuentas = new ListaEnlazada<>();
    }

    public void guardar(Cuenta cuenta) {
        listaCuentas.insertarNodo(cuenta);
    }

    public Cuenta buscar(String username, String password) throws VacioException, PosicionException {
        for (int i = 0; i < listaCuentas.size(); i++) {
            Cuenta cuenta = listaCuentas.get(i);
            if (cuenta.getUsername().equals(username) && cuenta.getContrasena().equals(password)) {
                return cuenta;
            }
        }
        return null;
    }
    

}

