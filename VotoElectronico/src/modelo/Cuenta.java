/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import Controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author santiago
 */
public class Cuenta {

   private Integer id;
    private String contrasena;
    private Integer id_Persona;

    public Cuenta() {
    }

    public Cuenta(Integer id, String contrasena, Integer id_Persona) {
        this.id = id;
        this.contrasena = contrasena;
        this.id_Persona = id_Persona;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Integer getId_Persona() {
        return id_Persona;
    }

    public void setId_Persona(Integer id_Persona) {
        this.id_Persona = id_Persona;
    }
    
}
