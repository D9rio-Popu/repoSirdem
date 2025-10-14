/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author alumno
 */
public class rendiciones extends javax.swing.JFrame {

    Connection con = Conexion.Conexion.conexion();    
    private Map<String, Integer> preventista = new HashMap<>();
    private Map<String, Integer> zona = new HashMap<>();
    private Map<String, Integer> marcamap = new HashMap<>();
    private JTable tablaDestinoActual;
    private String tablaActual;
    private String campoIdActual;
    private String campoNombreActual;
    DefaultTableModel modelo;
    DefaultTableModel modelo3;
    DefaultTableModel modelo5;
    DefaultTableModel modelodevuelto;
    DefaultTableModel modelofiado;
    
    /**
     * Creates new form rendiciones
     */
    public rendiciones() {
        this.setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        modelosTablas();
        componentdesactivado();
        personalizacion();
        listener();
        componentvisible();
    }
   
    void componentdesactivado(){
        diferencia.setEditable(false);
        totalTra.setEditable(false);
        totalFia.setEditable(false);
        totalGasto.setEditable(false);
        ptCalculado.setEditable(false);
        talCalculado.setEditable(false);
        talGeneral.setEditable(false);
    }
    
    void componentvisible(){
        jTableTransferencia.getColumnModel().getColumn(0).setMinWidth(0);
        jTableTransferencia.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableTransferencia.getColumnModel().getColumn(0).setWidth(0);
        jTableFiado.getColumnModel().getColumn(0).setMinWidth(0);
        jTableFiado.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableFiado.getColumnModel().getColumn(0).setWidth(0);
        jTableGasto.getColumnModel().getColumn(0).setMinWidth(0);
        jTableGasto.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableGasto.getColumnModel().getColumn(0).setWidth(0);
        jTableDevolucion.getColumnModel().getColumn(0).setMinWidth(0);
        jTableDevolucion.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableDevolucion.getColumnModel().getColumn(0).setWidth(0);
        jTablePrDevuelto.getColumnModel().getColumn(0).setMinWidth(0);
        jTablePrDevuelto.getColumnModel().getColumn(0).setMaxWidth(0);
        jTablePrDevuelto.getColumnModel().getColumn(0).setWidth(0);
        boton4.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel34.setVisible(false);
        jTextField4.setVisible(false);
        monto.setVisible(false);
        jTextField1.setVisible(false);
    }
    
    void modelosTablas(){
        modelo = (DefaultTableModel) jTableTransferencia.getModel();
        modelo.setRowCount(0); // Esto limpia todas las filas
        modelo3 = (DefaultTableModel) jTableDevolucion.getModel();
        modelo3.setRowCount(0); // Esto limpia todas las filas
        modelo5 = (DefaultTableModel) jTableGasto.getModel();
        modelo5.setRowCount(0); // Esto limpia todas las filas
        modelodevuelto = (DefaultTableModel) jTablePrDevuelto.getModel();
        modelodevuelto.setRowCount(0); // Esto limpia todas las filas
        modelofiado = (DefaultTableModel) jTableFiado.getModel();
        modelofiado.setRowCount(0); // Esto limpia todas las filas
    }
     
