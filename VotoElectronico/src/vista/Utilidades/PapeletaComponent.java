/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.Utilidades;

import Controlador.DAO.CandidatoDao;
import Controlador.DAO.DignidadDao;
import Controlador.DAO.PartidoPoliticoDao;
import Controlador.DAO.PersonaDAO;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import Controlador.ed.lista.ListaEnlazada;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import modelo.Candidato;
import modelo.Dignidad;
import modelo.PartidoPolitico;

/**
 *
 * @author caim2
 */
public class PapeletaComponent {

    private HashMap<Integer, String> mapa = new HashMap<>();

    public HashMap<Integer, String> getMapa() {
        return mapa;
    }

    public void setMapa(HashMap<Integer, String> mapa) {
        this.mapa = mapa;
    }

    public void construirPapeleta(JTabbedPane tabbed, DignidadDao dd, CandidatoDao cd) throws VacioException, PosicionException {
        ListaEnlazada<Dignidad> lista = dd.listar();
        for (int i = 0; i < lista.size(); i++) {
            Dignidad d = lista.get(i);
            if (d.getEstado() == 1) {
                ListaEnlazada<PartidoPolitico> listaP = new PartidoPoliticoDao().listaPartidosDignidad(d.getId());
                ///////////
                //ListaEnlazada<Candidato> listaC = cd.buscarPorDignidad(d.getId());
                if (!listaP.isEmpty()) {
                    mapa.put(d.getId(), "");
                    JPanel panelPrincipal = new JPanel();
                    panelPrincipal.setBorder(BorderFactory.createEtchedBorder(1));
                    panelPrincipal.setPreferredSize(new Dimension(500, 400));
                    for (int j = 0; j < listaP.size(); j++) {
                        PartidoPolitico partido = listaP.get(j);
                        JPanel pane = new JPanel();
                        pane.setBorder(BorderFactory.createEtchedBorder(1));
                        pane.setSize(new Dimension(400, 700));
                        pane.setPreferredSize(new Dimension(400, 700));
                        GridBagLayout grid = new GridBagLayout();
                        GridBagConstraints c = new GridBagConstraints();
                        pane.setLayout(grid);
                        c.gridx = 0;
                        c.gridy = 0;
                        JLabel lblPartido = new JLabel(partido.getNombre());
                        pane.add(lblPartido, c);
                        ListaEnlazada<Candidato> listaC = cd.buscarPorDignidadPartido(d.getId(), partido.getId());
                        /////////////
                        if (!listaC.isEmpty()) {
                            for (int k = 0; k < listaC.size(); k++) {
                                c.gridy = k + 1;
                                Candidato aux = listaC.get(k);
                                pane.add(candidatos(aux), c);
                            }
                        }
                        JScrollPane scrollP = new JScrollPane(pane);
                        scrollP.setPreferredSize(new Dimension(400, 300));
                        scrollP.setSize(new Dimension(400, 300));
                        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                        panelPrincipal.add(scrollP);
                    }
                    tabbed.addTab(d.getNombre(), panelPrincipal);
                    
                }
            }
        }
    }

    private JPanel candidatos(Candidato candidato) {
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEtchedBorder(1));
        panel.setLayout(grid);
        panel.setPreferredSize(new Dimension(300, 700));
        panel.getSize(new Dimension(300, 700));

        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        
        JLabel lblFoto = new JLabel();
        lblFoto.setIcon(scaleImage(new ImageIcon(getClass().getResource("/vista/Voto/FotoCandidatos/" + candidato.getFoto())), 200, 150));
        lblFoto.setSize(new Dimension(200, 150));
        lblFoto.setPreferredSize(new Dimension(200, 150));
        panel.add(lblFoto, c);
        c.gridx = 1;
        c.gridy = 1;
        
        JLabel lblNombre = new JLabel(new PersonaDAO().obtener(candidato.getId_Persona()).toString());
        panel.add(lblNombre, c);
        c.gridx = 1;
        c.gridy = 2;
        
        JCheckBox chck = new JCheckBox("VOTAR");
        chck.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                JCheckBox aux = (JCheckBox) ae.getSource();
                String valor = mapa.get(candidato.getId_Dignidad()).toString();
                String voto = "candidato"+":"+candidato.getId()+","+"dignidad"+":"+candidato.getId_Dignidad()+","+"partido"+":"+candidato.getId_PartidoPolitico();
                if (aux.isSelected()) {
                    if (valor.isEmpty()) {
                        valor = voto;
                    } else {
                        valor+=";"+voto;
                    }
                    mapa.put(candidato.getId_Dignidad(), valor);
                    
                } else {
                    String[] trozar = valor.split(";");
                    if (trozar.length == 1) {
                        valor = "";
                    } else {
                        valor = "";
                        for (String vot : trozar) {
                            if (!vot.equalsIgnoreCase(voto)) {
                                valor += vot +";";
                            }
                        }
                        valor = valor.substring(0, valor.length()-1);
                    }
                    mapa.put(candidato.getId_Dignidad(), valor);
                    
                }
            } 
            
        });
        panel.add(chck, c);
        return panel;
        
    }
    
    public ImageIcon scaleImage(ImageIcon icon, int w, int h){
        int nw = icon.getIconWidth(); 
        int nh = icon.getIconHeight();
        
        if (icon.getIconWidth() > w) {
            nw = w;
             nh = (nw * icon.getIconHeight()) / icon.getIconWidth();
        }
        
        if (nh > h) {
            nh = h;
            nw = (icon.getIconWidth() * nh ) / icon.getIconHeight();
        }
        return new ImageIcon(icon.getImage().getScaledInstance(nw, nh, Image.SCALE_DEFAULT));
    }
    
}