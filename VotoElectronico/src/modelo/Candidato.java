 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;



/**
 *
 * @author jostin
 */
public class Candidato {
    
    private Integer id;
    
    private String nombre;
    private PartidoPolitico partidoPolitico;
    public Candidato(Integer id, String nombre, PartidoPolitico partidoPolitico) {
        this.id = id;
        this.nombre = nombre;
        this.partidoPolitico = partidoPolitico;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }
}
