package com.example.myportfolio.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(length=45)
    private String puesto;
    @NotNull
    @Column
    private String descripcion;
    @NotNull
    @Column
    private Integer anioInicio;
    @Column
    private Integer anioFin;
    @Column
    private String img_institucion;
    @Column
    private Long personaId;

    public Experiencia(){}

    public Experiencia(String puesto, String descripcion, Integer anioInicio, Integer anioFin, String img_institucion, Long personaId) {
        this.puesto = puesto;
        this.descripcion = descripcion;
        this.anioInicio = anioInicio;
        this.anioFin = anioFin;
        this.img_institucion = img_institucion;
        this.personaId = personaId;
    }
}
