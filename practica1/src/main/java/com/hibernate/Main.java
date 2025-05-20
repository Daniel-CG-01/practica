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
        System.out.println("Mostrar alumnos (4)");
        System.out.println("Insertar asignatura (5)");
        System.out.println("Actualizar asignatura (6)");
        System.out.println("Borrar asignatura (7)");
        System.out.println("Mostrar asignaturas (8)");
        System.out.println("Asignar una asignatura a un alumno (9)");
        System.out.println("Quitar una asignatura a un alumno (10)");
        System.out.println("Salir (11)");
        System.out.println();
    }

    static void mostrarAlumnos(AlumnoDAO alumnoDAO) {
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

    static void mostrarAsignaturas(AsignaturaDAO asignaturaDAO) {
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

            entrada.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce un nombre: ");
                    nombreAlumno=entrada.nextLine();
                    System.out.print("Introduce un correo: ");
                    correo=entrada.nextLine();
                    System.out.print("Introduce una contraseña: ");
                    contraseña=entrada.nextLine();
                    System.out.print("Introduce un teléfono: ");
                    telefono=entrada.nextInt();

                    alumno = new Alumno(nombreAlumno, correo, contraseña, telefono);
                    alumnoDAO.insertAlumno(alumno);

                    System.out.println("Alumno insertado");
                    break;
                case 2:
                    Main.mostrarAlumnos(alumnoDAO);

                    System.out.print("¿Qué alumno quieres actualizar? Introduce su id: ");
                    int idAlumno=entrada.nextInt();

                    Alumno alumnoActualizado=alumnoDAO.selectAlumnoById(idAlumno);

                    System.out.print("¿Qué quieres actualizar? (nombre = 1 | correo = 2 | contraseña = 3 | teléfono = 4) "+
                                     "Selecciona una opción: ");
                    int elegir=entrada.nextInt();

                    if (elegir == 1) {
                        System.out.print("Introduce otro nombre: ");
                        nombreAlumno=entrada.nextLine();

                        alumnoActualizado.setNombre(nombreAlumno);
                        alumnoDAO.updateAlumno(alumnoActualizado);

                        System.out.println("Alumno actualizado");
                    } else if (elegir == 2) {
                        System.out.print("Introduce otro correo: ");
                        correo=entrada.nextLine();

                        alumnoActualizado.setCorreo(correo);
                        alumnoDAO.updateAlumno(alumnoActualizado);

                        System.out.println("Alumno actualizado");
                    } else if (elegir == 3) {
                        System.out.print("Introduce otra contraseña: ");
                        contraseña=entrada.nextLine();

                        alumnoActualizado.setContraseña(contraseña);
                        alumnoDAO.updateAlumno(alumnoActualizado);

                        System.out.println("Alumno actualizado");
                    } else if (elegir == 4) {
                        System.out.print("Introduce otro teléfono: ");
                        telefono=entrada.nextInt();

                        alumnoActualizado.setTelefono(telefono);
                        alumnoDAO.updateAlumno(alumnoActualizado);

                        System.out.println("Alumno actualizado");
                    }
                    break;
                case 3:
                    Main.mostrarAlumnos(alumnoDAO);

                    System.out.print("¿Qué alumno quieres borrar? Introduce su id: ");
                    idAlumno=entrada.nextInt();

                    alumnoDAO.deleteAlumno(idAlumno);

                    System.out.println("Alumno borrado");
                    break;
                case 4:
                    Main.mostrarAlumnos(alumnoDAO);
                    break;
                case 5:
                    System.out.print("Introduce un nombre: ");
                    nombreAsignatura=entrada.nextLine();

                    asignatura = new Asignatura(nombreAsignatura);
                    asignaturaDAO.insertAsignatura(asignatura);

                    System.out.println("Asignatura insertada");
                    break;
                case 6:
                    Main.mostrarAsignaturas(asignaturaDAO);
                    
                    System.out.print("¿Qué asignatura quieres actualizar? Introduce su id: ");
                    int idAsignatura=entrada.nextInt();

                    Asignatura asignaturaActualizada=asignaturaDAO.selectAsignaturaById(idAsignatura);

                    System.out.print("Introduce otro nombre: ");
                    nombreAsignatura=entrada.nextLine();

                    asignaturaActualizada.setNombre(nombreAsignatura);
                    asignaturaDAO.updateAsignatura(asignaturaActualizada);

                    System.out.println("Asignatura actualizada");
                    break;
                case 7:
                    Main.mostrarAsignaturas(asignaturaDAO);
                    
                    System.out.print("¿Qué asignatura quieres borrar? Introduce su id: ");
                    idAsignatura=entrada.nextInt();

                    asignaturaDAO.deleteAsignatura(idAsignatura);
                
                    System.out.println("Asignatura borrada");
                    break;
                case 8:
                    Main.mostrarAsignaturas(asignaturaDAO);
                    break;
                case 9:
                    Main.mostrarAsignaturas(asignaturaDAO);

                    System.out.print("Elige una asignatura. Introduce su id: ");
                    idAsignatura=entrada.nextInt();

                    Asignatura asignaturaSeleccionada=asignaturaDAO.selectAsignaturaById(idAsignatura);

                    Main.mostrarAlumnos(alumnoDAO);

                    System.out.print("¿A qué alumno quieres asignarle esa asignatura? Introduce su id: ");
                    idAlumno=entrada.nextInt();

                    Alumno alumnoSeleccionado=alumnoDAO.selectAlumnoById(idAlumno);

                    alumnoSeleccionado.añadirAsignatura(asignaturaSeleccionada);
                    alumnoDAO.updateAlumno(alumnoSeleccionado);
                    break;
                case 10:
                    Main.mostrarAsignaturas(asignaturaDAO);

                    System.out.print("Elige una asignatura. Introduce su id: ");
                    idAsignatura=entrada.nextInt();

                    Asignatura asignaturaEliminada=asignaturaDAO.selectAsignaturaById(idAsignatura);

                    Main.mostrarAlumnos(alumnoDAO);

                    System.out.print("¿A qué alumno quieres eliminarle esa asignatura? Introduce su id: ");
                    idAlumno=entrada.nextInt();

                    Alumno alumnoEliminarAsignatura=alumnoDAO.selectAlumnoById(idAlumno);

                    alumnoEliminarAsignatura.quitarAsignatura(asignaturaEliminada);
                    alumnoDAO.updateAlumno(alumnoEliminarAsignatura);
                    break;
                case 11:
                    System.out.println("Has salido");
                    break;
                default:
                    System.out.print("OPCIÓN NO VÁLIDA. Por favor, selecciona una opción del menú: ");
                    opcion=entrada.nextInt();
            }
        } while (opcion!=11);
    }
}