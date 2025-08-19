/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author alumno
 */
public class botonConImagen {
    public static void setImagenEnBoton(JButton boton, String rutaImagen) {
        ImageIcon icon = new ImageIcon(ImagenUtil.class.getResource(rutaImagen));
        Image imagenOriginal = icon.getImage();
        Dimension size = boton.getSize();

        if (size.width == 0 || size.height == 0) {
            // En caso de que el tamaño del botón aún no esté definido
            size = new Dimension(100, 100); // tamaño por defecto provisional
        }

        Image imagenEscalada = imagenOriginal.getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(imagenEscalada));
        boton.setText(""); // Elimina el texto
        boton.setHorizontalAlignment(SwingConstants.CENTER);
        boton.setVerticalAlignment(SwingConstants.CENTER);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
        boton.setFocusPainted(false);
    }

    /**
     * Escucha el redimensionamiento del botón para actualizar la imagen si cambia el tamaño.
     *
     * @param boton JButton que se observará
     * @param rutaImagen Ruta del recurso de imagen
     */
    public static void ajustarImagenDinamicamente(JButton boton, String rutaImagen) {
        boton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                setImagenEnBoton(boton, rutaImagen);
            }
        });
        setImagenEnBoton(boton, rutaImagen); // Inicial
    }
}
