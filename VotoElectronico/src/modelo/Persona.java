/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author juanfer
 */
public class Persona {
    private Integer id;
    private String cedula;
    private String nombre;
    private String apellido;    
    private String direccion;
    private String correoElectronico;
    private String numeroTelefono;
    private Boolean estado;
    private Integer id_Rol;

    public Persona() {
    }

    public Persona(Integer id, String cedula, String nombre, String apellido, String direccion, String correoElectronico, String numeroTelefono, Boolean estado, Integer id_Rol) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.numeroTelefono = numeroTelefono;
        this.estado = estado;
        this.id_Rol = id_Rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Integer getId_Rol() {
        return id_Rol;
    }

    public void setId_Rol(Integer id_Rol) {
        this.id_Rol = id_Rol;
    }

    @Override
    public String toString() {
        return apellido+ " "+nombre;
    }

    
}
