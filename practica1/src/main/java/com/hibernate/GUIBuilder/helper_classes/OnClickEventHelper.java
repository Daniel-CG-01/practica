package com.hibernate.GUIBuilder.helper_classes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.hibernate.util.HibernateUtil;

import com.hibernate.model.Alumno;
import com.hibernate.model.Asignatura;

import com.hibernate.dao.AlumnoDAO;
import com.hibernate.dao.AsignaturaDAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OnClickEventHelper {

    public static void setOnClickColor(JButton button, Color pressedColor, Color originalColor, 
                                       JTextField textFieldIdAlumno, JTextField textFieldNombreAlumno, 
                                       JTextField textFieldCorreo, JTextField textFieldContraseña, 
                                       JTextField textFieldTelefono, 
                                       JTextField textFieldIdAsignatura, JTextField textFieldNombreAsignatura, 
                                       DefaultTableModel modelTableAlumno, DefaultTableModel modelTableAsignatura, 
                                       Session session) {

        button.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                Alumno alumno = new Alumno();
                Asignatura asignatura = new Asignatura();

                AlumnoDAO alumnoDAO = new AlumnoDAO();
                AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();

                button.setContentAreaFilled(false);
                button.setBackground(pressedColor);
                button.setOpaque(true);
                button.repaint();

                try {
                    if (button.getText().equals("Insertar Alumno")) {
                        String nombre=textFieldNombreAlumno.getText();
    
                        String correo=textFieldCorreo.getText();
    
                        String contrasenya=textFieldContraseña.getText();
    
                        String telefonoTexto=textFieldTelefono.getText();
                        int telefono=Integer.parseInt(telefonoTexto);
    
                        alumno = new Alumno(nombre, correo, contrasenya, telefono);
                        alumnoDAO.insertAlumno(session, alumno);
    
                        System.out.println("Alumno insertado");
    
                        textFieldNombreAlumno.setText("");
                        textFieldCorreo.setText("");
                        textFieldContraseña.setText("");
                        textFieldTelefono.setText("");
    
                        List<Alumno> alumnos = alumnoDAO.selectAllAlumnos(session);

                        modelTableAlumno.setRowCount(0);
    
                        for (Alumno al : alumnos) {
                            Object[] row = new Object[5];
                            row[0] = al.getId();
                            row[1] = al.getNombre();
                            row[2] = al.getCorreo();
                            row[3] = al.getContraseña();
                            row[4] = al.getTelefono();
                            modelTableAlumno.addRow(row);
                        }
                    } else if (button.getText().equals("Actualizar Alumno")) {
                        String idTexto=textFieldIdAlumno.getText();
                        int id=Integer.parseInt(idTexto);

                        String nombre=textFieldNombreAlumno.getText();
    
                        String correo=textFieldCorreo.getText();
    
                        String contrasenya=textFieldContraseña.getText();
    
                        String telefonoTexto=textFieldTelefono.getText();
                        int telefono=Integer.parseInt(telefonoTexto);
    
                        Alumno alumnoActualizado = alumnoDAO.selectAlumnoById(session, id);
                        alumnoActualizado.setId(id);
                        alumnoActualizado.setNombre(nombre);
                        alumnoActualizado.setCorreo(correo);
                        alumnoActualizado.setContraseña(contrasenya);
                        alumnoActualizado.setTelefono(telefono);
                        alumnoDAO.updateAlumno(session, alumnoActualizado);
    
                        System.out.println("Alumno actualizado");
    
                        textFieldIdAlumno.setText("");
                        textFieldNombreAlumno.setText("");
                        textFieldCorreo.setText("");
                        textFieldContraseña.setText("");
                        textFieldTelefono.setText("");
    
                        List<Alumno> alumnos = alumnoDAO.selectAllAlumnos(session);

                        modelTableAlumno.setRowCount(0);
    
                        for (Alumno al : alumnos) {
                            Object[] row = new Object[5];
                            row[0] = al.getId();
                            row[1] = al.getNombre();
                            row[2] = al.getCorreo();
                            row[3] = al.getContraseña();
                            row[4] = al.getTelefono();
                            modelTableAlumno.addRow(row);
                        }
                    } else if (button.getText().equals("Borrar Alumno")) {
                        String idTexto=textFieldIdAlumno.getText();
                        int id=Integer.parseInt(idTexto);
    
                        alumnoDAO.deleteAlumno(session, id);
    
                        System.out.println("Alumno borrado");
    
                        textFieldIdAlumno.setText("");
                        textFieldNombreAlumno.setText("");
                        textFieldCorreo.setText("");
                        textFieldContraseña.setText("");
                        textFieldTelefono.setText("");
    
                        List<Alumno> alumnos = alumnoDAO.selectAllAlumnos(session);

                        modelTableAlumno.setRowCount(0);
    
                        for (Alumno al : alumnos) {
                            Object[] row = new Object[5];
                            row[0] = al.getId();
                            row[1] = al.getNombre();
                            row[2] = al.getCorreo();
                            row[3] = al.getContraseña();
                            row[4] = al.getTelefono();
                            modelTableAlumno.addRow(row);
                        }
                    } else if (button.getText().equals("Insertar Asignatura")) {
                        String nombre=textFieldNombreAsignatura.getText();
    
                        asignatura = new Asignatura(nombre);
                        asignaturaDAO.insertAsignatura(session, asignatura);
    
                        System.out.println("Asignatura insertada");
    
                        textFieldNombreAsignatura.setText("");
    
                        List<Asignatura> asignaturas = asignaturaDAO.selectAllAsignaturas(session);
    
                        modelTableAsignatura.setRowCount(0);

                        for (Asignatura as : asignaturas) {
                            Object[] row = new Object[2];
                            row[0] = as.getId();
                            row[1] = as.getNombre();
                            modelTableAsignatura.addRow(row);
                        }
                    } else if (button.getText().equals("Actualizar Asignatura")) {
                        String idTexto=textFieldIdAsignatura.getText();
                        int id=Integer.parseInt(idTexto);

                        String nombre=textFieldNombreAsignatura.getText();
    
                        Asignatura asignaturaActualizada = asignaturaDAO.selectAsignaturaById(session, id);
                        asignaturaActualizada.setId(id);
                        asignaturaActualizada.setNombre(nombre);
                        asignaturaDAO.updateAsignatura(session, asignaturaActualizada);
    
                        System.out.println("Asignatura actualizada");
    
                        textFieldIdAsignatura.setText("");
                        textFieldNombreAsignatura.setText("");
    
                        List<Asignatura> asignaturas = asignaturaDAO.selectAllAsignaturas(session);
    
                        modelTableAsignatura.setRowCount(0);

                        for (Asignatura as : asignaturas) {
                            Object[] row = new Object[2];
                            row[0] = as.getId();
                            row[1] = as.getNombre();
                            modelTableAsignatura.addRow(row);
                        }
                    } else if (button.getText().equals("Borrar Asignatura")) {
                        String idTexto=textFieldIdAsignatura.getText();
                        int id=Integer.parseInt(idTexto);
    
                        asignaturaDAO.deleteAsignatura(session, id);
    
                        System.out.println("Asignatura borrada");
    
                        textFieldIdAsignatura.setText("");
                        textFieldNombreAsignatura.setText("");
    
                        List<Asignatura> asignaturas = asignaturaDAO.selectAllAsignaturas(session);
    
                        modelTableAsignatura.setRowCount(0);

                        for (Asignatura as : asignaturas) {
                            Object[] row = new Object[2];
                            row[0] = as.getId();
                            row[1] = as.getNombre();
                            modelTableAsignatura.addRow(row);
                        }
                    }

                    transaction.commit();
                    session.clear();
                } catch (Exception e2) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    e2.printStackTrace();
                } finally {
                    session.close();
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