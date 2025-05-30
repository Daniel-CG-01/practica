package com.hibernate.GUIBuilder.helper_classes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
                                       JTextField textFieldIdAlumnoRelacion, JTextField textFieldIdAsignaturaRelacion, 
                                       DefaultTableModel modelTableAlumno_Asignatura, 
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

                        String regexCorreo="^\\w+@\\w+\\.[a-z]{2,3}$";
    
                        String contrasenya=textFieldContraseña.getText();

                        String regexContrasenya="^\\w{8}$";
    
                        String telefonoTexto=textFieldTelefono.getText();

                        String regexTelefono="^\\d{9}$";

                        if (nombre.length()==0) {
                            JOptionPane.showMessageDialog(textFieldNombreAlumno, "ERROR. No puedes dejar el nombre en blanco");
                        } else if (correo.length()==0) {
                            JOptionPane.showMessageDialog(textFieldCorreo, "ERROR. No puedes dejar el correo en blanco");
                        } else if (!correo.matches(regexCorreo)) {
                            JOptionPane.showMessageDialog(textFieldCorreo, "ERROR. El formato del correo es INCORRECTO. Tiene que ser así: xxxx@xxxx.xxxx");
                        } else if (contrasenya.length()==0) {
                            JOptionPane.showMessageDialog(textFieldContraseña, "ERROR. No puedes dejar la contraseña en blanco");
                        } else if (!contrasenya.matches(regexContrasenya)) {
                            JOptionPane.showMessageDialog(textFieldContraseña, "ERROR. El formato de la contraseña es INCORRECTO. Tiene que tener ocho carácteres");
                        } else if (telefonoTexto.length()==0) {
                            JOptionPane.showMessageDialog(textFieldTelefono, "ERROR. No puedes dejar el teléfono en blanco");
                        } else if (!telefonoTexto.matches(regexTelefono)) {
                            JOptionPane.showMessageDialog(textFieldTelefono, "ERROR. El formato del teléfono es INCORRECTO. Tiene que tener nueve carácteres numéricos");
                        } else {
                            int telefono=Integer.parseInt(telefonoTexto);

                            alumno = new Alumno(nombre, correo, contrasenya, telefono);
                            alumnoDAO.insertAlumno(session, alumno);

                            transaction.commit();
                            session.clear();
        
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
                        }
                    } else if (button.getText().equals("Actualizar Alumno")) {
                        String idTexto=textFieldIdAlumno.getText();

                        String nombre=textFieldNombreAlumno.getText();
    
                        String correo=textFieldCorreo.getText();

                        String regexCorreo="^\\w+@\\w+\\.[a-z]{2,3}$";
    
                        String contrasenya=textFieldContraseña.getText();

                        String regexContrasenya="^\\w{8}$";
    
                        String telefonoTexto=textFieldTelefono.getText();

                        String regexTelefono="^\\d{9}$";

                        if (nombre.length()==0) {
                            JOptionPane.showMessageDialog(textFieldNombreAlumno, "ERROR. No puedes dejar el nombre en blanco");
                        } else if (correo.length()==0) {
                            JOptionPane.showMessageDialog(textFieldCorreo, "ERROR. No puedes dejar el correo en blanco");
                        } else if (!correo.matches(regexCorreo)) {
                            JOptionPane.showMessageDialog(textFieldCorreo, "ERROR. El formato del correo es INCORRECTO. Tiene que ser así: xxxx@xxxx.xxxx");
                        } else if (contrasenya.length()==0) {
                            JOptionPane.showMessageDialog(textFieldContraseña, "ERROR. No puedes dejar la contraseña en blanco");
                        } else if (!contrasenya.matches(regexContrasenya)) {
                            JOptionPane.showMessageDialog(textFieldContraseña, "ERROR. El formato de la contraseña es INCORRECTO. Tiene que tener ocho carácteres");
                        } else if (telefonoTexto.length()==0) {
                            JOptionPane.showMessageDialog(textFieldTelefono, "ERROR. No puedes dejar el teléfono en blanco");
                        } else if (!telefonoTexto.matches(regexTelefono)) {
                            JOptionPane.showMessageDialog(textFieldTelefono, "ERROR. El formato del teléfono es INCORRECTO. Tiene que tener nueve carácteres numéricos");
                        } else {
                            int id=Integer.parseInt(idTexto);

                            int telefono=Integer.parseInt(telefonoTexto);
                            
                            Alumno alumnoActualizado = alumnoDAO.selectAlumnoById(session, id);
                            alumnoActualizado.setId(id);
                            alumnoActualizado.setNombre(nombre);
                            alumnoActualizado.setCorreo(correo);
                            alumnoActualizado.setContraseña(contrasenya);
                            alumnoActualizado.setTelefono(telefono);
                            alumnoDAO.updateAlumno(session, alumnoActualizado);

                            transaction.commit();
                            session.clear();
        
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
                        }
                    } else if (button.getText().equals("Borrar Alumno")) {
                        String idTexto=textFieldIdAlumno.getText();
                        int id=Integer.parseInt(idTexto);
    
                        alumnoDAO.deleteAlumno(session, id);

                        transaction.commit();
                        session.clear();
    
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

                        //Al eliminar un alumno, además de actualizar la tabla Alumno, también se actualiza la tercera tabla

                        modelTableAlumno_Asignatura.setRowCount(0);

                        for (Alumno al : alumnos) {
                            for (Asignatura as : al.getAsignaturas()) {
                                Object[] row = new Object[2];
                                row[0] = al.getId();
                                row[1] = as.getId();
                                modelTableAlumno_Asignatura.addRow(row);
                            }
                        }
                    } else if (button.getText().equals("Insertar Asignatura")) {
                        String nombre=textFieldNombreAsignatura.getText();

                        if (nombre.length()==0) {
                            JOptionPane.showMessageDialog(textFieldNombreAsignatura, "ERROR. No puedes dejar el nombre el blanco");
                        } else {
                            asignatura = new Asignatura(nombre);
                            asignaturaDAO.insertAsignatura(session, asignatura);

                            transaction.commit();
                            session.clear();
        
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
                        }
                    } else if (button.getText().equals("Actualizar Asignatura")) {
                        String idTexto=textFieldIdAsignatura.getText();
                        int id=Integer.parseInt(idTexto);

                        String nombre=textFieldNombreAsignatura.getText();

                        if (textFieldNombreAsignatura.getText().length()==0) {
                            JOptionPane.showMessageDialog(textFieldNombreAsignatura, "ERROR. No puedes dejar el nombre el blanco");
                        } else {
                            Asignatura asignaturaActualizada = asignaturaDAO.selectAsignaturaById(session, id);
                            asignaturaActualizada.setId(id);
                            asignaturaActualizada.setNombre(nombre);
                            asignaturaDAO.updateAsignatura(session, asignaturaActualizada);

                            transaction.commit();
                            session.clear();
        
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
                        }
                    } else if (button.getText().equals("Borrar Asignatura")) {
                        String idTexto=textFieldIdAsignatura.getText();
                        int id=Integer.parseInt(idTexto);
    
                        asignaturaDAO.deleteAsignatura(session, id);

                        transaction.commit();
                        session.clear();
    
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

                        //Al eliminar una asignatura, además de actualizar la tabla Asignatura, también se actualiza la tercera tabla

                        List<Alumno> alumnos = alumnoDAO.selectAllAlumnos(session);

                        modelTableAlumno_Asignatura.setRowCount(0);

                        for (Alumno al : alumnos) {
                            for (Asignatura as : al.getAsignaturas()) {
                                Object[] row = new Object[2];
                                row[0] = al.getId();
                                row[1] = as.getId();
                                modelTableAlumno_Asignatura.addRow(row);
                            }
                        }
                    } else if (button.getText().equals("Añadir relación")) {
                        String idAlumnoTexto=textFieldIdAlumnoRelacion.getText();
                        int idAlumno=Integer.parseInt(idAlumnoTexto);

                        String idAsignaturaTexto=textFieldIdAsignaturaRelacion.getText();
                        int idAsignatura=Integer.parseInt(idAsignaturaTexto);

                        if (idAlumnoTexto.length()==0) {
                            JOptionPane.showMessageDialog(textFieldIdAlumnoRelacion, "ERROR. No puedes dejar el id del alumno en blanco");
                        } else if (idAsignaturaTexto.length()==0) {
                            JOptionPane.showMessageDialog(textFieldIdAsignaturaRelacion, "ERROR. No puedes dejar el id de la asignatura en blanco");
                        } else {
                            Alumno alumnoSeleccionado=alumnoDAO.selectAlumnoById(session, idAlumno);

                            Asignatura asignaturaSeleccionada=asignaturaDAO.selectAsignaturaById(session, idAsignatura);

                            alumnoSeleccionado.añadirAsignatura(asignaturaSeleccionada);

                            transaction.commit();
                            session.clear();

                            System.out.println("Relación añadida");

                            textFieldIdAlumnoRelacion.setText("");
                            textFieldIdAsignaturaRelacion.setText("");

                            List<Alumno> alumnos = alumnoDAO.selectAllAlumnos(session);

                            modelTableAlumno_Asignatura.setRowCount(0);

                            for (Alumno al : alumnos) {
                                for (Asignatura as : al.getAsignaturas()) {
                                    Object[] row = new Object[2];
                                    row[0] = al.getId();
                                    row[1] = as.getId();
                                    modelTableAlumno_Asignatura.addRow(row);
                                }
                            }
                        }
                    } else if (button.getText().equals("Eliminar relación")) {
                        String idAlumnoTexto=textFieldIdAlumnoRelacion.getText();
                        int idAlumno=Integer.parseInt(idAlumnoTexto);

                        String idAsignaturaTexto=textFieldIdAsignaturaRelacion.getText();
                        int idAsignatura=Integer.parseInt(idAsignaturaTexto);

                        if (idAlumnoTexto.length()==0) {
                            JOptionPane.showMessageDialog(textFieldIdAlumnoRelacion, "ERROR. No puedes dejar el id del alumno en blanco");
                        } else if (idAsignaturaTexto.length()==0) {
                            JOptionPane.showMessageDialog(textFieldIdAsignaturaRelacion, "ERROR. No puedes dejar el id de la asignatura en blanco");
                        } else {
                            Alumno alumnoSeleccionado=alumnoDAO.selectAlumnoById(session, idAlumno);

                            Asignatura asignaturaSeleccionada=asignaturaDAO.selectAsignaturaById(session, idAsignatura);

                            alumnoSeleccionado.quitarAsignatura(asignaturaSeleccionada);

                            transaction.commit();
                            session.clear();

                            System.out.println("Relación quitada");

                            textFieldIdAlumnoRelacion.setText("");
                            textFieldIdAsignaturaRelacion.setText("");

                            List<Alumno> alumnos = alumnoDAO.selectAllAlumnos(session);

                            modelTableAlumno_Asignatura.setRowCount(0);

                            for (Alumno al : alumnos) {
                                for (Asignatura as : al.getAsignaturas()) {
                                    Object[] row = new Object[2];
                                    row[0] = al.getId();
                                    row[1] = as.getId();
                                    modelTableAlumno_Asignatura.addRow(row);
                                }
                            }
                        }
                    }
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