package com.example.myportfolio.security.entities;

import com.example.myportfolio.security.enums.RolNombre;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    public Rol(){}
    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }


}
