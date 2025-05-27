package com.hibernate.GUIBuilder.helper_classes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

public class OnClickEventHelper {

    public static void setOnClickColor(JButton button, Color pressedColor, Color originalColor) {
        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                button.setContentAreaFilled(false);
                button.setBackground(pressedColor);
                button.setOpaque(true);
                button.repaint();

                if (button.getText()=="Insertar Alumno") {
                    System.out.println("Alumno insertado");
                } else if (button.getText()=="Actualizar Alumno") {
                    System.out.println("Alumno actualizado");
                } else if (button.getText()=="Borrar Alumno") {
                    System.out.println("Alumno borrado");
                } else if (button.getText()=="Insertar Asignatura") {
                    System.out.println("Asignatura insertada");
                } else if (button.getText()=="Actualizar Asignatura") {
                    System.out.println("Asignatura actualizada");
                } else if (button.getText()=="Borrar Asignatura") {
                    System.out.println("Asignatura borrada");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(originalColor);
                button.repaint();
            }
        });
    }

}