/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.DAO;

import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import java.io.IOException;
import java.security.Key;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import modelo.Eleccion;
import modelo.Papeleta;

/**
 *
 * @author caim2
 */
public class PapeletaDao extends AdaptadorDAOBDD<Papeleta> {

    private Papeleta papeleta;

    public PapeletaDao() {
        super(Papeleta.class);
    }

    public Papeleta getPapeleta() {
        if (this.papeleta == null) {
            this.papeleta = new Papeleta();
        }
        return papeleta;
    }

    public void setPapeleta(Papeleta papeleta) {
        this.papeleta = papeleta;
    }

    /**
     * guarda una papeleta dentro de la base de datos de acuerdo al id de la
     * persona el id está encriptado para hacer el voto anónimo
     *
     * @param id_Persona
     * @throws IOException
     * @throws VacioException
     * @throws PosicionException
     * @throws Exception
     */
    public void guardar(Integer id_Persona) throws IOException, VacioException, PosicionException, Exception {
        papeleta.setNumeroPapeleta(generarNumeroPapeleta());
        papeleta.setId_Persona(encriptarIdPersona(id_Persona));
        papeleta.setId_Eleccion(obtenerEleccion());
        this.guardar(papeleta);
    }

    /**
     * modifica una papeleta dentro de la base
     *
     * @param pos
     * @throws Exception
     */
    public void modificar(Integer pos) throws Exception {
        if (papeleta == null || papeleta.getId() == null) {
            throw new IllegalArgumentException("El partido político no está correctamente configurado para la modificación.");
        }

        ListaEnlazada<Papeleta> lista = listar();
        Papeleta aux = lista.get(pos);
        this.modificar(aux);

    }

    /**
     * genera un id único para la papeleta
     *
     * @return
     */
    private Integer generateID() {
        return listar().size() + 1;
    }

    /**
     * genera el código para la papeleta
     *
     * @return
     */
    private String generarNumeroPapeleta() {
        return "PAPELETA-" + generateID();
    }

    /**
     * encripta una persona para hacer el voto anónimo
     *
     * @param id_Persona
     * @return
     */
    private Integer encriptarIdPersona(Integer id_Persona) {
        try {
            Key key = new SecretKeySpec("GRUPO3CLAVE12345".getBytes("UTF-8"), "AES");
            // GRUPO3CLAVE12345 clave para encriptar la contraseña
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptedBytes = cipher.doFinal(id_Persona.toString().getBytes());
            // Convertir el arreglo de bytes en un entero utilizando operaciones bit a bit
            int encryptedInt = 0;
            for (int i = 0; i < 4; i++) {
                encryptedInt |= (encryptedBytes[i] & 0xFF) << (24 - (8 * i));
            }

            return encryptedInt;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * obtiene la elección activa para guardarlo en la papeleta
     *
     * @return
     * @throws VacioException
     * @throws PosicionException
     */
    private Integer obtenerEleccion() throws VacioException, PosicionException {
        Eleccion e = new EleccionDao().obtenerEleccionActiva();
        System.out.println("ID de Eleccion obtenida:  " + e.getId());
        return e.getId();
    }
}
