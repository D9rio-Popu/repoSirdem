
package Formularios;

import Clases.ImagenUtil;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
//import javax.swing.table.JTableHeader;

public class abm_zona extends javax.swing.JFrame {

    Connection con = Conexion.Conexion.conexion();
    private boolean modific = false;
    
    public abm_zona() {
        this.setUndecorated(true);
        initComponents();
        id_zona.setVisible(false);
        setLocationRelativeTo(null);
        componentdesactivado();
        nom_buscar.setDocument(new Clases.Validaciones.LimiteCaracteres(15));
        nombre.setDocument(new Clases.Validaciones.LimiteCaracteres(15));
        carga();
        botonGroup();
        colorjTable();
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
        nombre.setBackground(Color.WHITE);
        nombre.setDisabledTextColor(Color.BLACK); // texto negro estando desactivado
        nombre.setOpaque(true);
        filtroActivo.addActionListener(e -> aplicarFiltro());
        filtroInactivo.addActionListener(e -> aplicarFiltro());
        filtroTodo.addActionListener(e -> aplicarFiltro());
    }
    
    void componentactivo(){
        nombre.setEnabled(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }
    
    void botonGroup(){
        buttonGroup2.add(filtroActivo);
        buttonGroup2.add(filtroInactivo);
        buttonGroup2.add(filtroTodo);
        filtroTodo.setSelected(true);
        
        buttonGroup1.add(jRadioButtonActivo);
        buttonGroup1.add(jRadioButtonInactivo);
    }
    
    void colorjTable(){
        //ENCABEZADO DEL TABLE
        jTableZona.getTableHeader().setBackground(Color.decode("#4682B4"));
        jTableZona.getTableHeader().setForeground(Color.WHITE);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        nom_buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        id_zona = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableZona = new javax.swing.JTable();
        agregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        filtroActivo = new javax.swing.JRadioButton();
        filtroInactivo = new javax.swing.JRadioButton();
        filtroTodo = new javax.swing.JRadioButton();
        cancelar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jb_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jb_atras = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jRadioButtonInactivo = new javax.swing.JRadioButton();
        jRadioButtonActivo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Zona");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        nom_buscar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        nom_buscar.setToolTipText("");
        nom_buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel4.setText("Ingrese la zona a Buscar:");

        id_zona.setText("id_zona");

        jTableZona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N°", "Nombre", "Estado"
            }
        ));
        jTableZona.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTableZona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableZonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableZona);

        agregar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        agregar.setText("Agregar");
        agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)), "Filtro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Mincho Demibold", 3, 14))); // NOI18N

        filtroActivo.setText("Activo");
        filtroActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        filtroInactivo.setText("Inactivo");
        filtroInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        filtroTodo.setText("Todos");
        filtroTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroActivo)
                .addGap(26, 26, 26)
                .addComponent(filtroInactivo)
                .addGap(44, 44, 44)
                .addComponent(filtroTodo)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroActivo)
                    .addComponent(filtroInactivo)
                    .addComponent(filtroTodo))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        cancelar.setBackground(new java.awt.Color(255, 0, 0));
        cancelar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cancelar.setForeground(new java.awt.Color(255, 255, 255));
        cancelar.setText("Cancelar");
        cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        guardar.setBackground(new java.awt.Color(53, 53, 255));
        guardar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Guardar");
        guardar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        modificar.setBackground(new java.awt.Color(53, 53, 255));
        modificar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setText("Modificar");
        modificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jb_salir.setBackground(new java.awt.Color(102, 102, 255));
        jb_salir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jb_salir.setForeground(new java.awt.Color(255, 255, 255));
        jb_salir.setText("SALIR");
        jb_salir.setBorder(null);
        jb_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 0, 36)); // NOI18N
        jLabel1.setText("Gestión Zonas");

        jb_atras.setBackground(new java.awt.Color(102, 102, 255));
        jb_atras.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jb_atras.setForeground(new java.awt.Color(255, 255, 255));
        jb_atras.setText("VOLVER");
        jb_atras.setBorder(null);
        jb_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jb_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(0, 26, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jb_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)), "Datos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jRadioButtonInactivo.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jRadioButtonInactivo.setText("Inactivo");
        jRadioButtonInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRadioButtonActivo.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jRadioButtonActivo.setText("Activo");
        jRadioButtonActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jRadioButtonActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonActivoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel2.setText("Nombre:");

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        nombre.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        nombre.setSelectedTextColor(new java.awt.Color(109, 109, 109));

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jLabel3.setText("Estado:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jRadioButtonActivo)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonInactivo))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonInactivo)
                    .addComponent(jRadioButtonActivo)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_zona)
                        .addGap(7, 7, 7))))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(agregar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(agregar)
                    .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id_zona)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void aplicarFiltro() {
        DefaultTableModel modelo = (DefaultTableModel) jTableZona.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        jTableZona.setRowSorter(sorter);

        if (filtroActivo.isSelected()) {
            sorter.setRowFilter(RowFilter.regexFilter("Activo", 2)); // columna 2 = Estado
        } else if (filtroInactivo.isSelected()) {
            sorter.setRowFilter(RowFilter.regexFilter("Inactivo", 2));
        } else {
            sorter.setRowFilter(null); // muestra todo
        }
    }
    
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

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jb_salirActionPerformed

    private void jb_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_atrasActionPerformed
        ventanaPrincipal vp = new ventanaPrincipal();
        vp.setVisible(true);
        dispose();
    }//GEN-LAST:event_jb_atrasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //ImagenUtil.agregarFondoAFrame(this, "src/imagenes/fondo_app5.jpg");
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

    private void jTableZonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableZonaMouseClicked
        // TODO add your handling code here:
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
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancelar;
    private javax.swing.JRadioButton filtroActivo;
    private javax.swing.JRadioButton filtroInactivo;
    private javax.swing.JRadioButton filtroTodo;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel id_zona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
