
package Formularios;

import java.awt.*;
import javax.swing.*;
import Clases.ImagenUtil;

public class ventanaPrincipal extends javax.swing.JFrame {

    public ventanaPrincipal() {
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jb_gestprev = new javax.swing.JButton();
        jb_gestcli = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jb_gestprod = new javax.swing.JButton();
        jb_gestzon = new javax.swing.JButton();
        jl_nomemp = new javax.swing.JLabel();
        jl_logemp = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setName("Frame0"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jb_gestprev.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jb_gestprev.setText("Gestión de Preventistas");
        jb_gestprev.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_gestprev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_gestprevActionPerformed(evt);
            }
        });

        jb_gestcli.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jb_gestcli.setText("Gestión de Clientes");
        jb_gestcli.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_gestcli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_gestcliActionPerformed(evt);
            }
        });

        jb_salir.setBackground(new java.awt.Color(255, 0, 0));
        jb_salir.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jb_salir.setText("Salir");
        jb_salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jb_salirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jb_salirMouseExited(evt);
            }
        });
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        jb_gestprod.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jb_gestprod.setText("Gestión de Productos");
        jb_gestprod.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_gestprod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_gestprodActionPerformed(evt);
            }
        });

        jb_gestzon.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jb_gestzon.setText("Gestión de Zonas");
        jb_gestzon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jb_gestzon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_gestzonActionPerformed(evt);
            }
        });

        jl_nomemp.setFont(new java.awt.Font("Stencil", 3, 36)); // NOI18N
        jl_nomemp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nomemp.setText("TOC Distribuciones");

        jl_logemp.setText("logo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jb_gestprev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_gestzon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_gestprod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jb_gestcli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jl_nomemp, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_logemp, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jl_nomemp, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jl_logemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jb_gestprev, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_gestcli, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_gestprod, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_gestzon, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jb_gestcliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_gestcliActionPerformed
        abm_cliente abm_cli = new abm_cliente();
        abm_cli.setVisible(true);
        dispose();
    }//GEN-LAST:event_jb_gestcliActionPerformed

    private void jb_gestprevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_gestprevActionPerformed

        abm_preventista abm_prev = new abm_preventista();
        abm_prev.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jb_gestprevActionPerformed

    private void jb_gestzonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_gestzonActionPerformed
        abm_zona abm_z = new abm_zona();
        abm_z.setVisible(true);
        dispose();
    }//GEN-LAST:event_jb_gestzonActionPerformed

    private void jb_gestprodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_gestprodActionPerformed
        abm_producto abm_prod = new abm_producto();
        abm_prod.setVisible(true);
        dispose();
    }//GEN-LAST:event_jb_gestprodActionPerformed

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jb_salirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        ImagenUtil.cargarEnLabel("src/imagenes/logo_emp.jpeg", jl_logemp);
        ImagenUtil.agregarFondoAFrame(this, "src/imagenes/fondo_app2.jpg");
        
    }//GEN-LAST:event_formWindowOpened

    private void jb_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_salirMouseEntered
        jb_salir.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_jb_salirMouseEntered

    private void jb_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_salirMouseExited
        jb_salir.setBackground(new Color(204, 0, 0)); 
    }//GEN-LAST:event_jb_salirMouseExited

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
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jb_gestcli;
    private javax.swing.JButton jb_gestprev;
    private javax.swing.JButton jb_gestprod;
    private javax.swing.JButton jb_gestzon;
    private javax.swing.JButton jb_salir;
    private javax.swing.JLabel jl_logemp;
    private javax.swing.JLabel jl_nomemp;
    // End of variables declaration//GEN-END:variables
}
