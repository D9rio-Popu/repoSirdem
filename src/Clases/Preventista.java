
package Clases;

import java.sql.*;
import javax.swing.*;

public class Preventista {
    public static ResultSet Buscar(Connection con, String dni)throws Exception{
        ResultSet rs = null;
        PreparedStatement stm = con.prepareStatement("select nombre_preventista, apellido_preventista, dni_preventista, telefono_preventista, ingreso_preventista, case estado_preventista when 1 then 'Activo' when 0 then 'Inactivo' end as estado from preventista where dni_preventista like ?");
        stm.setString(1,"%"+ dni +"%");
        rs = stm.executeQuery();
        return rs;
    }
    public static void Insertar(Connection con, String nombre, String apellido, String dni, String telefono, int estado)throws Exception{
        PreparedStatement stm = con.prepareStatement("insert into preventista(nombre_preventista, apellido_preventista, dni_preventista, telefono_preventista, estado_preventista) values (?, ?, ?, ?, ?)");
        stm.setString(1, nombre);
        stm.setString(2, apellido);
        stm.setString(3, dni);
        stm.setString(4, telefono);
        stm.setInt(5, estado);
        try{
            stm.execute();
            JOptionPane.showMessageDialog(null, "Carga Correcta");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error... " +ex.getMessage());
        }
    }
    public static void Modificar(Connection con, String nombre, String apellido, String dni, String telefono, int estado, String dni_b)throws Exception{
        PreparedStatement stm = con.prepareStatement("update preventista set nombre_preventista = ?, apellido_preventista = ?, dni_preventista = ?, telefono_preventista = ?, estado_preventista = ? where  dni_preventista = ?");
        stm.setString(1, nombre);
        stm.setString(2, apellido);
        stm.setString(3, dni);
        stm.setString(4, telefono);
        stm.setInt(5, estado);
        stm.setString(6, dni_b);
        try{
            stm.execute();
            JOptionPane.showMessageDialog(null, "Modificacion correcta..");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al modificar.."+ex.getMessage());
        }
    }
}
