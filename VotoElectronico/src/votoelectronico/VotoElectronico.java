/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package votoelectronico;

import Controlador.DAO.CuentaDAO;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import java.io.IOException;
import modelo.Cuenta;

/**
 *
 * @author alejandro
 */
public class VotoElectronico {

    public static void main(String[] args) throws VacioException, PosicionException, IOException {
        CuentaDAO cuentaDAO = new CuentaDAO();

        String username = "1104982572";
        String contrasena = "prueba1";
        cuentaDAO.guardar(username, contrasena);

        Cuenta cuenta = cuentaDAO.getCuenta();
        System.out.println("Cuenta guardada: " + cuenta.getUsername() + ", " + cuenta.getContrasena());
    }
}
