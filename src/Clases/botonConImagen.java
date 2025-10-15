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
        boton.setContentAreaFilled(true);
        boton.setBorderPainted(false);
        boton.setFocusPainted(true);
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
    
   public static void setImagenYTextoEnBoton(JButton boton, String rutaImagen, String texto) {
        ImageIcon icon = new ImageIcon(botonConImagen.class.getResource(rutaImagen));
        Image imagenOriginal = icon.getImage();
        Dimension size = boton.getSize();

        // Si todavía no tiene tamaño (por ejemplo al inicio)
        if (size.width == 0 || size.height == 0) {
            size = boton.getPreferredSize();
            if (size.width == 0 || size.height == 0) {
                size = new Dimension(120, 50);
            }
        }

        // La imagen no ocupará todo el ancho para dejar espacio al texto
        int iconWidth = (int) (size.width * 0.4);   // 40% del ancho del botón
        int iconHeight = (int) (size.height * 0.8); // 80% de la altura

        Image imagenEscalada = imagenOriginal.getScaledInstance(iconWidth, iconHeight, Image.SCALE_SMOOTH);
        boton.setIcon(new ImageIcon(imagenEscalada));
        
        boton.setText(texto);
        // Texto a la derecha de la imagen
        boton.setHorizontalTextPosition(SwingConstants.CENTER);
        boton.setVerticalTextPosition(SwingConstants.BOTTOM);

        boton.setHorizontalAlignment(SwingConstants.CENTER);
        boton.setVerticalAlignment(SwingConstants.CENTER);

        boton.setContentAreaFilled(true);
        boton.setBorderPainted(true);
        boton.setFocusPainted(true);
    }

    /**
     * Escucha el redimensionamiento del botón para actualizar la imagen si cambia el tamaño.
     */
    public static void ajustarImagenYTextoDinamicamente(JButton boton, String rutaImagen, String texto) {
        boton.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                setImagenYTextoEnBoton(boton, rutaImagen, texto);
            }
        });
        setImagenYTextoEnBoton(boton, rutaImagen, texto);
    }
}
