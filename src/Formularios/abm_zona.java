
package Formularios;

import Clases.ImagenUtil;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class abm_zona extends javax.swing.JFrame {

    Connection con = Conexion.Conexion.conexion();
    private boolean modific = false;
    
    public abm_zona() {
        this.setUndecorated(true);
        initComponents();
        id_zona.setVisible(false);
        setLocationRelativeTo(null);
        componentdesactivado();
        buttonGroup1.add(jRadioButtonActivo);
        buttonGroup1.add(jRadioButtonInactivo);
        nom_buscar.setDocument(new Clases.Validaciones.LimiteCaracteres(15));
        nombre.setDocument(new Clases.Validaciones.LimiteCaracteres(15));
        carga();
    }

    void componentdesactivado(){
        nombre.setText("");
        buttonGroup1.clearSelection();
        nombre.setEnabled(false);
        jRadioButtonActivo.setEnabled(false);
        jRadioButtonInactivo.setEnabled(false);
        agregar.setEnabled(false);
        modificar.setEnabled(false);
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
    }
    
    void componentactivo(){
        nombre.setEnabled(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }
    
    void carga(){
        nom_buscar.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                buscar();
            }

            public void removeUpdate(DocumentEvent e) {
                buscar();
                componentdesactivado();
            }

            public void changedUpdate(DocumentEvent e) {
                buscar();
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        nom_buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableZona = new javax.swing.JTable();
        modificar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButtonActivo = new javax.swing.JRadioButton();
        jRadioButtonInactivo = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jb_salir = new javax.swing.JButton();
        jb_atras = new javax.swing.JButton();
        id_zona = new javax.swing.JLabel();
        agregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zona");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        nom_buscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nom_buscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 0, 36)); // NOI18N
        jLabel1.setText("Gestión Zonas");

        jTableZona.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTableZona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N°", "Nombre", "Estado"
            }
        ));
        jTableZona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableZonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableZona);

        modificar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        guardar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel3.setText("Estado:");

        jRadioButtonActivo.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jRadioButtonActivo.setText("Activo");
        jRadioButtonActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActivoActionPerformed(evt);
            }
        });

        jRadioButtonInactivo.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jRadioButtonInactivo.setText("Inactivo");

        jLabel4.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel4.setText("Ingrese la zona a Buscar:");

        jb_salir.setBackground(new java.awt.Color(255, 0, 0));
        jb_salir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jb_salir.setText("SALIR");
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

        jb_atras.setBackground(new java.awt.Color(0, 0, 204));
        jb_atras.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jb_atras.setForeground(new java.awt.Color(255, 255, 255));
        jb_atras.setText("VOLVER");
        jb_atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jb_atrasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jb_atrasMouseExited(evt);
            }
        });
        jb_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_atrasActionPerformed(evt);
            }
        });

        id_zona.setText("id_zona");

        agregar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(id_zona)
                        .addGap(34, 34, 34))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(modificar)
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(guardar)
                                .addGap(35, 35, 35)
                                .addComponent(cancelar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonActivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonInactivo)))
                        .addGap(20, 79, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jb_atras)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregar)
                                    .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jb_atras)
                    .addComponent(jb_salir))
                .addGap(9, 9, 9)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(id_zona)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jRadioButtonActivo)
                            .addComponent(jRadioButtonInactivo))
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(modificar)
                    .addComponent(cancelar))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar(){
        Connection con = Conexion.Conexion.conexion();
        String nom = nom_buscar.getText();
        try{
            ResultSet rs = Clases.Zona.Buscar(con, nom);
            DefaultTableModel modelo = (DefaultTableModel) jTableZona.getModel();
            modelo.setRowCount(0);
            boolean encontrado = false;
            while(rs.next()){
                Object[] fila = {
                  rs.getInt("id_zona"),
                  rs.getString("nombre_zona"),
                  rs.getString("estado")
                };
                modelo.addRow(fila);
                encontrado = true;
            }
            if(!encontrado && !nom_buscar.getText().isEmpty()){
                agregar.setEnabled(true);
                modific = false;
            }
            rs.close();
            con.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this,"Error al buscar la zona " +ex.getMessage());
        }
    }
    private void jTableZonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableZonaMouseClicked
        int filaSeleccionada = jTableZona.getSelectedRow();
        if (filaSeleccionada >= 0){
            id_zona.setText(jTableZona.getValueAt(filaSeleccionada, 0).toString());
            nombre.setText(jTableZona.getValueAt(filaSeleccionada, 1).toString());
            buttonGroup1.setSelected(
                "Activo".equals(jTableZona.getValueAt(filaSeleccionada, 2).toString()) ? jRadioButtonActivo.getModel() : 
                "Inactivo".equals(jTableZona.getValueAt(filaSeleccionada, 2).toString()) ? jRadioButtonInactivo.getModel() : null,
                true
            );
            modificar.setEnabled(true);
        }
    }//GEN-LAST:event_jTableZonaMouseClicked

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        int estado = jRadioButtonActivo.isSelected() ? 1 : 0;
        if(modific){
            int idd = Integer.parseInt(id_zona.getText());
            try{
                Clases.Zona.Modificar(con, nombre.getText(), estado, idd);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error no se puede modificar" +ex.getMessage());
            }
        }else{
            try{
                Clases.Zona.Insertar(con, nombre.getText(), estado);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(this,"Error no se pudo cargar el libro" +ex.getMessage());
            }
        }
        componentdesactivado();
        buscar();
        modific = false;
    }//GEN-LAST:event_guardarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        componentactivo();
        jRadioButtonActivo.setEnabled(true);
        jRadioButtonInactivo.setEnabled(true);
        modific = true;
        modificar.setEnabled(false);
    }//GEN-LAST:event_modificarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        componentdesactivado();
    }//GEN-LAST:event_cancelarActionPerformed

    private void jb_salirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_salirMouseEntered
        jb_salir.setBackground(new Color(255, 51, 51));
    }//GEN-LAST:event_jb_salirMouseEntered

    private void jb_salirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_salirMouseExited
        jb_salir.setBackground(new Color(204, 0, 0));
    }//GEN-LAST:event_jb_salirMouseExited

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_atrasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_atrasMouseEntered
        jb_atras.setBackground(new Color(0, 122, 255));
    }//GEN-LAST:event_jb_atrasMouseEntered

    private void jb_atrasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jb_atrasMouseExited
        jb_atras.setBackground(new Color(0, 82, 204));
    }//GEN-LAST:event_jb_atrasMouseExited

    private void jb_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_atrasActionPerformed
        ventanaPrincipal vp = new ventanaPrincipal();
        vp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jb_atrasActionPerformed

    private void nom_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nom_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nom_buscarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ImagenUtil.agregarFondoAFrame(this, "src/imagenes/fondo_app5.jpg");
        buscar();
    }//GEN-LAST:event_formWindowOpened

    private void jRadioButtonActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonActivoActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        nom_buscar.setText("");
        componentactivo();
        jRadioButtonActivo.setEnabled(true);
        jRadioButtonActivo.setSelected(true);
        jRadioButtonInactivo.setEnabled(false);
    }//GEN-LAST:event_agregarActionPerformed

    
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
            java.util.logging.Logger.getLogger(abm_zona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(abm_zona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(abm_zona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(abm_zona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new abm_zona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel id_zona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButtonActivo;
    private javax.swing.JRadioButton jRadioButtonInactivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableZona;
    private javax.swing.JButton jb_atras;
    private javax.swing.JButton jb_salir;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nom_buscar;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
