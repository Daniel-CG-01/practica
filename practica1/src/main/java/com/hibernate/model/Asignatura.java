package com.hibernate.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter

@Entity
@Table(name="asignatura")
public class Asignatura {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id")
    int id;

    @Column(name="nombre")
    String nombre;

    public Asignatura() {
        super();
    }

    public Asignatura(String nombre) {
        super();
        this.nombre = nombre;
    }
}