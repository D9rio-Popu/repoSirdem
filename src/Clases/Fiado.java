/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author alumno
 */
public class Fiado {
    public static ResultSet Buscar(Connection con, int idpreventista, String nombre) throws Exception{
        ResultSet rs = null;
        PreparedStatement stm = con.prepareStatement("select fecha_rendicion, nombre_cliente, monto, id_detal_fiado, saldo, estadp from detalle_fiado inner join fiado on fiado.id_fiado = detalle_fiado.id_fiado inner join cliente on cliente.id_cliente = fiado.id_cliente inner join rendicion on rendicion.id_rendicion = fiado.id_rendicion inner join preventista on preventista.id_preventista = rendicion.id_preventista where detalle_fiado.estadp = 'Pendiente' and preventista.id_preventista = ? and cliente.nombre_cliente like ?");
        stm.setInt(1, idpreventista);
        stm.setString(2,"%"+ nombre +"%");
        rs = stm.executeQuery();
        return rs;
    }
}
