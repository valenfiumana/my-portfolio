package com.example.myportfolio.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length=45)
    @NotNull
    private String nombre;
    @Column
    @NotNull
    private Integer porcentaje;
    @Column
    private Long personaId;

    public Skill(){}

    public Skill(String nombre, Integer porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public Skill(String nombre, Integer porcentaje, Long personaId) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.personaId = personaId;
    }
}
