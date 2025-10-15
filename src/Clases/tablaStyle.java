/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
/**
 *
 * @author alumno
 */
public class tablaStyle {
    public static void personalizarJTable(JTable table, JScrollPane scrollPane) {
        // Estilo del encabezado
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(0, 0, 204));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));

        // Líneas y rejilla
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.GRAY);
        table.setRowHeight(25);

        // Scroll personalizado (solo vertical en este caso)
        if (scrollPane != null) {
            scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(15, Integer.MAX_VALUE));
        }
    }

}
