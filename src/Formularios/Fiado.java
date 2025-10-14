/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alumno
 */
public class Fiado extends javax.swing.JFrame {

    private Map<String, Integer> preventista = new HashMap<>();
    private Map<Integer, Float> filasModificadas = new HashMap<>();
    JFrame ventanaAnterior;
    DefaultTableModel modelo;
    /**
     * Creates new form Fiado
     */
    public Fiado( JFrame called) {
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        this.ventanaAnterior = called;
        personalizacion();
        listener();
        carga();
    }
    
    void personalizacion(){
        Clases.FocusBorderChanger.aplicar(jTextField1, new Color(0, 153, 255), Color.GRAY);
        new Clases.TextPrompt("Buscar...", jTextField1);
        Clases.botonConImagen.ajustarImagenDinamicamente(minimizar, "/imagenes/ocultar.png");
        Clases.botonConImagen.ajustarImagenDinamicamente(jb_atras, "/imagenes/salir.png");
        Clases.CargarCombox.cargar(jComboBox1, preventista, "preventista", "id_preventista", "nombre_preventista", "Seleccionar el Preventista", "Agregar Preventista");
        Clases.tablaStyle.personalizarJTable(jTable1, jScrollPane1);
        // Establecer que las celdas no sean editables, excepto la última columna (Pago)
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            if (i != 6) {  // Solo la columna 6 (Pago) será editable
                jTable1.getColumnModel().getColumn(i).setCellEditor(new DefaultCellEditor(new JTextField()) {
                    // No hacer nada si el usuario intenta editar las celdas de columnas no editables
                    public boolean isCellEditable(EventObject anEvent) {
                        return false;
                    }
                });
            }
        }
    }
    
    void listener(){
        jb_atras.addActionListener(e -> {
        ventanaAnterior.setVisible(true);
        dispose();
        });
        
        jComboBox1.setSelectedIndex(1);
        jComboBox1.addActionListener(e -> {
        buscar();
        jTextField2.setText(String.valueOf(calcularTotal(modelo, 4)));
        });
        
        jTable1.getColumnModel().getColumn(3).setMinWidth(0);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(3).setWidth(0);
        modelo = (DefaultTableModel) jTable1.getModel();
        modelo.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // Solo reaccionar cuando se actualiza una celda
                if (e.getType() != TableModelEvent.UPDATE) return;

                int row = e.getFirstRow();
                int column = e.getColumn();

                // Recalculamos el total siempre (esto es válido)
                jTextField2.setText(String.valueOf(calcularTotal(modelo, 4)));
                
                if (column == 6) { // Columna "Pago"
                    Object saldoObj = modelo.getValueAt(row, 4);
                    Object pagoObj = modelo.getValueAt(row, 6);

                    if (saldoObj != null && pagoObj != null) {
                        try {
                            // Convertimos a double de forma segura
                            double saldo = Double.parseDouble(saldoObj.toString());
                            double pago = Double.parseDouble(pagoObj.toString());

                            if (pago <= saldo) {
                                double nuevoSaldo = saldo - pago;
                                modelo.setValueAt(nuevoSaldo, row, 4); // Actualiza saldo
                                // ✅ Si saldo es 0, cambia estado a "Pagado"
                                if (nuevoSaldo <= 0.0) {
                                    modelo.setValueAt("Pagado", row, 5); // Columna "Estado"
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                    "El pago no puede ser mayor al saldo.",
                                    "Error de Pago", JOptionPane.ERROR_MESSAGE);
                            }

                            // Limpiar la celda de pago
                            modelo.setValueAt(null, row, 6);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null,
                                "Por favor, ingrese un número válido en la columna de Pago.",
                                "Error de formato", JOptionPane.ERROR_MESSAGE);

                            // Limpiar celda errónea
                            modelo.setValueAt(null, row, 6);
                        }
                    }
                }
                if (column == 4) { // columna Saldo modificada
                    try {
                        int ro = e.getFirstRow();
                        int id = (int) modelo.getValueAt(ro, 3); // columna 3: ID
                        Float nuevoSaldo = Float.parseFloat(modelo.getValueAt(ro, 4).toString());

                        filasModificadas.put(id, nuevoSaldo); // marcar esta fila como modificada
                    } catch (Exception ex) {
                        // manejo opcional
                    }
                }
            }
        });
    }
    
    void carga(){
            jTextField1.getDocument().addDocumentListener(new DocumentListener() {
                public void insertUpdate(DocumentEvent e) {
                    buscar();
                    jTextField2.setText(String.valueOf(calcularTotal(modelo, 4)));
                }

                public void removeUpdate(DocumentEvent e) {
                    buscar();
                    jTextField2.setText(String.valueOf(calcularTotal(modelo, 4)));
                }

                public void changedUpdate(DocumentEvent e) {
                    buscar();
                    jTextField2.setText(String.valueOf(calcularTotal(modelo, 4)));
                }
            });
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jb_atras = new javax.swing.JButton();
        minimizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestor de Fiados");

        jb_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jTable1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Cliente", "Monto", "id", "Saldo", "Estado", "Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Total   $");

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setText("0.0");
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 153)));

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 749, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 137, 137)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private double calcularTotal(DefaultTableModel modelo, int columna) {
            float total = 0;
            for (int i = 0; i < modelo.getRowCount(); i++) {
                Object valor = modelo.getValueAt(i, columna);
                if (valor != null && !valor.toString().isEmpty()) {
                    try {
                        total += Float.parseFloat(valor.toString());
                    } catch (NumberFormatException e) {
                        System.err.println("Error en fila " + i + ": " + valor);
                    }
                }
            }
            return total;
    }
    private void buscar(){
        Connection con = Conexion.Conexion.conexion();
        int preve = preventista.get(jComboBox1.getSelectedItem().toString());
        String nom = jTextField1.getText();
        try{
            ResultSet rs = Clases.Fiado.Buscar(con, preve, nom);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            while (rs.next()){
                Object[] fila = {
                    rs.getDate("fecha_rendicion"),
                    rs.getString("nombre_cliente"),
                    rs.getFloat("monto"),
                    rs.getInt("id_detal_fiado"),
                    rs.getFloat("saldo"),
                    rs.getString("estadp")
                };
                modelo.addRow(fila);
            }
            rs.close();
            con.close();
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(this, "Error al buscar el cliente "+ex.getMessage());
        }
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        buscar();
        Clases.ImagenUtil.cargarEnLabel("src/imagenes/buscar10.jpg", jLabel2);
    }//GEN-LAST:event_formWindowOpened
    
    private void minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizarActionPerformed
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (filasModificadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay cambios para guardar.");
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = Conexion.Conexion.conexion();

            for (int i = 0; i < modelo.getRowCount(); i++) {
                int id = (int) modelo.getValueAt(i, 3); // ID
                if (!filasModificadas.containsKey(id)) continue;

                float nuevoSaldo = filasModificadas.get(id);
                String estado = String.valueOf(modelo.getValueAt(i, 5));

                String sql = "UPDATE detalle_fiado SET saldo = ?, estadp = ? WHERE id_detal_fiado = ?";
                ps = con.prepareStatement(sql);
                ps.setFloat(1, nuevoSaldo);
                ps.setString(2, estado);
                ps.setInt(3, id);
                ps.executeUpdate();
            }

            JOptionPane.showMessageDialog(this, "Cambios guardados correctamente.");
            filasModificadas.clear();
            buscar(); // recargar datos

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                // log o ignorar
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Fiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fiado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Fiado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jb_atras;
    private javax.swing.JButton minimizar;
    // End of variables declaration//GEN-END:variables
}
