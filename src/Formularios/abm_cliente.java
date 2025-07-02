
package Formularios;

import Clases.ImagenUtil;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class abm_cliente extends javax.swing.JFrame {

    Connection con = Conexion.Conexion.conexion();
    
    private boolean modific = false;

    public abm_cliente() {
        this.setUndecorated(true);
        initComponents();
        id_cliente.setVisible(false);
        setLocationRelativeTo(null);
        componentdesactivado();
        buttonGroup1.add(jRadioButtonActivo);
        buttonGroup1.add(jRadioButtonInactivo);
        nom_buscar.setDocument(new Clases.Validaciones.LimiteSoloLetras(10));
        nombre.setDocument(new Clases.Validaciones.LimiteSoloLetras(10));
        apellido.setDocument(new Clases.Validaciones.LimiteSoloLetras(10));
        telefono.setDocument(new Clases.Validaciones.LimiteNumeros(10));
        direccion.setDocument(new Clases.Validaciones.LimiteSoloLetras(20));
        carga();
    }

    void componentdesactivado(){
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        direccion.setText("");
        buttonGroup1.clearSelection();
        nombre.setEnabled(false);
        apellido.setEnabled(false);
        telefono.setEnabled(false);
        direccion.setEnabled(false);
        jRadioButtonActivo.setEnabled(false);
        jRadioButtonInactivo.setEnabled(false);
        agregar.setEnabled(false);
        modificar.setEnabled(false);
        guardar.setEnabled(false);
        cancelar.setEnabled(false);
    }
    
    void componentactivo(){
        nombre.setEnabled(true);
        apellido.setEnabled(true);
        telefono.setEnabled(true);
        direccion.setEnabled(true);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        nom_buscar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonActivo = new javax.swing.JRadioButton();
        jRadioButtonInactivo = new javax.swing.JRadioButton();
        id_cliente = new javax.swing.JLabel();
        jb_salir = new javax.swing.JButton();
        jb_atras = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        jb_activo = new javax.swing.JButton();
        jb_inactivo = new javax.swing.JButton();
        jb_todos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel2.setText("Apellido:");

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel3.setText("Teléfono:");

        jLabel4.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel4.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Modern No. 20", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestión Clientes");

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        apellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        direccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N°", "Nombre", "Apellido", "Telefono", "Direccion", "Estado"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        guardar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

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

        nom_buscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel5.setText("Ingrese el nombre del cliente:");

        jLabel6.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel6.setText("Estado:");

        jRadioButtonActivo.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jRadioButtonActivo.setText("Activo");

        jRadioButtonInactivo.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jRadioButtonInactivo.setText("Inactivo");

        id_cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

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
        jb_atras.setText("ANTERIOR");
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

        agregar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jb_activo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jb_activo.setText("Activos");
        jb_activo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_activoActionPerformed(evt);
            }
        });

        jb_inactivo.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jb_inactivo.setText("Inactivos");
        jb_inactivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_inactivoActionPerformed(evt);
            }
        });

        jb_todos.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jb_todos.setText("Todos");
        jb_todos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_todosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(302, 302, 302)
                                .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel5)
                                            .addGap(214, 214, 214)
                                            .addComponent(agregar))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(377, 377, 377)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(95, 95, 95)
                                        .addComponent(jb_activo)
                                        .addGap(69, 69, 69)
                                        .addComponent(jb_todos)
                                        .addGap(62, 62, 62)
                                        .addComponent(jb_inactivo)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(313, 313, 313)
                                        .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButtonActivo)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButtonInactivo)
                                                .addGap(138, 138, 138))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(modificar)
                                                .addGap(46, 46, 46)
                                                .addComponent(guardar)))))))
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jb_atras)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(id_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jb_atras)
                            .addComponent(jb_salir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar))
                        .addGap(10, 10, 10)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jRadioButtonActivo)
                            .addComponent(jRadioButtonInactivo)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guardar)
                        .addComponent(cancelar)
                        .addComponent(modificar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jb_activo)
                        .addComponent(jb_inactivo)
                        .addComponent(jb_todos)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscar(){
        Connection con = Conexion.Conexion.conexion();
        String nom = nom_buscar.getText();
        try{
            ResultSet rs = Clases.Cliente.Buscar(con, nom);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            boolean encontrado = false;
            while (rs.next()){
                Object[] fila = {
                    rs.getInt("id_clientes"),
                    rs.getString("nombre_cliente"),
                    rs.getString("apellido_cliente"),
                    rs.getString("telefono_cliente"),
                    rs.getString("direccion_cliente"),
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
            JOptionPane.showMessageDialog(this, "Error al buscar el cliente "+ex.getMessage());
        }
    }
    
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
        componentdesactivado();
    }//GEN-LAST:event_cancelarActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada >= 0){
            id_cliente.setText(jTable1.getValueAt(filaSeleccionada, 0).toString());
            nombre.setText(jTable1.getValueAt(filaSeleccionada, 1).toString());
            apellido.setText(jTable1.getValueAt(filaSeleccionada, 2).toString());
            telefono.setText(jTable1.getValueAt(filaSeleccionada, 3).toString());
            direccion.setText(jTable1.getValueAt(filaSeleccionada, 4).toString());
            buttonGroup1.setSelected(
                "Activo".equals(jTable1.getValueAt(filaSeleccionada, 5).toString()) ? jRadioButtonActivo.getModel() : 
                "Inactivo".equals(jTable1.getValueAt(filaSeleccionada, 5).toString()) ? jRadioButtonInactivo.getModel() : null,
                true
            );
            modificar.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        // TODO add your handling code here:
        componentactivo();
        jRadioButtonActivo.setEnabled(true);
        jRadioButtonInactivo.setEnabled(true);
        modific = true;
        modificar.setEnabled(false);
    }//GEN-LAST:event_modificarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
            int estado = jRadioButtonActivo.isSelected() ? 1 : 0;
            if (modific){
                int idd = Integer.parseInt(id_cliente.getText());
                try{
                    Clases.Cliente.Modificar(con, nombre.getText(), apellido.getText(), telefono.getText(), direccion.getText(), estado, idd);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Error no se puede modificar" +ex.getMessage());
                }
            }else{
                try{
                    Clases.Cliente.Insertar(con, nombre.getText(), apellido.getText(), telefono.getText(), direccion.getText(), estado);
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(this, "Error no pudo cargar el cliente "+ex.getMessage());
                }
            }
            componentdesactivado();
            buscar();
            modific = false;
    }//GEN-LAST:event_guardarActionPerformed

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ImagenUtil.agregarFondoAFrame(this, "src/imagenes/fondo_app5.jpg");
        buscar();
    }//GEN-LAST:event_formWindowOpened

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        nom_buscar.setText("");
        componentactivo();
        jRadioButtonActivo.setEnabled(true);
        jRadioButtonActivo.setSelected(true);
        jRadioButtonInactivo.setEnabled(false);
    }//GEN-LAST:event_agregarActionPerformed

    private void modificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modificar1ActionPerformed

    private void jb_activoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_activoActionPerformed
        try{
            ResultSet rs = Clases.Cliente.mostrarEstado(con, 1);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            while (rs.next()){
                Object[] fila = {
                    rs.getInt("id_clientes"),
                    rs.getString("nombre_cliente"),
                    rs.getString("apellido_cliente"),
                    rs.getString("telefono_cliente"),
                    rs.getString("direccion_cliente"),
                    rs.getString("estado_cliente")
                };
                modelo.addRow(fila);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_jb_activoActionPerformed

    private void jb_inactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_inactivoActionPerformed
        try{
            ResultSet rs = Clases.Cliente.mostrarEstado(con, 0);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            while (rs.next()){
                Object[] fila = {
                    rs.getInt("id_clientes"),
                    rs.getString("nombre_cliente"),
                    rs.getString("apellido_cliente"),
                    rs.getString("telefono_cliente"),
                    rs.getString("direccion_cliente"),
                    rs.getString("estado_cliente")
                };
                modelo.addRow(fila);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_jb_inactivoActionPerformed

    private void jb_todosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_todosActionPerformed
         try{
            ResultSet rs = Clases.Cliente.mostrarClientes(con);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);
            while (rs.next()){
                Object[] fila = {
                    rs.getInt("id_clientes"),
                    rs.getString("nombre_cliente"),
                    rs.getString("apellido_cliente"),
                    rs.getString("telefono_cliente"),
                    rs.getString("direccion_cliente"),
                    rs.getString("estado_cliente")
                };
                modelo.addRow(fila);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error: "+ex.getMessage());
        }
    }//GEN-LAST:event_jb_todosActionPerformed

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
            java.util.logging.Logger.getLogger(abm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(abm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(abm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(abm_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new abm_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField apellido;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField direccion;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel id_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButtonActivo;
    private javax.swing.JRadioButton jRadioButtonInactivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_activo;
    private javax.swing.JButton jb_atras;
    private javax.swing.JButton jb_inactivo;
    private javax.swing.JButton jb_salir;
    private javax.swing.JButton jb_todos;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nom_buscar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
