
package Clases;

import java.sql.*;
import javax.swing.*;

public class Cliente {
    public static ResultSet Buscar(Connection con, String nombre)throws Exception{
        ResultSet rs = null;
        PreparedStatement stm = con.prepareStatement("select id_clientes, nombre_cliente, apellido_cliente, telefono_cliente, direccion_cliente, case estado_cliente when 1 then 'Activo' when 0 then 'Inactivo' end as estado from cliente where nombre_cliente LIKE ?");
        stm.setString(1,"%" + nombre + "%");
        rs = stm.executeQuery();
        return rs;
    }
    
    public static ResultSet mostrarEstado(Connection con, int estado)throws Exception{
        ResultSet rs = null;
        PreparedStatement stm = con.prepareStatement("select id_clientes, nombre_cliente, apellido_cliente, telefono_cliente, direccion_cliente, case when estado_cliente=1 then 'Activo' else 'Inactivo' end as estado_cliente from cliente where estado_cliente=?");
        stm.setInt(1,estado);
        rs = stm.executeQuery();
        return rs;
    }
    
    public static ResultSet mostrarClientes(Connection con)throws Exception{
        ResultSet rs = null;
        PreparedStatement stm = con.prepareStatement("select id_clientes, nombre_cliente, apellido_cliente, telefono_cliente, direccion_cliente, case when estado_cliente=1 then 'Activo' else 'Inactivo' end as estado_cliente from cliente");
        //stm.setInt(1,estado);
        rs = stm.executeQuery();
        return rs;
    }
    
    public static void Insertar(Connection con, String nombre, String apellido, String telefono, String direccion, int estado)throws Exception {
        PreparedStatement stm = con.prepareStatement("insert into cliente(nombre_cliente, apellido_cliente, telefono_cliente, direccion_cliente, estado_cliente) values (?, ?, ?, ?, ?)");
        stm.setString(1, nombre);
        stm.setString(2, apellido);
        stm.setString(3, telefono);
        stm.setString(4, direccion);
        stm.setInt(5, estado);
        try{
            stm.execute();
            JOptionPane.showMessageDialog(null, "Carga Correcta...");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error..."+ex.getMessage());
        }
    }
    public static void Modificar(Connection con, String nombre, String apellido, String telefono, String direccion, int estado, int idd)throws Exception{
        PreparedStatement stm = con.prepareStatement("update cliente set nombre_cliente = ?, apellido_cliente = ?, telefono_cliente = ?, direccion_cliente = ?, estado_cliente = ? where id_clientes = ?");
        stm.setString(1, nombre);
        stm.setString(2, apellido);
        stm.setString(3, telefono);
        stm.setString(4, direccion);
        stm.setInt(5, estado);
        stm.setInt(6, idd);
        try {
            stm.execute();
            JOptionPane.showMessageDialog(null, "Modificacion correcta...");
        }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Error al Modificar "+ex.getMessage());
        }
    }
}
