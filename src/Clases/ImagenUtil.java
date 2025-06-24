/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author ruben
 */
public class ImagenUtil {
    /**
    * Cargar una imagen en un JLabel escalada a su tamaño.
    */
    public static void cargarEnLabel(String ruta, JLabel label) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }

    /**
     * Cargar una imagen en un JButton escalada a su tamaño.
     */
    public static void cargarEnBoton(String ruta, JButton boton) {
        ImageIcon icon = new ImageIcon(ruta);
        Image img = icon.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(img));
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);
    }

    /**
     * Panel personalizado que dibuja una imagen de fondo escalada usando paintComponent.
     */
    public static class JPanelConFondo extends JPanel {
        private Image imagen;

        public JPanelConFondo(String ruta) {
            this.imagen = new ImageIcon(ruta).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
    
    public static void agregarFondoAFrame(JFrame frame, String rutaImagen) {
        // Crear el panel con imagen de fondo
        ImagenUtil.JPanelConFondo fondo = new ImagenUtil.JPanelConFondo(rutaImagen);
        fondo.setLayout(null);
        fondo.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // Agregar fondo a la capa MÁS BAJA del JLayeredPane
        frame.getLayeredPane().add(fondo, new Integer(Integer.MIN_VALUE));

        // Hacer transparente el contentPane para que se vea el fondo
        ((JComponent) frame.getContentPane()).setOpaque(false);

        // Ajustar tamaño del fondo al redimensionar
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt) {
                fondo.setSize(frame.getWidth(), frame.getHeight());
            }
        });
    }
}
