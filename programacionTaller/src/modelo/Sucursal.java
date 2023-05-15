package modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alejandro
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private Venta[] ventas;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.setId((Integer) id);
    }

    /**
     * @return the nomnbre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nomnbre the nomnbre to set
     */
    public void setNombre(String nomnbre) {
        this.nombre = nomnbre;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the venta
     */
    public Venta[] getVentas() {
        return ventas;
    }

    /**
     * @param venta the venta to set
     */
    public void setVentas(Venta[] venta) {
        this.ventas = venta;
    }

 
    
}
