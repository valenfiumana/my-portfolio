package com.example.myportfolio.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "personaId")
    private List<Experiencia> experiencia = new ArrayList<>();

    public Persona(){}
    public Persona(String nombre, String apellido, String apodo, String url_img, String sobreMi, String puesto, String github, String linkedin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.apodo = apodo;
        this.url_img = url_img;
        this.sobreMi = sobreMi;
        this.puesto = puesto;
        this.github = github;
        this.linkedin = linkedin;
    }
}
