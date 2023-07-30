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

    public void guardar() throws IOException {
        cuenta.setId(generarId());
        this.guardar(cuenta);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(cuenta, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
    
    /**
     * 
     * @param dato
     * @return
     * @throws Exception 
     */
    
    public Cuenta buscarporId(Integer dato) throws Exception{
         Cuenta resultado = null;
        ListaEnlazada<Cuenta> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            Cuenta aux = lista.get(i);
            if (aux.getId().intValue() == dato.intValue()) {
                resultado = aux;
                break;
            }
        }
        return resultado;
    }

}