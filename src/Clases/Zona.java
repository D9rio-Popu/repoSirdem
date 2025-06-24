
package Clases;

import java.sql.*;
import javax.swing.*;


public class Zona {
    public static ResultSet Buscar(Connection con, String nombre)throws Exception{
        ResultSet rs = null;
        PreparedStatement stm = con.prepareStatement("select id_zona, nombre_zona, case estado_zona when 1 then 'Activo' when 0 then 'Inactivo' end as estado from zona where nombre_zona LIKE ?");
        stm.setString(1,"%" + nombre + "%");
        rs = stm.executeQuery();
        return rs;
    }
    public static void Insertar(Connection con, String nombre, int estado)throws Exception{
        PreparedStatement stm = con.prepareStatement("insert into zona(nombre_zona, estado_zona) values (?, ?)");
        stm.setString(1, nombre);
        stm.setInt(2, estado);
        try{
            stm.execute();
            JOptionPane.showMessageDialog(null, "Carga Correcta");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error" +ex.getMessage());
        }
    }
    public static void Modificar(Connection con, String nombre, int estado, int idd)throws Exception{
        PreparedStatement stm = con.prepareStatement("update zona set nombre_zona = ?, estado_zona = ? where id_zona = ?");
        stm.setString(1, nombre);
        stm.setInt(2, estado);
        stm.setInt(3, idd);
        try{
            stm.execute();
            JOptionPane.showMessageDialog(null,"Modificacion correcta...");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Error al modificar" +ex.getMessage());
        }
        
    }
}
