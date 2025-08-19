/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

/**
 *
 * @author alumno
 */
public class FocusBorderChanger {
    public static void aplicar(JTextField campo, Color colorEnFoco, Color colorSinFoco) {
        Border bordeNormal = BorderFactory.createMatteBorder(0, 0, 1, 0, colorSinFoco);
        Border bordeFoco = BorderFactory.createMatteBorder(0, 0, 3, 0, colorEnFoco);

        campo.setBorder(bordeNormal);

        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                campo.setBorder(bordeFoco);
            }

            @Override
            public void focusLost(FocusEvent e) {
                campo.setBorder(bordeNormal);
            }
        });
    }
}
