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
public class CuentaDAO extends AdaptadorDAOBDD<Cuenta> {

    private Cuenta cuenta;

    public CuentaDAO() {
        super(Cuenta.class);
    }

    public Cuenta getCuenta() {
        if (this.cuenta == null) {
            this.cuenta = new Cuenta();
        }
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * guarda a la cuenta dentro de la base
     *
     * @throws IOException
     * @throws Exception
     */
    public void guardar() throws IOException, Exception {
        this.guardar(cuenta);
    }

    /**
     * Modifica una cuenta dentro de la base de datos
     * @param pos
     * @throws Exception 
     */
    public void modificar(Integer pos) throws Exception {
        if (cuenta == null || cuenta.getId() == null) {
            throw new IllegalArgumentException("El partido político no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Cuenta> lista = listar();

        if (pos < 0 || pos >= lista.size()) {
            throw new IndexOutOfBoundsException("Posición inválida: " + pos);
        }

        Cuenta aux = lista.get(pos);
        this.modificar(aux);
    }
    
    /**
     * genera id único
     * @return 
     */
    private Integer generateID() {
        return listar().size() + 1;
    }

    /**
     * busca una cuenta de acuerdo a su id
     * @param dato id de la cuenta
     * @return
     * @throws Exception No existe cuenta
     */
    public Cuenta buscarporId(Integer dato) throws Exception {
        Cuenta resultado = null;
        ListaEnlazada<Cuenta> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Cuenta aux = lista.get(i);
            if (aux.getId_Persona().intValue() == dato.intValue()) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

}
