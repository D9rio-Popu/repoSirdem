
package Formularios;

import Clases.ImagenUtil;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class abm_cliente extends javax.swing.JFrame {

    Connection con = Conexion.Conexion.conexion();
    JFrame ventanaAnterior;
    private boolean modific = false;

    public abm_cliente(JFrame called) {
        this.setUndecorated(true);
        initComponents();
        id_cliente.setVisible(false);
        setLocationRelativeTo(null);
        componentdesactivado();
        nom_buscar.setDocument(new Clases.Validaciones.LimiteSoloLetras(10));
        nombre.setDocument(new Clases.Validaciones.LimiteSoloLetras(10));
        apellido.setDocument(new Clases.Validaciones.LimiteSoloLetras(10));
        telefono.setDocument(new Clases.Validaciones.LimiteNumeros(10));
        direccion.setDocument(new Clases.Validaciones.LimiteSoloLetras(20));
        carga();
        botonGroup();
        this.ventanaAnterior = called;
        jb_atras.addActionListener(e -> {
        ventanaAnterior = called;
        ventanaAnterior.setVisible(true);
        dispose();});
        // Cambiar bordes en foco
        Clases.FocusBorderChanger.aplicar(nom_buscar, new Color(0, 153, 255), Color.GRAY); // celeste
        Clases.FocusBorderChanger.aplicar(nombre, new Color(0, 153, 255), Color.GRAY);
        Clases.FocusBorderChanger.aplicar(apellido, new Color(0, 153, 255), Color.GRAY);
        Clases.FocusBorderChanger.aplicar(direccion, new Color(0, 153, 255), Color.GRAY);
        Clases.FocusBorderChanger.aplicar(telefono, new Color(0, 153, 255), Color.GRAY);
        // Aplica imagen al botón
        Clases.botonConImagen.ajustarImagenDinamicamente(jb_salir, "/imagenes/salir.png");
        Clases.botonConImagen.ajustarImagenDinamicamente(minimizar, "/imagenes/ocultar.png");
        Clases.botonConImagen.ajustarImagenDinamicamente(jb_atras, "/imagenes/anterior.png");
        // Placeholder para campo de búsqueda
        new Clases.TextPrompt("Buscar...", nom_buscar);
        // Placeholder para campo nombre
        new Clases.TextPrompt("Nombre del Cliente (*)", nombre);
        new Clases.TextPrompt("Apellido del Cliente (*)", apellido);
        new Clases.TextPrompt("Direccion (*)", direccion);
        new Clases.TextPrompt("Telefono (*)", telefono);
        Clases.tablaStyle.personalizarJTable(jTable1, jScrollPane1);
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
        nombre.setBackground(Color.WHITE);
        nombre.setDisabledTextColor(Color.BLACK); // texto negro estando desactivado
        nombre.setOpaque(true);
        apellido.setBackground(Color.WHITE);
        apellido.setDisabledTextColor(Color.BLACK); // texto negro estando desactivado
        apellido.setOpaque(true);
        direccion.setBackground(Color.WHITE);
        direccion.setDisabledTextColor(Color.BLACK); // texto negro estando desactivado
        direccion.setOpaque(true);
        telefono.setBackground(Color.WHITE);
        telefono.setDisabledTextColor(Color.BLACK); // texto negro estando desactivado
        telefono.setOpaque(true);
        agregar.setEnabled(true);
    }
    
    void componentactivo(){
        nombre.setEnabled(true);
        apellido.setEnabled(true);
        telefono.setEnabled(true);
        direccion.setEnabled(true);
        guardar.setEnabled(true);
        cancelar.setEnabled(true);
    }
    
    void botonGroup(){
        buttonGroup2.add(filtroActivo);
        buttonGroup2.add(filtroInactivo);
        buttonGroup2.add(filtroTodo);
        filtroTodo.setSelected(true);
        
        filtroActivo.addActionListener(e -> { Clases.Filtro.aplicarFiltro(jTable1, 5, "Activo");});
        filtroInactivo.addActionListener(e -> { Clases.Filtro.aplicarFiltro(jTable1, 5, "Inactivo");});
        filtroTodo.addActionListener(e -> { Clases.Filtro.aplicarFiltro(jTable1, 5, "Todo");});
        
        buttonGroup1.add(jRadioButtonActivo);
        buttonGroup1.add(jRadioButtonInactivo);
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
        jPopupMenu1 = new javax.swing.JPopupMenu();
        id_cliente = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        minimizar = new javax.swing.JButton();
        jb_salir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jb_atras = new javax.swing.JButton();
        nom_buscar = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        nombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonActivo = new javax.swing.JRadioButton();
        jRadioButtonInactivo = new javax.swing.JRadioButton();
        modificar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        filtroActivo = new javax.swing.JRadioButton();
        filtroInactivo = new javax.swing.JRadioButton();
        filtroTodo = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        id_cliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        minimizar.setBackground(new java.awt.Color(0, 0, 204));
        minimizar.setToolTipText("Minimizar");
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizarActionPerformed(evt);
            }
        });

        jb_salir.setBackground(new java.awt.Color(0, 0, 204));
        jb_salir.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jb_salir.setToolTipText("Salir");
        jb_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jb_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_salirActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(0, 0, 204));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestión de Clientes");

        jb_atras.setBackground(new java.awt.Color(0, 0, 204));
        jb_atras.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jb_atras.setForeground(new java.awt.Color(255, 255, 255));
        jb_atras.setToolTipText("Atras");
        jb_atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291)
                .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(26, 26, 26))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_salir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_atras, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        nom_buscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nom_buscar.setToolTipText("Buscar por el Nombre del Cliente");
        nom_buscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        agregar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        agregar.setText("Agregar");
        agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jTable1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
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
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        nombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N

        apellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        apellido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N

        telefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        telefono.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N

        direccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        direccion.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N

        jRadioButtonActivo.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jRadioButtonActivo.setText("Activo");
        jRadioButtonActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jRadioButtonInactivo.setFont(new java.awt.Font("Modern No. 20", 0, 24)); // NOI18N
        jRadioButtonInactivo.setText("Inactivo");
        jRadioButtonInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        modificar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        modificar.setText("Modificar");
        modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        guardar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        guardar.setText("Guardar");
        guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        cancelar.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 204)), "Filtro por Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Yu Mincho Demibold", 3, 14))); // NOI18N

        filtroActivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filtroActivo.setText("Activo");
        filtroActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        filtroInactivo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filtroInactivo.setText("Inactivo");
        filtroInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        filtroTodo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filtroTodo.setText("Todos");
        filtroTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtroActivo)
                .addGap(18, 18, 18)
                .addComponent(filtroInactivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(filtroTodo)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filtroActivo)
                    .addComponent(filtroInactivo)
                    .addComponent(filtroTodo))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agregar)))
                .addGap(56, 56, 56)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(modificar)
                        .addGap(18, 18, 18)
                        .addComponent(guardar)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonActivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonInactivo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nom_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(telefono)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(direccion)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButtonActivo)
                                        .addComponent(jRadioButtonInactivo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(276, 276, 276))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(id_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                
                modific = false;
            }
            rs.close();
            con.close();
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(this, "Error al buscar el cliente "+ex.getMessage());
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

    private void jb_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jb_salirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //ImagenUtil.agregarFondoAFrame(this, "src/imagenes/fondo_app5.jpg");
        ImagenUtil.cargarEnLabel("src/imagenes/elimina.png", jLabel6);
        ImagenUtil.cargarEnLabel("src/imagenes/buscar10.jpg", jLabel5);
        ImagenUtil.cargarEnLabel("src/imagenes/telefono.png", jLabel3);
        ImagenUtil.cargarEnLabel("src/imagenes/direccion.png", jLabel4);
        ImagenUtil.cargarEnLabel("src/imagenes/cliente.png", jLabel1);
        buscar();
    }//GEN-LAST:event_formWindowOpened

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        nom_buscar.setText("");
        componentactivo();
        jRadioButtonActivo.setEnabled(true);
        jRadioButtonActivo.setSelected(true);
        jRadioButtonInactivo.setEnabled(false);
        agregar.setEnabled(false);
    }//GEN-LAST:event_agregarActionPerformed

    private void minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizarActionPerformed
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarActionPerformed

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
                //new abm_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField apellido;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField direccion;
    private javax.swing.JRadioButton filtroActivo;
    private javax.swing.JRadioButton filtroInactivo;
    private javax.swing.JRadioButton filtroTodo;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel id_cliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButtonActivo;
    private javax.swing.JRadioButton jRadioButtonInactivo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_atras;
    private javax.swing.JButton jb_salir;
    private javax.swing.JButton minimizar;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nom_buscar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
