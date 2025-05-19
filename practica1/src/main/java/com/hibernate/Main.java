package com.hibernate;

import java.util.List;
import java.util.Scanner;
import com.hibernate.model.Alumno;
import com.hibernate.model.Asignatura;
import com.hibernate.dao.AlumnoDAO;
import com.hibernate.dao.AsignaturaDAO;

public class Main {

    static void menu() {
        System.out.println("Insertar alumno (1)");
        System.out.println("Actualizar alumno (2)");
        System.out.println("Borrar alumno (3)");
        System.out.println("Insertar asignatura (4)");
        System.out.println("Actualizar asignatura (5)");
        System.out.println("Borrar asignatura (6)");
        System.out.println("Salir (7)");
        System.out.println();
    }

    static void mostrarAlumnos() {
        AlumnoDAO alumnoDAO = new AlumnoDAO();

        List<Alumno> alumnos=alumnoDAO.selectAllAlumnos();

        for (Alumno al : alumnos) {
            System.out.println("Id: "+al.getId()+" | "+
                               "Nombre: "+al.getNombre()+" | "+
                               "Correo: "+al.getCorreo()+" | "+
                               "Contraseña: "+al.getContraseña()+" | "+
                               "Teléfono: "+al.getTelefono());
        }

        System.out.println();
    }

    static void mostrarAsignaturas() {
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

        List<Asignatura> asignaturas=asignaturaDAO.selectAllAsignaturas();

        for (Asignatura as : asignaturas) {
            System.out.println("Id: "+as.getId()+" | "+
                               "Nombre: "+as.getNombre());
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Alumno alumno = new Alumno();
        Asignatura asignatura = new Asignatura();

        AlumnoDAO alumnoDAO = new AlumnoDAO();
        AsignaturaDAO asignaturaDAO = new AsignaturaDAO();

        int opcion;

        String nombreAlumno;
        String correo;
        String contraseña;
        int telefono;

        String nombreAsignatura;

        do {
            Main.menu();

            System.out.print("Selecciona una opción: ");
            opcion=entrada.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce un nombre: ");
                    nombreAlumno=entrada.next();
                    System.out.print("Introduce un correo: ");
                    correo=entrada.next();
                    System.out.print("Introduce una contraseña: ");
                    contraseña=entrada.next();
                    System.out.print("Introduce un teléfono: ");
                    telefono=entrada.nextInt();

                    alumno = new Alumno(nombreAlumno, correo, contraseña, telefono);
                    alumnoDAO.insertAlumno(alumno);

                    System.out.println("Alumno insertado");
                    Main.mostrarAlumnos();
                    break;
                case 2:
                    System.out.print("¿Qué quieres actualizar? (nombre = 1 | correo = 2 | contraseña = 3 | teléfono = 4): ");
                    int elegir=entrada.nextInt();
                    if (elegir == 1) {
                        System.out.print("Introduce otro nombre: ");
                        nombreAlumno=entrada.next();

                        alumno.setNombre(nombreAlumno);
                        alumnoDAO.updateAlumno(alumno);

                        System.out.println("Alumno actualizado");
                        Main.mostrarAlumnos();
                    } else if (elegir == 2) {
                        System.out.print("Introduce otro correo: ");
                        correo=entrada.next();

                        alumno.setCorreo(correo);
                        alumnoDAO.updateAlumno(alumno);

                        System.out.println("Alumno actualizado");
                        Main.mostrarAlumnos();
                    } else if (elegir == 3) {
                        System.out.print("Introduce otra contraseña: ");
                        contraseña=entrada.next();

                        alumno.setContraseña(contraseña);
                        alumnoDAO.updateAlumno(alumno);

                        System.out.println("Alumno actualizado");
                        Main.mostrarAlumnos();
                    } else if (elegir == 4) {
                        System.out.print("Introduce otro teléfono: ");
                        telefono=entrada.nextInt();

                        alumno.setTelefono(telefono);
                        alumnoDAO.updateAlumno(alumno);

                        System.out.println("Alumno actualizado");
                        Main.mostrarAlumnos();
                    }
                    break;
                case 3:
                    Main.mostrarAlumnos();

                    System.out.print("¿Qué alumno quieres borrar? Introduce su id: ");
                    int idAlumno=entrada.nextInt();

                    alumnoDAO.deleteAlumno(idAlumno);

                    System.out.println("Alumno borrado");
                    Main.mostrarAlumnos();
                    break;
                case 4:
                    System.out.print("Introduce un nombre: ");
                    nombreAsignatura=entrada.next();

                    asignatura = new Asignatura(nombreAsignatura);
                    asignaturaDAO.insertAsignatura(asignatura);

                    System.out.println("Asignatura insertada");
                    Main.mostrarAsignaturas();
                    break;
                case 5:
                    Main.mostrarAsignaturas();
                    
                    System.out.print("¿Qué asignatura quieres actualizar?: ");
                    int idAsignatura=entrada.nextInt();

                    asignatura=asignaturaDAO.selectAsignaturaById(idAsignatura);

                    System.out.print("Introduce otro nombre: ");
                    nombreAsignatura=entrada.next();

                    asignatura.setNombre(nombreAsignatura);
                    asignaturaDAO.updateAsignatura(asignatura);

                    System.out.println("Asignatura actualizada");
                    Main.mostrarAsignaturas();
                    break;
                case 6:
                    Main.mostrarAsignaturas();
                    
                    System.out.print("¿Qué asignatura quieres borrar?: ");
                    idAsignatura=entrada.nextInt();

                    asignaturaDAO.deleteAsignatura(idAsignatura);
                
                    System.out.println("Asignatura borrada");
                    Main.mostrarAsignaturas();
                    break;
                case 7:
                    System.out.println("Has salido");
                    break;
                default:
                    System.out.print("OPCIÓN NO VÁLIDA. Por favor, selecciona una opción del menú: ");
                    opcion=entrada.nextInt();
            }
        } while (opcion!=7);
    }
}