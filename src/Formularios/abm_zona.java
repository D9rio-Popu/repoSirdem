
package Formularios;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;
import javafx.scene.control.ScrollBar;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
//import javax.swing.table.JTableHeader;

public class abm_zona extends javax.swing.JFrame {

    Connection con = Conexion.Conexion.conexion();
    JFrame ventanaAnterior;
    private boolean modific = false;
    
    public abm_zona(JFrame called) {
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        componentdesactivado();
        nom_buscar.setDocument(new Clases.Validaciones.LimiteCaracteres(15));
        nombre.setDocument(new Clases.Validaciones.LimiteCaracteres(15));
        carga();
        botonGroup();
        this.ventanaAnterior = called;
        atras.addActionListener(e -> {
        ventanaAnterior.setVisible(true);
        dispose();
        });
        personalizacion();
    }

    void componentdesactivado(){
        id_zona.setVisible(false);
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
        agregar.setEnabled(true);
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
        
        filtroActivo.addActionListener(e -> { Clases.Filtro.aplicarFiltro(jTableZona, 2, "Activo");});
        filtroInactivo.addActionListener(e -> { Clases.Filtro.aplicarFiltro(jTableZona, 2, "Inactivo");});
        filtroTodo.addActionListener(e -> { Clases.Filtro.aplicarFiltro(jTableZona, 2, "Todo");});
        
        buttonGroup1.add(jRadioButtonActivo);
        buttonGroup1.add(jRadioButtonInactivo);
    }
    
    void personalizacion(){
        // Cambiar bordes en foco
        Clases.FocusBorderChanger.aplicar(nom_buscar, new Color(0, 153, 255), Color.GRAY); // celeste
        Clases.FocusBorderChanger.aplicar(nombre, new Color(0, 153, 255), Color.GRAY);
        // Aplica imagen al botón
        Clases.botonConImagen.ajustarImagenDinamicamente(atras, "/imagenes/salir.png");
        Clases.botonConImagen.ajustarImagenDinamicamente(minimizar, "/imagenes/ocultar.png");
        // Placeholder para campo de búsqueda
        new Clases.TextPrompt("Buscar...", nom_buscar);
        new Clases.TextPrompt("Nombre de la Zona (*)", nombre);
        //Estilo al jTable
        Clases.tablaStyle.personalizarJTable(jTableZona, jScrollPane1);
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
        atras = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        minimizar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jRadioButtonActivo = new javax.swing.JRadioButton();
        jRadioButtonInactivo = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

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
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        nom_buscar.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        nom_buscar.setToolTipText("Buscar por nombre de la zona");
        nom_buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));

        jLabel4.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N

        id_zona.setText("id_zona");

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jTableZona.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
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
        jTableZona.setGridColor(new java.awt.Color(255, 255, 255));
        jTableZona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableZonaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableZona);

        agregar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        agregar.setText("Agregar");
        agregar.setToolTipText("");
        agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)), "Filtro por Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Mincho Demibold", 3, 14))); // NOI18N

        filtroActivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filtroActivo.setText("Activo");
        filtroActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        filtroInactivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filtroInactivo.setText("Inactivo");
        filtroInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        filtroTodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filtroTodo.setText("Todos");
        filtroTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(filtroInactivo)
                .addGap(32, 32, 32)
                .addComponent(filtroTodo)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroActivo)
                    .addComponent(filtroInactivo)
                    .addComponent(filtroTodo))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        cancelar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setToolTipText("");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        guardar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        guardar.setText("Guardar");
        guardar.setToolTipText("");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        modificar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        modificar.setText("Modificar");
        modificar.setToolTipText("");
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 0, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        atras.setBackground(new java.awt.Color(0, 0, 204));
        atras.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        atras.setForeground(new java.awt.Color(255, 255, 255));
        atras.setToolTipText("Salir");
        atras.setBorder(null);
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gestión de Zonas");

        minimizar.setBackground(new java.awt.Color(0, 0, 204));
        minimizar.setFont(new java.awt.Font("Arial Unicode MS", 1, 12)); // NOI18N
        minimizar.setForeground(new java.awt.Color(255, 255, 255));
        minimizar.setToolTipText("Minimizar");
        minimizar.setBorder(null);
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(minimizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(atras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jRadioButtonActivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonActivo.setText("Activo");
        jRadioButtonActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRadioButtonInactivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButtonInactivo.setText("Inactivo");
        jRadioButtonInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N

        nombre.setFont(new java.awt.Font("Arial Unicode MS", 0, 18)); // NOI18N
        nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nombre.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        nombre.setSelectedTextColor(new java.awt.Color(109, 109, 109));

        jLabel2.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(agregar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(modificar)
                        .addGap(23, 23, 23)
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(id_zona))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButtonActivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonInactivo))
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(id_zona)
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButtonInactivo)
                                        .addComponent(jRadioButtonActivo))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                modific = false;
            }
            rs.close();
            con.close();
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(this,"Error al buscar la zona " +ex.getMessage());
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Clases.ImagenUtil.cargarEnLabel("src/imagenes/elimina.png", jLabel3);
        Clases.ImagenUtil.cargarEnLabel("src/imagenes/buscar10.jpg", jLabel4);
        Clases.ImagenUtil.cargarEnLabel("src/imagenes/ubicacion.jpg", jLabel2);
        buscar();
    }//GEN-LAST:event_formWindowOpened

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        // TODO add your handling code here:
        nom_buscar.setText("");
        componentactivo();
        agregar.setEnabled(false);
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

    private void minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizarActionPerformed
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarActionPerformed

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
                //new abm_zona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JButton atras;
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
    private javax.swing.JRadioButton jRadioButtonActivo;
    private javax.swing.JRadioButton jRadioButtonInactivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableZona;
    private javax.swing.JButton minimizar;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nom_buscar;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
