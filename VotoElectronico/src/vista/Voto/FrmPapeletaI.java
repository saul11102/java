/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.Voto;

import Controlador.DAO.CandidatoDao;
import Controlador.DAO.DignidadDao;
import Controlador.DAO.PapeletaDao;
import Controlador.DAO.PersonaDAO;
import Controlador.DAO.VotoDAO;
import Controlador.ed.lista.Exception.PosicionException;
import Controlador.ed.lista.Exception.VacioException;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Persona;
import vista.Utilidades.PapeletaComponent;

/**
 *
 * @author caim2
 */
public class FrmPapeletaI extends javax.swing.JDialog {
    private PapeletaComponent pc = new PapeletaComponent();
    private DignidadDao dd = new DignidadDao();
    private CandidatoDao cd = new CandidatoDao();
    private VotoDAO vd = new VotoDAO();
    private Persona persona = new Persona();
    private PersonaDAO pd = new PersonaDAO();
    private PapeletaDao ppd = new PapeletaDao();
    /**
     * Creates new form FrmPapeleta
     */
    public FrmPapeletaI(java.awt.Frame parent, boolean modal, Persona aux) {
        super(parent, modal);
        initComponents();
        this.persona = aux;
        addTabs();
    }
    
    private void addTabs(){
        try {
            pc.construirPapeleta(tabbed, dd, cd);
        } catch (Exception ex) {
            Logger.getLogger(FrmPapeletaI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        tabbed = new javax.swing.JTabbedPane();
        btnTerminar = new javax.swing.JButton();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabbed.setBorder(javax.swing.BorderFactory.createTitledBorder("Papeleta"));

        btnTerminar.setText("TERMINAR");
        btnTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 1383, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(452, 452, 452)
                .addComponent(btnTerminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnTerminar)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarActionPerformed
            HashMap<Integer, String> mapa = pc.getMapa();
        try {
            vd.votar(vd.listaVotoGuardar(mapa));
            persona.setEstado(true);
            pd.modificar(persona, persona.getId()-1);
            
            ppd.getPapeleta().setFechaEmision(new Date());
            ppd.guardar(persona.getId());
             
            this.setModal(false);
            this.dispose();
          
            JOptionPane.showMessageDialog(null, "Voto Guardado", "OK", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnTerminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletaI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletaI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletaI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletaI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPapeletaI dialog = new FrmPapeletaI(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminar;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JTabbedPane tabbed;
    // End of variables declaration//GEN-END:variables
}
