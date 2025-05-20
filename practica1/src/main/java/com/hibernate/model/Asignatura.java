package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString

@Entity
@Table(name="asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idAsignatura")
    int id;

    @Column(name="nombre")
    String nombre;

    @ManyToMany(mappedBy = "asignaturas", fetch = FetchType.EAGER)
    private Set<Alumno> alumnos = new HashSet<>();

    public void añadirAlumno(Alumno al) {
        alumnos.add(al);
        al.getAsignaturas().add(this);
    }

    public void quitarAlumno(Alumno al) {
        alumnos.remove(al);
        al.getAsignaturas().remove(this);
    }

    public Asignatura() {
        super();
    }

    public Asignatura(String nombre) {
        super();
        this.nombre = nombre;
    }
}