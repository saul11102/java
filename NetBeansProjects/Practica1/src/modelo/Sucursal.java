/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.List;
/**
 *
 * @author jostin
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private List<Venta> ventas;

    public Sucursal() {
    }

    public Sucursal(Integer id, String nombre, List<Venta> ventas) {
        this.id = id;
        this.nombre = nombre;
        this.ventas = ventas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
