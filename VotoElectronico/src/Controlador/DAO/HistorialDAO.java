/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import java.io.IOException;
import modelo.Historial;

/**
 *
 * @author Juan_fer
 */
public class HistorialDAO extends AdaptadorDAO<Historial> {

    private Historial historial;

    public HistorialDAO() {
        super(Historial.class);
    }

    public Historial getHistorial() {
        if (this.historial == null) {
            this.historial = new Historial();
        }
        return historial;
    }

    
    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    public void guardar() throws IOException {
        historial.setId(generarId());
        this.guardar(historial);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(historial, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
}
