/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author alumno
 */
public class Rendicion {
    public static ResultSet Buscar(Connection con, String campoid, String campoNom, String tablaAct, String text) throws Exception{
        ResultSet rs = null;
        PreparedStatement stm = con.prepareStatement("SELECT " + campoid + ", " + campoNom + " AS nombre_completo " + "FROM " + tablaAct + " WHERE " + campoNom + " LIKE ?");
        stm.setString(1,"%"+ text +"%");
        rs = stm.executeQuery();
        return rs;
    }
    public static int insertarRendicion(Connection con, Date fecha, int preventista, int zona, int punto, float total, float general, float cobranza, float efectivo, float diferencia, int puntor, float totalr)throws Exception{
    PreparedStatement stm = con.prepareStatement("insert into rendicion(fecha_rendicion, id_preventista, id_zona, punto_ingresado, total_ingresado, total_general, cobranza, efectivo, diferencia, punto_rendido, total_rendido) VALUES (?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stm.setDate(1, fecha);
            stm.setInt(2, preventista);
            stm.setInt(3, zona);
            stm.setInt(4, punto);
            stm.setFloat(5, total);
            stm.setFloat(6, general);
            stm.setFloat(7, cobranza);
            stm.setFloat(8, efectivo);
            stm.setFloat(9, diferencia);
            stm.setInt(10, puntor);
            stm.setFloat(11, totalr);
        try{
            stm.execute();
            //JOptionPane.showMessageDialog(null, "Carga Correcta");
            try (ResultSet rs = stm.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // ID generado
                }
            }
            return -1; // Si no se generó ningún ID
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error "+ ex.getMessage());
        }
        return 0;
    }
    public static void insertarTransferencias(Connection con, JTable tabla, int idRendicion, int columnaIgnorada) throws SQLException {
            PreparedStatement ps = con.prepareStatement("insert into transferencia(id_cliente, monto, estado, id_rendicion) values (?, ?, ?, ?)");
            for (int i = 0; i < tabla.getRowCount(); i++) {
                int paramIndex = 1;

                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    if (j == columnaIgnorada) continue;

                    Object valor = tabla.getValueAt(i, j);
                    ps.setObject(paramIndex++, valor);
                }

                ps.setInt(paramIndex, idRendicion);  
                try{
                    ps.execute();
                    //JOptionPane.showMessageDialog(null, "Carga Correcta");
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Error en la transferencia "+ ex.getMessage());
                }
            }
    }
    public static void insertarFiado(Connection con, JTable tabla, int idRendicion, int columnaIgnorada) throws SQLException {
        String sqlFiado = "INSERT INTO fiado (id_cliente, monto, id_rendicion) VALUES (?, ?, ?)";
        PreparedStatement psFiado = con.prepareStatement(sqlFiado, Statement.RETURN_GENERATED_KEYS);

        String sqlDetalle = "INSERT INTO detalle_fiado (id_fiado, saldo, estadp) VALUES (?, ?, ?)";
        PreparedStatement psDetalle = con.prepareStatement(sqlDetalle);

        for (int i = 0; i < tabla.getRowCount(); i++) {
            int paramIndex = 1;
            Object idCliente = null;
            float monto = 0f;

            for (int j = 0; j < tabla.getColumnCount(); j++) {
                if (j == columnaIgnorada) continue;

                Object valor = tabla.getValueAt(i, j);

                if (paramIndex == 1) {
                    idCliente = valor;
                    psFiado.setObject(paramIndex++, valor); // id_cliente
                } else if (paramIndex == 2) {
                    if (valor instanceof Float) {
                        monto = (float) valor;
                    } else {
                        monto = Float.parseFloat(valor.toString());
                    }
                    psFiado.setFloat(paramIndex++, monto); // monto
                }
            }

            psFiado.setInt(paramIndex, idRendicion); // id_rendicion

            try {
                psFiado.executeUpdate();

                ResultSet rs = psFiado.getGeneratedKeys();
                if (rs.next()) {
                    int idFiadoGenerado = rs.getInt(1);

                    psDetalle.setInt(1, idFiadoGenerado);
                    psDetalle.setFloat(2, monto); // saldo = monto
                    psDetalle.setString(3, "pendiente");
                    psDetalle.executeUpdate();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    /*public static void insertarFiado(Connection con, JTable tabla, int idRendicion, int columnaIgnorada) throws SQLException {
            PreparedStatement ps = con.prepareStatement("insert into fiado (id_cliente, monto, id_rendicion) values (?, ?, ?)");
            for (int i = 0; i < tabla.getRowCount(); i++) {
                int paramIndex = 1;

                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    if (j == columnaIgnorada) continue;

                    Object valor = tabla.getValueAt(i, j);
                    ps.setObject(paramIndex++, valor);
                }

                ps.setInt(paramIndex, idRendicion);
                try{
                    ps.execute();
                    //JOptionPane.showMessageDialog(null, "Carga Correcta");
                }catch(Exception ex){
                    //JOptionPane.showMessageDialog(null, "Error "+ ex.getMessage());
                }
            }
        
    }*/
    public static void insertarGasto(Connection con, JTable tabla, int idRendicion, int columnaIgnorada) throws SQLException {
            PreparedStatement ps = con.prepareStatement("insert into detalle_gasto (id_gasto, monto_gasto, id_rendicion) values (?, ?, ?)");
            for (int i = 0; i < tabla.getRowCount(); i++) {
                int paramIndex = 1;

                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    if (j == columnaIgnorada) continue;

                    Object valor = tabla.getValueAt(i, j);
                    ps.setObject(paramIndex++, valor);
                }

                ps.setInt(paramIndex, idRendicion); 
                try{
                    ps.execute();
                    //JOptionPane.showMessageDialog(null, "Carga Correcta");
                }catch(Exception ex){
                    //JOptionPane.showMessageDialog(null, "Error "+ ex.getMessage());
                }
            }
        
    }
    public static void insertarDevolucion(Connection con, JTable tabla, int idRendicion, int columnaIgnorada) throws SQLException {
            PreparedStatement ps = con.prepareStatement("insert into devolucion (id_cliente, monto, id_rendicion) values (?, ?, ?)");
            for (int i = 0; i < tabla.getRowCount(); i++) {
                int paramIndex = 1;

                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    if (j == columnaIgnorada) continue;

                    Object valor = tabla.getValueAt(i, j);
                    ps.setObject(paramIndex++, valor);
                }

                ps.setInt(paramIndex, idRendicion); 
                try{
                    ps.execute();
                    //JOptionPane.showMessageDialog(null, "Carga Correcta");
                }catch(Exception ex){
                    //JOptionPane.showMessageDialog(null, "Error "+ ex.getMessage());
                }
            }
        
    }
    public static void insertarPrDevuelto(Connection con, JTable tabla, int idRendicion, int columnaIgnorada) throws SQLException {
            PreparedStatement ps = con.prepareStatement("insert into producto_devuelto (id_producto, precio_producto, cantidad_producto, id_rendicion) values (?, ?, ?, ?)");
            for (int i = 0; i < tabla.getRowCount(); i++) {
                int paramIndex = 1;

                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    if (j == columnaIgnorada || j ==4) continue;

                    Object valor = tabla.getValueAt(i, j);
                    ps.setObject(paramIndex++, valor);
                }

                ps.setInt(paramIndex, idRendicion);  
                try{
                    ps.execute();
                    //JOptionPane.showMessageDialog(null, "Carga Correcta");
                }catch(Exception ex){
                    //JOptionPane.showMessageDialog(null, "Error "+ ex.getMessage());
                }
            }
        
    }
}
