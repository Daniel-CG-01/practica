package com.hibernate.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter

@Entity
@Table(name="alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="idAlumno")
    int id;

    @Column(name="nombre")
    String nombre;

    @Column(name="correo")
    String correo;

    @Column(name="contraseña")
    String contraseña;

    @Column(name="telefono")
    int telefono;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name="alumno_asignatura", joinColumns = @JoinColumn(name = "idAlumno"), inverseJoinColumns = @JoinColumn(name = "idAsignatura"))
    private Set<Asignatura> asignaturas = new HashSet<>();

    public void añadirAsignatura(Asignatura as) {
        asignaturas.add(as);
        as.getAlumnos().add(this);
    }

    public void quitarAsignatura(Asignatura as) {
        asignaturas.remove(as);
        as.getAlumnos().remove(this);
    }

    public Alumno() {
        super();
    }

    public Alumno(String nombre, String correo, String contraseña, int telefono) {
        super();
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefono = telefono;
    }
}