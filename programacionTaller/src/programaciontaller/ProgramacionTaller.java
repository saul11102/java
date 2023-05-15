/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package programaciontaller;

import controlador.SucursalControl;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.NodoLista;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.util.Utilidades;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Sucursal;

/**
 *
 * @author alejandro
 */
public class ProgramacionTaller {

    /**
     * @param args the command line arguments
     * @throws controlador.ed.lista.exception.PosicionException
     * @throws controlador.ed.lista.exception.VacioException
     */
    public static void main(String[] args) throws PosicionException, VacioException {
/*    
        ListaEnlazada<String> lista = new ListaEnlazada<>();
                
        try {
            lista.insertar("aaa");
            lista.insertar("eee");
            lista.insertar("bbb");
            lista.insertarInicio("zzz");
            lista.insertarPosicion("ggg", 2 );
            lista.imprimir();
                  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
*/

        ListaEnlazada<Sucursal> lista = new ListaEnlazada<>();
        try {
            Sucursal s1 = new Sucursal();
            s1.setId(lista.size() + 1);
            s1.setNombre("Alyce");
            lista.insertar(s1);
            s1 = new Sucursal();
            s1.setId(lista.size() + 1);
            s1.setNombre("Marylin");
            lista.insertar(s1);
            lista.imprimir();
            lista.insertarPosicion(s1, 0);
        } catch (VacioException e) {
            System.out.println(e.getMessage());
        } catch (PosicionException e) {
            System.out.println(e.getMessage());
        }
    }
}
