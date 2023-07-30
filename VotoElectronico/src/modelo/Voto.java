/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author alejandro
 */
public class Voto {
    private Integer id;
    private Integer voto_Normal;
    private Integer voto_Nulo;
    private Integer voto_Blanco;

    public Voto() {
    }

    public Voto(Integer id, Integer voto_Normal, Integer voto_Nulo, Integer voto_Blanco) {
        this.id = id;
        this.voto_Normal = voto_Normal;
        this.voto_Nulo = voto_Nulo;
        this.voto_Blanco = voto_Blanco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoto_Normal() {
        return voto_Normal;
    }

    public void setVoto_Normal(Integer voto_Normal) {
        this.voto_Normal = voto_Normal;
    }

    public Integer getVoto_Nulo() {
        return voto_Nulo;
    }

    public void setVoto_Nulo(Integer voto_Nulo) {
        this.voto_Nulo = voto_Nulo;
    }

    public Integer getVoto_Blanco() {
        return voto_Blanco;
    }

    public void setVoto_Blanco(Integer voto_Blanco) {
        this.voto_Blanco = voto_Blanco;
    }

   
}