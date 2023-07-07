/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import java.io.IOException;
import modelo.Voto;

/**
 *
 * @author alejandro
 */
public class VotanteDao extends AdaptadorDAO<Voto> {

    private Voto voto;

    public VotanteDao() {
        super(Voto.class);
    }

    public Voto getVoto() {
        if (this.voto == null) {
            this.voto = new Voto();
        }
        return voto;
    }

    public void setVoto(Voto voto) {
        this.voto = voto;
    }

    public void guardar() throws IOException {
        voto.setId(generarId());
        this.guardar(voto);
    }

    public void modificar(Integer pos) throws Exception {
        this.modificar(voto, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }
}
