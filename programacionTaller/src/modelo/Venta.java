/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alejandro
 */
public class Venta {
    private Integer id;
    private double valor;
    private EnumMes mes;

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
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the mes
     */
    public EnumMes getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(EnumMes mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return getMes().toString()+" "+getValor();
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
   
}
