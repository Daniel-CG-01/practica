package com.hibernate.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter

@Entity
@Table(name="alumno")
public class Alumno {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="nombre")
    String nombre;

    @Column(name="correo")
    String correo;

    @Column(name="contraseña")
    String contraseña;

    @Column(name="telefono")
    int telefono;

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