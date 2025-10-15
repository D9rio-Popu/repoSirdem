
package Formularios;

import java.awt.*;
import javax.swing.*;
import Clases.ImagenUtil;
import com.formdev.flatlaf.FlatLightLaf;

public class ventanaPrincipal extends javax.swing.JFrame {

    public ventanaPrincipal() {
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        Clases.botonConImagen.ajustarImagenYTextoDinamicamente(preventista, "/imagenes/bt_preventista.jpg", "Gestion de Preventistas");
        Clases.botonConImagen.ajustarImagenYTextoDinamicamente(producto, "/imagenes/bt_producto.png", "Gestion de Productos");
        Clases.botonConImagen.ajustarImagenYTextoDinamicamente(zona, "/imagenes/bt_zona.png", "Gestion de Zonas");
        Clases.botonConImagen.ajustarImagenYTextoDinamicamente(gasto, "/imagenes/bt_gasto.jpg", "Gestion de Gastos");
        Clases.botonConImagen.ajustarImagenYTextoDinamicamente(cliente, "/imagenes/bt_cliente.png", "Gestion de Clientes");
        Clases.botonConImagen.ajustarImagenYTextoDinamicamente(rendicion, "/imagenes/bt_rendicion.png", "Rendiciones");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preventista = new javax.swing.JButton();
        cliente = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        producto = new javax.swing.JButton();
        zona = new javax.swing.JButton();
        jl_nomemp = new javax.swing.JLabel();
        jl_logemp = new javax.swing.JLabel();
        gasto = new javax.swing.JButton();
        rendicion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setName("Frame0"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        preventista.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        preventista.setText("Gestión de Preventistas");
        preventista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        preventista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preventistaActionPerformed(evt);
            }
        });

        cliente.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        cliente.setText("Gestión de Clientes");
        cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
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

        producto.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        producto.setText("Gestión de Productos");
        producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productoActionPerformed(evt);
            }
        });

        zona.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        zona.setText("Gestión de Zonas");
        zona.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zonaActionPerformed(evt);
            }
        });

        jl_nomemp.setFont(new java.awt.Font("Stencil", 3, 36)); // NOI18N
        jl_nomemp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl_nomemp.setText("TOC Distribuciones");

        jl_logemp.setText("logo");

        gasto.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        gasto.setText("Gestion de Gastos");
        gasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gastoActionPerformed(evt);
            }
        });

        rendicion.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        rendicion.setText("Rendiciones");
        rendicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jl_nomemp, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jl_logemp, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(preventista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(zona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rendicion, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gasto, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jl_nomemp, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jl_logemp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(preventista, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rendicion, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zona, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(producto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gasto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        abm_cliente abm_cli = new abm_cliente(this);
        abm_cli.setVisible(true);
        dispose();
    }//GEN-LAST:event_clienteActionPerformed

    private void preventistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preventistaActionPerformed

        abm_preventista abm_prev = new abm_preventista(this);
        abm_prev.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_preventistaActionPerformed

    private void zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zonaActionPerformed
        abm_zona abm_z = new abm_zona(this);
        abm_z.setVisible(true);
        dispose();
    }//GEN-LAST:event_zonaActionPerformed

    private void productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productoActionPerformed
        abm_producto abm_prod = new abm_producto(this);
        abm_prod.setVisible(true);
        dispose();
    }//GEN-LAST:event_productoActionPerformed

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

    private void gastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gastoActionPerformed
        // TODO add your handling code here:
        abm_gasto abm_g = new abm_gasto(this);
        abm_g.setVisible(true);
        dispose();
    }//GEN-LAST:event_gastoActionPerformed

    private void rendicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendicionActionPerformed
        // TODO add your handling code here:
        rendiciones r = new rendiciones();
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_rendicionActionPerformed

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
            FlatLightLaf.setup(); // Asegura que FlatLaf esté configurado
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al configurar FlatLaf: " + e.getMessage());
            return; // Salir si FlatLaf no se inicializa
        }
        /*try {
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
    private javax.swing.JButton cliente;
    private javax.swing.JButton gasto;
    private javax.swing.JButton jb_salir;
    private javax.swing.JLabel jl_logemp;
    private javax.swing.JLabel jl_nomemp;
    private javax.swing.JButton preventista;
    private javax.swing.JButton producto;
    private javax.swing.JButton rendicion;
    private javax.swing.JButton zona;
    // End of variables declaration//GEN-END:variables
}