    void personalizacion(){
        Clases.botonConImagen.ajustarImagenDinamicamente(atras, "/imagenes/salir.png");
        Clases.botonConImagen.ajustarImagenDinamicamente(minimizar, "/imagenes/ocultar.png");
        
        Clases.tablaStyle.personalizarJTable(jTableTransferencia, jScrollPane1);
        Clases.tablaStyle.personalizarJTable(jTableGasto, jScrollPane4);
        Clases.tablaStyle.personalizarJTable(jTableDevolucion, jScrollPane5);
        Clases.tablaStyle.personalizarJTable(jTablePrDevuelto, jScrollPane6);
        Clases.tablaStyle.personalizarJTable(jTableFiado, jScrollPane3);
        
        agregarMenuEliminar(jTableTransferencia, modelo);
        agregarMenuEliminar(jTableDevolucion, modelo3);
        agregarMenuEliminar(jTableGasto, modelo5);
        agregarMenuEliminar(jTableFiado, modelofiado);
        agregarMenuEliminar(jTablePrDevuelto, modelodevuelto);
        
        Clases.FocusBorderChanger.aplicar(jTextField4, new Color(0, 153, 255), Color.GRAY);
        Clases.FocusBorderChanger.aplicar(monto, new Color(0, 153, 255), Color.GRAY);
        Clases.FocusBorderChanger.aplicar(jTextField1, new Color(0, 153, 255), Color.GRAY);
        new Clases.TextPrompt("Buscar...", jTextField4);
        Clases.FocusBorderChanger.aplicar(ptIngresado, new Color(0, 153, 255), Color.GRAY);
        Clases.FocusBorderChanger.aplicar(talIngresado, new Color(0, 153, 255), Color.GRAY);
        Clases.FocusBorderChanger.aplicar(cobranza, new Color(0, 153, 255), Color.GRAY);
        Clases.FocusBorderChanger.aplicar(efectivo, new Color(0, 153, 255), Color.GRAY);
        //Carga el comboBox
        Clases.CargarCombox.cargar(jComboBoxPreventista, preventista, "preventista", "id_preventista", "nombre_preventista","Eliga el Preventista", "Agregar Preventista");
        Clases.CargarCombox.cargar(jComboBoxZona, zona, "zona", "id_zona", "nombre_zona", "Eliga la Zona", "Agregar Zona");
        
        String[] estados = {"Pendiente", "Acreditado"};
        JComboBox<String> comboBox = new JComboBox<>(estados);
        jTableTransferencia.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBox));
    }
    
    void listener(){
        DocumentListener listener = new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTotal();
                result(); 
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTotal();
                result();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTotal();
                result();
            }  
        };
        efectivo.getDocument().addDocumentListener(listener);
        cobranza.getDocument().addDocumentListener(listener);
        ptIngresado.getDocument().addDocumentListener(listener);
        talIngresado.getDocument().addDocumentListener(listener);
        jTextField4.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                if (tablaActual != null && campoNombreActual != null && campoIdActual != null) {
                    buscarMarcas(); // ← Usa la configuración actual
                }
            }
            @Override
            public void removeUpdate(DocumentEvent de) {
                if (tablaActual != null && campoNombreActual != null && campoIdActual != null) {
                    buscarMarcas(); // ← Usa la configuración actual
                }
            }
            @Override
            public void changedUpdate(DocumentEvent de) {   }
        });
        TableModelListener tablelistener = new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e) {
                actualizarTotal();
                result();
            }      
        };
        modelo.addTableModelListener(tablelistener);
        modelo3.addTableModelListener(tablelistener);
        modelo5.addTableModelListener(tablelistener);
        modelodevuelto.addTableModelListener(tablelistener);
        modelofiado.addTableModelListener(tablelistener);
        boton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                agregarMarcaATabla();
            }
        });
    }
    
    void abrirABMNuevo(){
        abm_cliente abm_cli = new abm_cliente(this);
        String opcion = (String) jComboBoxCliente2.getSelectedItem();
        switch (opcion){
            case "Transferencia":   
                abm_cli.setVisible(true);
                break;
            case "Fiado":
                abm_cli.setVisible(true);
                break;
            case "Gasto":
                abm_gasto abm_g = new abm_gasto(this);
                abm_g.setVisible(true);
                break;
            case "Devolucion":
                abm_cli.setVisible(true);
                break;
            case "Producto Devuelto":
                abm_producto abm_prod = new abm_producto(this);
                abm_prod.setVisible(true);
                break;
        }
    }
    
    void result(){
        try{
            float res=0;  
            res += Float.parseFloat(efectivo.getText());
            res += Float.parseFloat(totalGasto.getText());
            res += Float.parseFloat(totalFia.getText());
            res += Float.parseFloat(totalTra.getText());
            res -= Float.parseFloat(cobranza.getText());
            talCalculado.setText(String.valueOf(res));
            float n = Float.parseFloat(talIngresado.getText());
            float n1 = Float.parseFloat(totalDevolucion.getText());
            float n2 = Float.parseFloat(totalPr.getText());
            float r = n - n1 - n2;
            talGeneral.setText(String.valueOf(r));
            float num1 = Float.parseFloat(talCalculado.getText());
            float num2 = Float.parseFloat(talGeneral.getText());
            float dif = num1 - num2;
            diferencia.setText(String.valueOf(dif));
            if (dif > 5000.0f){
                diferencia.setForeground(Color.RED);
            }else
            if (dif < 5000.0f){
                diferencia.setForeground(new Color(80,200,120));
            }
        }catch(NumberFormatException e){
            talCalculado.setText("0");
            diferencia.setText("0");
            talGeneral.setText("0");
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        minimizar = new javax.swing.JButton();
        atras = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTransferencia = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        totalTra = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        efectivo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFiado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        totalFia = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBoxPreventista = new javax.swing.JComboBox<>();
        jComboBoxZona = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        talIngresado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ptIngresado = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxCliente2 = new javax.swing.JComboBox<>();
        monto = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cobranza = new javax.swing.JTextField();
        boton4 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        talGeneral = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableGasto = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        totalGasto = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        diferencia = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        ptCalculado = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        talCalculado = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableDevolucion = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        totalDevolucion = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTablePrDevuelto = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        totalPr = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(0, 0, 204));

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Gestion de Rendiciones");

        minimizar.setBackground(new java.awt.Color(0, 0, 204));
        minimizar.setToolTipText("Minimizar");
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizarActionPerformed(evt);
            }
        });

        atras.setBackground(new java.awt.Color(0, 0, 204));
        atras.setToolTipText("Salir");
        atras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(348, 348, 348)
                .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(atras, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8))
                        .addComponent(jLabel19)))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));

        jTableTransferencia.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jTableTransferencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Monto", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableTransferencia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jTableTransferencia);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Total  $");

        totalTra.setBackground(new java.awt.Color(0, 153, 0));
        totalTra.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalTra.setForeground(new java.awt.Color(255, 255, 255));
        totalTra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalTra.setText("0");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Efectivo   $");

        efectivo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        efectivo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        efectivo.setText("0");

        jScrollPane3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));

        jTableFiado.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jTableFiado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableFiado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(jTableFiado);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Total   $");

        totalFia.setBackground(new java.awt.Color(0, 153, 0));
        totalFia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalFia.setForeground(new java.awt.Color(255, 255, 255));
        totalFia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalFia.setText("0");

        jButton1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxPreventista.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBoxPreventista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxPreventista.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));
        jComboBoxPreventista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPreventistaActionPerformed(evt);
            }
        });

        jComboBoxZona.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBoxZona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxZona.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));
        jComboBoxZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxZonaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Preventista");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Zona");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Total        $");

        talIngresado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        talIngresado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        talIngresado.setText("0");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Punto de Venta");

        ptIngresado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ptIngresado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ptIngresado.setText("0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Transferencias");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Cobranza $");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("Cliente");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Monto   $");

        jComboBoxCliente2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBoxCliente2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eliga la Operacion", "Transferencia", "Fiado", "Gasto", "Producto Devuelto", "Devolucion" }));
        jComboBoxCliente2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));
        jComboBoxCliente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCliente2ActionPerformed(evt);
            }
        });

        monto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        monto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        monto.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Fiados");

        cobranza.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cobranza.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cobranza.setText("0");

        boton4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        boton4.setText("+ Agregar");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Total Gral. $");

        talGeneral.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        talGeneral.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        talGeneral.setText("0");
        talGeneral.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));

        jTableGasto.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jTableGasto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Gasto", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableGasto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane4.setViewportView(jTableGasto);

        jDateChooser1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));
        jDateChooser1.setToolTipText("");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Fecha");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("Gastos");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Total    $");

        totalGasto.setBackground(new java.awt.Color(0, 153, 0));
        totalGasto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalGasto.setForeground(new java.awt.Color(255, 255, 255));
        totalGasto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalGasto.setText("0");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Diferencia   $");

        diferencia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        diferencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        diferencia.setText("0");
        diferencia.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Rendicion");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Total    $");

        ptCalculado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ptCalculado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ptCalculado.setText("0");
        ptCalculado.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Punto de Venta");

        talCalculado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        talCalculado.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        talCalculado.setText("0");
        talCalculado.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));

        jTableDevolucion.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jTableDevolucion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Cliente", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableDevolucion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane5.setViewportView(jTableDevolucion);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Producto Devuelto");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("Total    $");

        totalDevolucion.setBackground(new java.awt.Color(0, 153, 0));
        totalDevolucion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalDevolucion.setForeground(new java.awt.Color(255, 255, 255));
        totalDevolucion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalDevolucion.setText("0");

        jScrollPane6.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(204, 204, 204)));

        jTablePrDevuelto.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jTablePrDevuelto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Descripcion", "P.U.", "Cantidad", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTablePrDevuelto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane6.setViewportView(jTablePrDevuelto);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("Devolucion");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("Cantidad");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setText("Total   $");

        totalPr.setBackground(new java.awt.Color(0, 153, 0));
        totalPr.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        totalPr.setForeground(new java.awt.Color(255, 255, 255));
        totalPr.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        totalPr.setText("0");

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(153, 153, 153)));

        jButton2.setText("Admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(totalTra, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(diferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(59, 59, 59))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(talCalculado, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addGap(33, 33, 33)
                                    .addComponent(ptCalculado, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxPreventista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxZona, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(talIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(talGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(34, 34, 34)
                                .addComponent(ptIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(efectivo, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(cobranza))
                        .addGap(466, 466, 466))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(75, 75, 75)
                                    .addComponent(jLabel23)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(totalGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel20)
                                .addGap(120, 120, 120))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(99, 99, 99)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(314, 314, 314)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(74, 74, 74))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel34))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(boton4))
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(132, 132, 132))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(248, 248, 248))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel36)
                                                .addGap(12, 12, 12)
                                                .addComponent(totalPr, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(40, 40, 40))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel28)
                                        .addGap(217, 217, 217)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(totalFia, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel32)
                                            .addGap(149, 149, 149)))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(totalDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxPreventista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(ptIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(talIngresado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(cobranza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(efectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(talGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(ptCalculado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(talCalculado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(jButton2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalFia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBoxCliente2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel34)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boton4))))))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel36)
                                    .addComponent(totalPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addComponent(jButton1)
                                .addGap(45, 45, 45))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(totalGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31)
                                    .addComponent(totalDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel32)
                                .addComponent(jLabel28)))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void buscarMarcas(){
        jPopupMenu1.setVisible(false);
        jPopupMenu1.removeAll();
        jTextField4.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && jPopupMenu1.isVisible()) {
                    if (jPopupMenu1.getComponentCount() > 0) {
                        JMenuItem item = (JMenuItem) jPopupMenu1.getComponent(0);
                        item.doClick();  // Ejecuta el primer ítem
                        e.consume();     // Previene que se dispare otro evento ENTER
                    }
                }
            }
        });
        marcamap.clear();
        Connection con = Conexion.Conexion.conexion();
        String texto = jTextField4.getText().trim();
        if (texto.isEmpty()) return;
        String campoNombreCompleto;
        if (tablaActual.equals("cliente")) {
            campoNombreCompleto = "CONCAT(nombre_cliente, ' ', apellido_cliente)";
        }else if(tablaActual.equals("gasto")){
            campoNombreCompleto = "nombre_gasto";
        } else if(tablaActual.equals("producto")){
            campoNombreCompleto = "descripcion_producto";
        }else{
            campoNombreCompleto = "nombre";
        }

        //String query = "SELECT " + campoIdActual + ", " + campoNombreCompleto + " AS nombre_completo " + "FROM " + tablaActual + " WHERE " + campoNombreCompleto + " LIKE ?";

        try{ //(Connection con = Conexion.Conexion.conexion();
             //PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = Clases.Rendicion.Buscar(con, campoIdActual, campoNombreCompleto, tablaActual, texto);
            //ps.setString(1, texto + "%");
            //ResultSet rs = ps.executeQuery();

            boolean hayResultados = false;

            while (rs.next()) {
                int id = rs.getInt(campoIdActual);
                String nombre = rs.getString("nombre_completo");

                marcamap.put(nombre, id);

                JMenuItem item = new JMenuItem(nombre);
                item.setFocusable(false);
                item.addActionListener(e -> {
                    jTextField4.setText(nombre);
                    jPopupMenu1.setVisible(false);
                    System.out.println("Seleccionado: " + nombre + " (ID: " + id + ")");
                });

                jPopupMenu1.add(item);
                hayResultados = true;
            }

            // Si no hay resultados, agrego el item para "Agregar nuevo"
            if (!hayResultados) {
                JMenuItem agregarItem = new JMenuItem("Agregar nuevo \"" + texto + "\"");
                agregarItem.setFocusable(false);
                agregarItem.setForeground(Color.BLUE);
                agregarItem.addActionListener(e -> {
                    jPopupMenu1.setVisible(false);
                    abrirABMNuevo();
                });
                jPopupMenu1.add(agregarItem);

            }
                jPopupMenu1.show(jTextField4, 0, jTextField4.getHeight());
                jTextField4.requestFocus();

        //} catch (SQLException e) {
            //e.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(rendiciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    private void agregarMarcaATabla() {
       String nombreSeleccionado = jTextField4.getText().trim();
       
       if (nombreSeleccionado.isEmpty()) {
           JOptionPane.showMessageDialog(null, "Seleccione un valor primero.");
           return;
       }

       Integer id = marcamap.get(nombreSeleccionado);
       if (id == null) {
           JOptionPane.showMessageDialog(null, "Debe seleccionar un valor de la lista.");
           return;
       }
       String montto = monto.getText().trim();
       if (montto.isEmpty()){
           JOptionPane.showMessageDialog(null, "Debe ingresar el monto $.");
           return;
       }
           float montoValor;
       try {
           montoValor = Float.parseFloat(montto);
       } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(null, "El monto debe ser un número válido.");
           return;
       }

       DefaultTableModel model = (DefaultTableModel) tablaDestinoActual.getModel();
       // Verificamos si esta tabla requiere cantidad (por ejemplo: jTableConCantidad)
       if (tablaDestinoActual == jTablePrDevuelto) {
           String cantidadTexto = jTextField1.getText().trim();
           if (cantidadTexto.isEmpty()) {
               JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad.");
               return;
           }

           float cantidadValor;
           try {
               cantidadValor = Float.parseFloat(cantidadTexto);
           } catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Cantidad inválida.");
               return;
           }

           Float total = cantidadValor * montoValor;

           model.addRow(new Object[]{id, nombreSeleccionado, montoValor, cantidadValor, total});
       } else if (tablaDestinoActual == jTableTransferencia) {
           String estado = "Pendiente";
           model.addRow(new Object[]{id, nombreSeleccionado, montoValor, estado});
       } else {
           // Para las otras tablas sin cantidad
           model.addRow(new Object[]{id, nombreSeleccionado, montoValor});
       }
       /* Evitar duplicados (opcional)
       if (existeEnTabla(tablaDestinoActual, id)) {
           JOptionPane.showMessageDialog(null, "Ya está en la tabla.");
           return;
       }*/

       // Limpiar campo
       jTextField4.setText("");
       monto.setText("");
       jTextField1.setText(""); // No pasa nada si no se usa
   }
   
    private void agregarMenuEliminar(JTable tabla, DefaultTableModel mode) {
        // Crear popup y opción de menú
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem eliminarItem = new JMenuItem("Borrar", new ImageIcon("src/Imagenes/Elimina.png"));
        popupMenu.add(eliminarItem);
        // Asociar popup a la tabla
        tabla.setComponentPopupMenu(popupMenu);

        // Acción del botón eliminar
        eliminarItem.addActionListener(e -> {
            int fila = tabla.getSelectedRow();
            if (fila >= 0) {
                mode.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccioná una fila para eliminar.");
            }
        });
    }
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
    private void actualizarTotal() {
        totalTra.setText(String.valueOf(calcularTotal(modelo, 2)));
        totalDevolucion.setText(String.valueOf(calcularTotal(modelo3, 2)));
        totalGasto.setText(String.valueOf(calcularTotal(modelo5, 2)));
        totalFia.setText(String.valueOf(calcularTotal(modelofiado, 2)));
        totalPr.setText(String.valueOf(calcularTotal(modelodevuelto, 4)));
        // Cálculo PT
        try {
            int pt = Integer.parseInt(ptIngresado.getText());
            int devueltos = modelo3.getRowCount(); // o como lo calcules
            int resultado = pt - devueltos;
            ptCalculado.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            ptCalculado.setText("0");
        }
    }
   
    private void minimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizarActionPerformed
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarActionPerformed

    private void jComboBoxPreventistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPreventistaActionPerformed
        // TODO add your handling code here:
        if ("Agregar Preventista".equals(jComboBoxPreventista.getSelectedItem())) {
                abm_preventista pre = new abm_preventista(this);
                pre.setVisible(true);
        }
    }//GEN-LAST:event_jComboBoxPreventistaActionPerformed

    private void jComboBoxZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxZonaActionPerformed
        // TODO add your handling code here:
        if ("Agregar Zona".equals(jComboBoxZona.getSelectedItem())) {
                abm_zona zon = new abm_zona(this);
                zon.setVisible(true);
            }
    }//GEN-LAST:event_jComboBoxZonaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jComboBoxCliente2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCliente2ActionPerformed
        // TODO add your handling code here:
        String opcion = (String) jComboBoxCliente2.getSelectedItem();
        tablaActual = null;
        campoIdActual = null;
        campoNombreActual = null;
        tablaDestinoActual = null;

        switch (opcion){
            case "Eliga la Operacion":
                componentvisible();
                tablaDestinoActual = null;
                break;
            case "Transferencia":
                tablaActual = "cliente";
                campoIdActual = "id_cliente";
                campoNombreActual = "nombre_cliente";
                boton4.setVisible(true);
                jLabel13.setVisible(true);
                jLabel14.setVisible(true);
                jTextField4.setVisible(true);
                monto.setVisible(true);
                jLabel13.setText("Cliente");
                jLabel14.setText("Monto $");
                jLabel34.setVisible(false);
                jTextField1.setVisible(false);
                tablaDestinoActual = jTableTransferencia;
                break;
            case "Fiado":
                tablaActual = "cliente";
                campoIdActual = "id_cliente";
                campoNombreActual = "nombre_cliente";
                boton4.setVisible(true);
                jLabel13.setVisible(true);
                jLabel14.setVisible(true);
                jTextField4.setVisible(true);
                monto.setVisible(true);
                jLabel13.setText("Cliente");
                jLabel14.setText("Monto $");
                jLabel34.setVisible(false);
                jTextField1.setVisible(false);
                tablaDestinoActual = jTableFiado;
                break;
            case "Gasto":
                tablaActual = "gasto";
                campoIdActual = "id_gasto";
                campoNombreActual = "nombre_gasto";
                boton4.setVisible(true);
                jLabel13.setVisible(true);
                jLabel14.setVisible(true);
                jTextField4.setVisible(true);
                monto.setVisible(true);
                jLabel13.setText("Gasto");
                jLabel14.setText("Monto $");
                jLabel34.setVisible(false);
                jTextField1.setVisible(false);
                tablaDestinoActual = jTableGasto;
                break;
            case "Devolucion":
                tablaActual = "cliente";
                campoIdActual = "id_cliente";
                campoNombreActual = "nombre_cliente";
                //abmDestino = "cliente";
                boton4.setVisible(true);
                jLabel13.setVisible(true);
                jLabel14.setVisible(true);
                jTextField4.setVisible(true);
                monto.setVisible(true);
                jLabel13.setText("Cliente");
                jLabel14.setText("Monto $");
                jLabel34.setVisible(false);
                jTextField1.setVisible(false);
                tablaDestinoActual = jTableDevolucion;
                break;
            case "Producto Devuelto":
                tablaActual = "producto";
                campoIdActual = "id_producto";
                campoNombreActual = "descripcion_producto";
                jLabel13.setVisible(true);
                jLabel14.setVisible(true);
                jLabel34.setVisible(true);
                jLabel13.setText("Descripcion");
                jLabel14.setText("P.U.");
                jTextField4.setVisible(true);
                monto.setVisible(true);
                jTextField1.setVisible(true);
                boton4.setVisible(true);
                tablaDestinoActual = jTablePrDevuelto;
                break;
        }
    }//GEN-LAST:event_jComboBoxCliente2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //-----------Validación de campos obligatorios
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una fecha.");
            return;
        }

        if (jComboBoxPreventista.getSelectedIndex() == 0 || jComboBoxPreventista.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un preventista.");
            return;
        }

        if (jComboBoxZona.getSelectedIndex() == 0 || jComboBoxZona.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una zona.");
            return;
        }
        java.util.Date fechaUtil = jDateChooser1.getDate();
        java.sql.Date fechaSql = new java.sql.Date(fechaUtil.getTime());
        int pre = preventista.get(jComboBoxPreventista.getSelectedItem().toString());
        int zon = zona.get(jComboBoxZona.getSelectedItem().toString());
        int pting = Integer.parseInt(ptIngresado.getText());
        Float ting = Float.parseFloat(talIngresado.getText());
        Float gen = Float.parseFloat(talGeneral.getText());
        Float cob = Float.parseFloat(cobranza.getText());
        Float efe = Float.parseFloat(efectivo.getText());
        Float dif = Float.parseFloat(diferencia.getText());
        int ptcal = Integer.parseInt(ptCalculado.getText());
        Float tcal = Float.parseFloat(talCalculado.getText());
        try{
            int idRendicion = Clases.Rendicion.insertarRendicion(con, fechaSql, pre, zon, pting, ting, gen, cob, efe, dif, ptcal, tcal); 
            if (idRendicion == -1) {
                JOptionPane.showMessageDialog(this, "No se pudo obtener el ID de la rendición.");
                return;
            }
            jComboBoxPreventista.setSelectedIndex(0);
            jComboBoxZona.setSelectedIndex(0);
            ptIngresado.setText("0");
            talIngresado.setText("0");
            talGeneral.setText("0");
            cobranza.setText("0");
            efectivo.setText("0");
            diferencia.setText("0");
            ptCalculado.setText("0");
            talCalculado.setText("0");
        // 3. Insertar transferencias desde JTable tranferencia
        int columnaIgnorada = 1; // por ejemplo, ignoramos columna "estado"
        Clases.Rendicion.insertarTransferencias(con, jTableTransferencia, idRendicion, columnaIgnorada);
        modelo.setRowCount(0); // Esto limpia todas las filas
        Clases.Rendicion.insertarFiado(con, jTableFiado, idRendicion, columnaIgnorada);
        modelofiado.setRowCount(0); // Esto limpia todas las filas
        Clases.Rendicion.insertarGasto(con, jTableGasto, idRendicion, columnaIgnorada);
        modelo5.setRowCount(0); // Esto limpia todas las filas
        Clases.Rendicion.insertarDevolucion(con, jTableDevolucion, idRendicion, columnaIgnorada);
        modelo3.setRowCount(0); // Esto limpia todas las filas
        Clases.Rendicion.insertarPrDevuelto(con, jTablePrDevuelto, idRendicion, columnaIgnorada);
        modelodevuelto.setRowCount(0); // Esto limpia todas las filas
        
        // 4. Éxito
        JOptionPane.showMessageDialog(this, "Rendiciones insertadas correctamente....");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(this, "Error no pudo cargar la rendicion"+ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        // TODO add your handling code here:
        ventanaPrincipal vp = new ventanaPrincipal();
        vp.setVisible(true);
        dispose();
    }//GEN-LAST:event_atrasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Fiado fi = new Fiado(this);
        fi.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(rendiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rendiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rendiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rendiciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rendiciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atras;
    private javax.swing.JButton boton4;
    private javax.swing.JTextField cobranza;
    private javax.swing.JTextField diferencia;
    private javax.swing.JTextField efectivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxCliente2;
    private javax.swing.JComboBox<String> jComboBoxPreventista;
    private javax.swing.JComboBox<String> jComboBoxZona;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTableDevolucion;
    private javax.swing.JTable jTableFiado;
    private javax.swing.JTable jTableGasto;
    private javax.swing.JTable jTablePrDevuelto;
    private javax.swing.JTable jTableTransferencia;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton minimizar;
    private javax.swing.JTextField monto;
    private javax.swing.JTextField ptCalculado;
    private javax.swing.JTextField ptIngresado;
    private javax.swing.JTextField talCalculado;
    private javax.swing.JTextField talGeneral;
    private javax.swing.JTextField talIngresado;
    private javax.swing.JTextField totalDevolucion;
    private javax.swing.JTextField totalFia;
    private javax.swing.JTextField totalGasto;
    private javax.swing.JTextField totalPr;
    private javax.swing.JTextField totalTra;
    // End of variables declaration//GEN-END:variables
}