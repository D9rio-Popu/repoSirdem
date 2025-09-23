/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JComboBox;

/**
 *
 * @author alumno
 */
public class CargarCombox {
    public static void cargar(JComboBox<String> comboBox, Map<String, Integer> map, String tableName, String idColumn, String nameColumn, String placeholder, String extraOption) {
        //String query = String.format("SELECT %s, %s FROM %s", idColumn, nameColumn, tableName);
        try { 
            Connection con = Conexion.Conexion.conexion();
            ResultSet rs = null;
            PreparedStatement ps = con.prepareStatement(String.format("SELECT %s, %s FROM %s", idColumn, nameColumn, tableName));
            rs = ps.executeQuery(); 

            comboBox.removeAllItems();
            comboBox.addItem(placeholder);
            map.clear();

            while (rs.next()) {
                int id = rs.getInt(idColumn);
                String nombre = rs.getString(nameColumn);
                comboBox.addItem(nombre);
                map.put(nombre, id);
            }
            
            comboBox.addItem(extraOption);
            //if (extraOption != null && !extraOption.isEmpty()) {  
            //}
            rs.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Considera usar un logger
        }
    }
}
/*void cargarMarca(){
        try{
            Connection con = Conexion.Conexion.conexion();
            ResultSet rs = null;
            PreparedStatement ps = con.prepareStatement("select id_marca, nombre_marca from marca");
            rs = ps.executeQuery();
            jComboBox2.removeAllItems();
            jComboBox2.addItem("Seleccionar la Marca");
            while(rs.next()){
                String nombre = rs.getString("nombre_marca");
                int id = rs.getInt("id_marca");
                jComboBox2.addItem(nombre);
                marcamap.put(nombre, id);
            }
            jComboBox2.addItem("Agregar marca");
            rs.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }*/