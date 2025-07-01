/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class Marca {   
    public static void agregarNuevaMarca(Connection con, String marca) {
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("INSERT INTO marca (nombre_marca) VALUES (?)");
            stm.setString(1, marca);
            stm.executeUpdate(); // Usar executeUpdate() para INSERT
            JOptionPane.showMessageDialog(null, "Marca agregada correctamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar marca: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar el PreparedStatement
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException ex) {
                    System.err.println("Error al cerrar PreparedStatement: " + ex.getMessage());
                }
            }
        }
    }   
}
