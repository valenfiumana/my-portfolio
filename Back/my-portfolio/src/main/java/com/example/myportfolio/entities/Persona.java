package com.example.myportfolio.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

@Getter
@Setter
@Entity
@Table
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column
    @NotNull
    @Size(min = 5, max = 20, message = "No cumple con longitud, minimo 5 maximo 50")
    private String nombre;
    @Column
    @NotNull
    @Size(min = 5, max = 20, message = "No cumple con longitud, minimo 5 maximo 50")
    private String apellido;
    @Column
    private String apodo;
    @Column
    private String url_img;
    @Column(columnDefinition="TEXT")
    private String sobreMi;
    @Column
    private String puesto;
    @Column
    private String github;
    @Column
    private String linkedin;
}
