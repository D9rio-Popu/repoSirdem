
package Conexion;

import java.sql.*;
import javax.swing.*;

public class Conexion {
    public static Connection conexion(){

        Connection conexion = null;
        String servidor = "jdbc:mysql://localhost/sirdem";
        String usuario = "root";
        String pas = "";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(servidor, usuario, pas);
        } catch(ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        finally{
            return conexion;
        }
    }
    
}
