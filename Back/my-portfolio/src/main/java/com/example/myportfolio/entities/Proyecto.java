package com.example.myportfolio.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length=100)
    private String titulo;
    @NotNull
    @Column(length=100)
    private String url_imagen;
    @Column(length=100)
    private String url_proyecto;
    @NotNull
    @Column
    private String descripcion;
    @Column
    private Long personaId;

    public Proyecto(){}

    public Proyecto(Long id, String titulo, String url_imagen, String url_proyecto, String descripcion, Long personaId) {
        this.id = id;
        this.titulo = titulo;
        this.url_imagen = url_imagen;
        this.url_proyecto = url_proyecto;
        this.descripcion = descripcion;
        this.personaId = personaId;
    }

    public Proyecto(Long id, String titulo, String url_imagen, String url_proyecto, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.url_imagen = url_imagen;
        this.url_proyecto = url_proyecto;
        this.descripcion = descripcion;
    }
}
