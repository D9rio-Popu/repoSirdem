/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Filtro {

    // Método público y estático para que puedas llamarlo fácilmente sin crear objetos
    public static void aplicarFiltro(JTable tabla, int columnaEstado, String criterio) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);

        if (criterio == null || criterio.equalsIgnoreCase("Todo")) {
            sorter.setRowFilter(null); // mostrar todo
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(criterio, columnaEstado));
        }
    }
}
