package com.hibernate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import com.hibernate.GUIBuilder.helper_classes.*;

import com.hibernate.util.HibernateUtil;

import com.hibernate.model.Alumno;
import com.hibernate.model.Asignatura;

import com.hibernate.dao.AlumnoDAO;
import com.hibernate.dao.AsignaturaDAO;

import org.hibernate.Session;
import java.util.List;

public class WindowBuilder {
  public static void main(String[] args) {
    Alumno alumno = new Alumno();
    Asignatura asignatura = new Asignatura();

    AlumnoDAO alumnoDAO = new AlumnoDAO();
    AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

    Session session = HibernateUtil.getSessionFactory().openSession();

    JFrame frame = new JFrame("Colegio");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1150, 780);
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(Color.decode("#f4c064"));

    JLabel lblAlumno = new JLabel("Alumnos");
    lblAlumno.setBounds(5, 5, 106, 18);
    lblAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblAlumno.setForeground(Color.decode("#000"));
    panel.add(lblAlumno);

    DefaultTableModel modelTableAlumno = new DefaultTableModel();
    modelTableAlumno.addColumn("Id");
    modelTableAlumno.addColumn("Nombre");
    modelTableAlumno.addColumn("Correo");
    modelTableAlumno.addColumn("Contraseña");
    modelTableAlumno.addColumn("Teléfono");

    List<Alumno> alumnos = alumnoDAO.selectAllAlumnos(session);

    for (Alumno al : alumnos) {
      Object[] row = new Object[5];
      row[0] = al.getId();
      row[1] = al.getNombre();
      row[2] = al.getCorreo();
      row[3] = al.getContraseña();
      row[4] = al.getTelefono();
      modelTableAlumno.addRow(row);
    }

    JLabel lblIdAlumno = new JLabel("Id:");
    lblIdAlumno.setBounds(60, 30, 106, 18);
    lblIdAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblIdAlumno.setForeground(Color.decode("#000"));
    panel.add(lblIdAlumno);

    JLabel lblNombreAlumno = new JLabel("Nombre:");
    lblNombreAlumno.setBounds(60, 60, 106, 17);
    lblNombreAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblNombreAlumno.setForeground(Color.decode("#000"));
    panel.add(lblNombreAlumno);

    JLabel lblCorreo = new JLabel("Correo:");
    lblCorreo.setBounds(60, 90, 105, 17);
    lblCorreo.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblCorreo.setForeground(Color.decode("#000"));
    panel.add(lblCorreo);

    JLabel lblContrasenya = new JLabel("Contraseña:");
    lblContrasenya.setBounds(60, 120, 106, 17);
    lblContrasenya.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblContrasenya.setForeground(Color.decode("#000"));
    panel.add(lblContrasenya);

    JLabel lblTelefono = new JLabel("Teléfono:");
    lblTelefono.setBounds(60, 150, 106, 17);
    lblTelefono.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblTelefono.setForeground(Color.decode("#000"));
    panel.add(lblTelefono);

