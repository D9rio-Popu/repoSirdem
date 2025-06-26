
package Clases;

import java.sql.*;
import javax.swing.*;

public class Producto {
    public static ResultSet Buscar(Connection con, String codigo) throws Exception{
        ResultSet rs = null;
        PreparedStatement stm = con.prepareStatement("select id_producto, descripcion_producto, nombre_marca, case estado_producto when 1 then 'Activo' when 0 then 'Inactivo' end as estado from producto inner join marca on producto.id_marca = marca.id_marca where CONVERT(id_producto, CHAR) LIKE ?");
        stm.setString(1,"%"+ codigo +"%");
        rs = stm.executeQuery();
        return rs;
    }
    public static void Insertar(Connection con, String descripcion, int id_marca,int estado_producto) throws Exception{
        PreparedStatement stm = con.prepareStatement("insert into producto(descripcion_producto, id_marca, estado_producto) values (?, ?, ?)");
        stm.setString(1, descripcion);
        stm.setInt(2, id_marca);
        stm.setInt(3, estado_producto);
        try{
            stm.execute();
            JOptionPane.showMessageDialog(null, "Carga Correcta");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error "+ ex.getMessage());
        }
    }
    
    public static void Modificar(Connection con, String descripcion, int marca, int estado, int codig)throws Exception{
        PreparedStatement stm = con.prepareStatement("update producto set descripcion_producto = ?, id_marca = ?, estado_producto = ? where id_producto = ?");
        stm.setString(1, descripcion);
        stm.setInt(2, marca);
        stm.setInt(3, estado);
        stm.setInt(4, codig);
        try{
            stm.execute();
            JOptionPane.showMessageDialog(null, "Modificacion correcta...");
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al modificar " +ex.getMessage());
        }
    }
}
