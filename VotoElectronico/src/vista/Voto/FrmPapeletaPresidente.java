/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.Voto;

import Controlador.DAO.CandidatoDao;
import Controlador.DAO.PartidoPoliticoDao;
import Controlador.DAO.PersonaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Candidato;
import modelo.PartidoPolitico;
import modelo.Persona;

/**
 *
 * @author santiago
 */
public class FrmPapeletaPresidente extends javax.swing.JDialog {
    private PartidoPoliticoDao ppd = new PartidoPoliticoDao();
    private CandidatoDao cd = new CandidatoDao();
    private PersonaDAO pd = new PersonaDAO();
            

    /**
     * Creates new form FrmPapeletaPresidente
     */
    public FrmPapeletaPresidente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarPartidosPoliticos();
        cargarCandidatos();
    }
    
    public void cargarPartidosPoliticos() {
        try {
            PartidoPolitico p1 = ppd.buscarPorId(1);
            PartidoPolitico p2 = ppd.buscarPorId(2);
            PartidoPolitico p3 = ppd.buscarPorId(3);
            txtPartido1.setText(p1.getNombre());
            txtPartido2.setText(p2.getNombre());
            txtPartido3.setText(p2.getNombre());
            
            txtNroLista1.setText(p1.getNroLista().toString());
            txtNroLista2.setText(p2.getNroLista().toString());
            txtNroLista3.setText(p3.getNroLista().toString());
        } catch (Exception ex) {
            Logger.getLogger(FrmPapeletaPresidente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarCandidatos(){
        try {
            
            Candidato c1 = cd.buscarPorId(1);
            Candidato c2 = cd.buscarPorId(2);
            Candidato c3 = cd.buscarPorId(3);
            Persona p1 = pd.buscarPorId(c1.getId_Persona());
            Persona p2 = pd.buscarPorId(c2.getId_Persona());
            Persona p3 = pd.buscarPorId(c3.getId_Persona());
            txtCandidato1.setText(p1.getNombre() + " " + p1.getApellido());
            txtCandidato2.setText(p2.getNombre() + " " + p2.getApellido());
            txtCandidato3.setText(p3.getNombre() + " " + p3.getApellido());
        } catch (Exception ex) {
            Logger.getLogger(FrmPapeletaPresidente.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        txtPartido2 = new javax.swing.JLabel();
        txtNroLista2 = new javax.swing.JLabel();
        txtCandidato2 = new javax.swing.JLabel();
        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        txtPartido3 = new javax.swing.JLabel();
        txtNroLista3 = new javax.swing.JLabel();
        txtCandidato3 = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        txtPartido1 = new javax.swing.JLabel();
        txtNroLista1 = new javax.swing.JLabel();
        txtCandidato1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPartido2.setText("jLabel2");

        txtNroLista2.setText("jLabel1");

        txtCandidato2.setText("jLabel1");

        jToggleButton2.setText("VOTAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCandidato2)
                            .addComponent(txtNroLista2)
                            .addComponent(txtPartido2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jToggleButton2)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtPartido2)
                .addGap(18, 18, 18)
                .addComponent(txtNroLista2)
                .addGap(191, 191, 191)
                .addComponent(txtCandidato2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton2)
                .addGap(50, 50, 50))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPartido3.setText("jLabel3");

        txtNroLista3.setText("jLabel1");

        txtCandidato3.setText("jLabel1");

        jToggleButton3.setText("VOTAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton3)
                    .addComponent(txtCandidato3)
                    .addComponent(txtNroLista3)
                    .addComponent(txtPartido3))
                .addGap(0, 105, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtPartido3)
                .addGap(18, 18, 18)
                .addComponent(txtNroLista3)
                .addGap(189, 189, 189)
                .addComponent(txtCandidato3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(jToggleButton3)
                .addGap(56, 56, 56))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPartido1.setText("jLabel1");

        txtNroLista1.setText("jLabel1");

        txtCandidato1.setText("jLabel1");

        jToggleButton1.setText("VOTAR");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCandidato1)
                            .addComponent(txtNroLista1)
                            .addComponent(txtPartido1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jToggleButton1)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtPartido1)
                .addGap(30, 30, 30)
                .addComponent(txtNroLista1)
                .addGap(179, 179, 179)
                .addComponent(txtCandidato1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addGap(47, 47, 47))
        );

        jToggleButton4.setText("ANULAR VOTO");

        jToggleButton5.setText("DEJAR EN BLANCO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jToggleButton4)
                .addGap(152, 152, 152)
                .addComponent(jToggleButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButton4)
                    .addComponent(jToggleButton5))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPapeletaPresidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletaPresidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletaPresidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPapeletaPresidente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmPapeletaPresidente dialog = new FrmPapeletaPresidente(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JLabel txtCandidato1;
    private javax.swing.JLabel txtCandidato2;
    private javax.swing.JLabel txtCandidato3;
    private javax.swing.JLabel txtNroLista1;
    private javax.swing.JLabel txtNroLista2;
    private javax.swing.JLabel txtNroLista3;
    private javax.swing.JLabel txtPartido1;
    private javax.swing.JLabel txtPartido2;
    private javax.swing.JLabel txtPartido3;
    // End of variables declaration//GEN-END:variables
}