    JTextField textFieldIdAlumno = new JTextField("");
    textFieldIdAlumno.setBounds(200, 30, 106, 24);
    textFieldIdAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldIdAlumno.setBackground(Color.decode("#ffe7bf"));
    textFieldIdAlumno.setForeground(Color.decode("#73664e"));
    textFieldIdAlumno.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldIdAlumno, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldIdAlumno);

    textFieldIdAlumno.setEditable(false);

    JTextField textFieldNombreAlumno = new JTextField("");
    textFieldNombreAlumno.setBounds(200, 60, 106, 21);
    textFieldNombreAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldNombreAlumno.setBackground(Color.decode("#ffe7bf"));
    textFieldNombreAlumno.setForeground(Color.decode("#73664e"));
    textFieldNombreAlumno.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldNombreAlumno, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldNombreAlumno);

    JTextField textFieldCorreo = new JTextField("");
    textFieldCorreo.setBounds(200, 90, 310, 21);
    textFieldCorreo.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldCorreo.setBackground(Color.decode("#ffe7bf"));
    textFieldCorreo.setForeground(Color.decode("#73664e"));
    textFieldCorreo.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldCorreo, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldCorreo);

    JTextField textFieldContrasenya = new JTextField("");
    textFieldContrasenya.setBounds(200, 120, 106, 21);
    textFieldContrasenya.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldContrasenya.setBackground(Color.decode("#ffe7bf"));
    textFieldContrasenya.setForeground(Color.decode("#73664e"));
    textFieldContrasenya.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldContrasenya, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldContrasenya);

    JTextField textFieldTelefono = new JTextField("");
    textFieldTelefono.setBounds(200, 150, 106, 21);
    textFieldTelefono.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldTelefono.setBackground(Color.decode("#ffe7bf"));
    textFieldTelefono.setForeground(Color.decode("#73664e"));
    textFieldTelefono.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldTelefono, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldTelefono);

    JTable tableAlumno = new JTable(modelTableAlumno);
    tableAlumno.getSelectionModel().addListSelectionListener(event -> {
      if (!event.getValueIsAdjusting() && tableAlumno.getSelectedRow() != -1) {
        int index = tableAlumno.getSelectedRow();

        textFieldIdAlumno.setText(tableAlumno.getValueAt(index, 0).toString());
        textFieldNombreAlumno.setText(tableAlumno.getValueAt(index, 1).toString());
        textFieldCorreo.setText(tableAlumno.getValueAt(index, 2).toString());
        textFieldContrasenya.setText(tableAlumno.getValueAt(index, 3).toString());
        textFieldTelefono.setText(tableAlumno.getValueAt(index, 4).toString());
      }
    });
    tableAlumno.setBounds(680, 24, 400, 200);
    frame.getContentPane().add(tableAlumno);

    JScrollPane scrollPaneAlumno = new JScrollPane(tableAlumno);
    scrollPaneAlumno.setBounds(680, 24, 400, 200);
    frame.getContentPane().add(scrollPaneAlumno);

    JLabel lblAsignatura = new JLabel("Asignaturas");
    lblAsignatura.setBounds(5, 225, 106, 18);
    lblAsignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblAsignatura.setForeground(Color.decode("#000"));
    panel.add(lblAsignatura);

    DefaultTableModel modelTableAsignatura = new DefaultTableModel();
    modelTableAsignatura.addColumn("Id");
    modelTableAsignatura.addColumn("Nombre");

    List<Asignatura> asignaturas = asignaturaDAO.selectAllAsignaturas(session);

    for (Asignatura as : asignaturas) {
      Object[] row = new Object[2];
      row[0] = as.getId();
      row[1] = as.getNombre();
      modelTableAsignatura.addRow(row);
    }

    JLabel lblIdAsignatura = new JLabel("Id:");
    lblIdAsignatura.setBounds(60, 250, 106, 18);
    lblIdAsignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblIdAsignatura.setForeground(Color.decode("#000"));
    panel.add(lblIdAsignatura);

    JLabel lblNombreAsignatura = new JLabel("Nombre:");
    lblNombreAsignatura.setBounds(60, 280, 106, 18);
    lblNombreAsignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblNombreAsignatura.setForeground(Color.decode("#000"));
    panel.add(lblNombreAsignatura);

    JTextField textFieldIdAsignatura = new JTextField("");
    textFieldIdAsignatura.setBounds(200, 250, 106, 24);
    textFieldIdAsignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldIdAsignatura.setBackground(Color.decode("#ffe7bf"));
    textFieldIdAsignatura.setForeground(Color.decode("#73664e"));
    textFieldIdAsignatura.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldIdAsignatura, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldIdAsignatura);

    textFieldIdAsignatura.setEditable(false);

    JTextField textFieldNombreAsignatura = new JTextField("");
    textFieldNombreAsignatura.setBounds(200, 280, 310, 24);
    textFieldNombreAsignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldNombreAsignatura.setBackground(Color.decode("#ffe7bf"));
    textFieldNombreAsignatura.setForeground(Color.decode("#73664e"));
    textFieldNombreAsignatura.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldNombreAsignatura, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldNombreAsignatura);

    JTable tableAsignatura = new JTable(modelTableAsignatura);
    tableAsignatura.getSelectionModel().addListSelectionListener(event -> {
      if (!event.getValueIsAdjusting() && tableAsignatura.getSelectedRow() != -1) {
        int index = tableAsignatura.getSelectedRow();

        textFieldIdAsignatura.setText(tableAsignatura.getValueAt(index, 0).toString());
        textFieldNombreAsignatura.setText(tableAsignatura.getValueAt(index, 1).toString());
      }
    });
    tableAsignatura.setBounds(680, 250, 400, 200);
    frame.getContentPane().add(tableAsignatura);

    JScrollPane scrollPaneAsignatura = new JScrollPane(tableAsignatura);
    scrollPaneAsignatura.setBounds(680, 250, 400, 200);
    frame.getContentPane().add(scrollPaneAsignatura);

    JLabel lblAlumno_Asignatura = new JLabel("Alumno_Asignatura");
    lblAlumno_Asignatura.setBounds(5, 350, 150, 18);
    lblAlumno_Asignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblAlumno_Asignatura.setForeground(Color.decode("#000"));
    panel.add(lblAlumno_Asignatura);

    JLabel lblIdAlumnoRelacion = new JLabel("Id del Alumno:");
    lblIdAlumnoRelacion.setBounds(60, 375, 106, 18);
    lblIdAlumnoRelacion.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblIdAlumnoRelacion.setForeground(Color.decode("#000"));
    panel.add(lblIdAlumnoRelacion);

    JLabel lblIdAsignaturaRelacion = new JLabel("Id de la Asignatura:");
    lblIdAsignaturaRelacion.setBounds(60, 405, 140, 18);
    lblIdAsignaturaRelacion.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    lblIdAsignaturaRelacion.setForeground(Color.decode("#000"));
    panel.add(lblIdAsignaturaRelacion);

    JTextField textFieldIdAlumnoRelacion = new JTextField("");
    textFieldIdAlumnoRelacion.setBounds(200, 375, 106, 24);
    textFieldIdAlumnoRelacion.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldIdAlumnoRelacion.setBackground(Color.decode("#ffe7bf"));
    textFieldIdAlumnoRelacion.setForeground(Color.decode("#73664e"));
    textFieldIdAlumnoRelacion.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldIdAlumnoRelacion, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldIdAlumnoRelacion);

    JTextField textFieldIdAsignaturaRelacion = new JTextField("");
    textFieldIdAsignaturaRelacion.setBounds(200, 405, 106, 24);
    textFieldIdAsignaturaRelacion.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    textFieldIdAsignaturaRelacion.setBackground(Color.decode("#ffe7bf"));
    textFieldIdAsignaturaRelacion.setForeground(Color.decode("#73664e"));
    textFieldIdAsignaturaRelacion.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
    OnFocusEventHelper.setOnFocusText(textFieldIdAsignaturaRelacion, "", Color.decode("#000"),   Color.decode("#73664e"));
    panel.add(textFieldIdAsignaturaRelacion);

    DefaultTableModel modelTableAlumno_Asignatura = new DefaultTableModel();
    modelTableAlumno_Asignatura.addColumn("IdAlumno");
    modelTableAlumno_Asignatura.addColumn("IdAsignatura");

    List<Alumno> alumno_asignatura = alumnoDAO.selectAllAlumnos(session);

    for (Alumno al : alumno_asignatura) {
      if (al.getAsignaturas().isEmpty()) {
        Object[] row = new Object[2];
        row[0] = al.getId();
        row[1] = "(-)";
        modelTableAlumno_Asignatura.addRow(row);
      } else {
        for (Asignatura as : al.getAsignaturas()) {
          Object[] row = new Object[2];
          row[0] = al.getId();
          row[1] = as.getId();
          modelTableAlumno_Asignatura.addRow(row);
        }
      }
    }

    JTable tableAlumno_Asignatura = new JTable(modelTableAlumno_Asignatura);
    tableAlumno_Asignatura.getSelectionModel().addListSelectionListener(event -> {
      if (!event.getValueIsAdjusting() && tableAlumno_Asignatura.getSelectedRow() != -1) {
        int index = tableAlumno_Asignatura.getSelectedRow();

        textFieldIdAlumnoRelacion.setText(tableAlumno_Asignatura.getValueAt(index, 0).toString());
        textFieldIdAsignaturaRelacion.setText(tableAlumno_Asignatura.getValueAt(index, 1).toString());
      }
    });
    tableAlumno_Asignatura.setBounds(200, 500, 400, 200);
    frame.getContentPane().add(tableAlumno_Asignatura);

    JScrollPane scrollPaneAlumno_Asignatura = new JScrollPane(tableAlumno_Asignatura);
    scrollPaneAlumno_Asignatura.setBounds(200, 500, 400, 200);
    frame.getContentPane().add(scrollPaneAlumno_Asignatura);

    JButton botonInsertarAlumno = new JButton("Insertar Alumno");
    botonInsertarAlumno.setBounds(200, 200, 150, 29);
    botonInsertarAlumno.setBackground(Color.decode("#bca8e4"));
    botonInsertarAlumno.setForeground(Color.decode("#000"));
    botonInsertarAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    botonInsertarAlumno.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    botonInsertarAlumno.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(botonInsertarAlumno, Color.decode("#7c6f97"), Color.decode("#bca8e4"), textFieldIdAlumno, textFieldNombreAlumno, textFieldCorreo, textFieldContrasenya, textFieldTelefono, textFieldIdAsignatura, textFieldNombreAsignatura, modelTableAlumno, modelTableAsignatura, textFieldIdAlumnoRelacion, textFieldIdAsignaturaRelacion, modelTableAlumno_Asignatura, session);
    panel.add(botonInsertarAlumno);

    JButton botonActualizarAlumno = new JButton("Actualizar Alumno");
    botonActualizarAlumno.setBounds(360, 200, 150, 29);
    botonActualizarAlumno.setBackground(Color.decode("#bca8e4"));
    botonActualizarAlumno.setForeground(Color.decode("#000"));
    botonActualizarAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    botonActualizarAlumno.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    botonActualizarAlumno.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(botonActualizarAlumno, Color.decode("#7c6f97"), Color.decode("#bca8e4"), textFieldIdAlumno, textFieldNombreAlumno, textFieldCorreo, textFieldContrasenya, textFieldTelefono, textFieldIdAsignatura, textFieldNombreAsignatura, modelTableAlumno, modelTableAsignatura, textFieldIdAlumnoRelacion, textFieldIdAsignaturaRelacion, modelTableAlumno_Asignatura, session);
    panel.add(botonActualizarAlumno);

    JButton botonBorrarAlumno = new JButton("Borrar Alumno");
    botonBorrarAlumno.setBounds(520, 200, 150, 29);
    botonBorrarAlumno.setBackground(Color.decode("#bca8e4"));
    botonBorrarAlumno.setForeground(Color.decode("#000"));
    botonBorrarAlumno.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    botonBorrarAlumno.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    botonBorrarAlumno.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(botonBorrarAlumno, Color.decode("#7c6f97"), Color.decode("#bca8e4"), textFieldIdAlumno, textFieldNombreAlumno, textFieldCorreo, textFieldContrasenya, textFieldTelefono, textFieldIdAsignatura, textFieldNombreAsignatura, modelTableAlumno, modelTableAsignatura, textFieldIdAlumnoRelacion, textFieldIdAsignaturaRelacion, modelTableAlumno_Asignatura, session);
    panel.add(botonBorrarAlumno);

    JButton botonInsertarAsignatura = new JButton("Insertar Asignatura");
    botonInsertarAsignatura.setBounds(200, 330, 150, 30);
    botonInsertarAsignatura.setBackground(Color.decode("#bca8e4"));
    botonInsertarAsignatura.setForeground(Color.decode("#000"));
    botonInsertarAsignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    botonInsertarAsignatura.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    botonInsertarAsignatura.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(botonInsertarAsignatura, Color.decode("#7c6f97"), Color.decode("#bca8e4"), textFieldIdAlumno, textFieldNombreAlumno, textFieldCorreo, textFieldContrasenya, textFieldTelefono, textFieldIdAsignatura, textFieldNombreAsignatura, modelTableAlumno, modelTableAsignatura, textFieldIdAlumnoRelacion, textFieldIdAsignaturaRelacion, modelTableAlumno_Asignatura, session);
    panel.add(botonInsertarAsignatura);

    JButton botonActualizarAsignatura = new JButton("Actualizar Asignatura");
    botonActualizarAsignatura.setBounds(360, 330, 150, 30);
    botonActualizarAsignatura.setBackground(Color.decode("#bca8e4"));
    botonActualizarAsignatura.setForeground(Color.decode("#000"));
    botonActualizarAsignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    botonActualizarAsignatura.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    botonActualizarAsignatura.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(botonActualizarAsignatura, Color.decode("#7c6f97"), Color.decode("#bca8e4"), textFieldIdAlumno, textFieldNombreAlumno, textFieldCorreo, textFieldContrasenya, textFieldTelefono, textFieldIdAsignatura, textFieldNombreAsignatura, modelTableAlumno, modelTableAsignatura, textFieldIdAlumnoRelacion, textFieldIdAsignaturaRelacion, modelTableAlumno_Asignatura, session);
    panel.add(botonActualizarAsignatura);

    JButton botonBorrarAsignatura = new JButton("Borrar Asignatura");
    botonBorrarAsignatura.setBounds(520, 330, 150, 30);
    botonBorrarAsignatura.setBackground(Color.decode("#bca8e4"));
    botonBorrarAsignatura.setForeground(Color.decode("#000"));
    botonBorrarAsignatura.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    botonBorrarAsignatura.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    botonBorrarAsignatura.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(botonBorrarAsignatura, Color.decode("#7c6f97"), Color.decode("#bca8e4"), textFieldIdAlumno, textFieldNombreAlumno, textFieldCorreo, textFieldContrasenya, textFieldTelefono, textFieldIdAsignatura, textFieldNombreAsignatura, modelTableAlumno, modelTableAsignatura, textFieldIdAlumnoRelacion, textFieldIdAsignaturaRelacion, modelTableAlumno_Asignatura, session);
    panel.add(botonBorrarAsignatura);

    JButton botonAnyadirRelacion = new JButton("Añadir relación");
    botonAnyadirRelacion.setBounds(200, 455, 150, 29);
    botonAnyadirRelacion.setBackground(Color.decode("#bca8e4"));
    botonAnyadirRelacion.setForeground(Color.decode("#000"));
    botonAnyadirRelacion.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    botonAnyadirRelacion.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    botonAnyadirRelacion.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(botonAnyadirRelacion, Color.decode("#7c6f97"), Color.decode("#bca8e4"), textFieldIdAlumno, textFieldNombreAlumno, textFieldCorreo, textFieldContrasenya, textFieldTelefono, textFieldIdAsignatura, textFieldNombreAsignatura, modelTableAlumno, modelTableAsignatura, textFieldIdAlumnoRelacion, textFieldIdAsignaturaRelacion, modelTableAlumno_Asignatura, session);
    panel.add(botonAnyadirRelacion);

    JButton botonEliminarRelacion = new JButton("Eliminar relación");
    botonEliminarRelacion.setBounds(360, 455, 150, 29);
    botonEliminarRelacion.setBackground(Color.decode("#bca8e4"));
    botonEliminarRelacion.setForeground(Color.decode("#000"));
    botonEliminarRelacion.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
    botonEliminarRelacion.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
    botonEliminarRelacion.setFocusPainted(false);
    OnClickEventHelper.setOnClickColor(botonEliminarRelacion, Color.decode("#7c6f97"), Color.decode("#bca8e4"), textFieldIdAlumno, textFieldNombreAlumno, textFieldCorreo, textFieldContrasenya, textFieldTelefono, textFieldIdAsignatura, textFieldNombreAsignatura, modelTableAlumno, modelTableAsignatura, textFieldIdAlumnoRelacion, textFieldIdAsignaturaRelacion, modelTableAlumno_Asignatura, session);
    panel.add(botonEliminarRelacion);

    frame.add(panel);
    frame.setVisible(true);
  }
}