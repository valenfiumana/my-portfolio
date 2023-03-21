package com.example.myportfolio.repositories;

import com.example.myportfolio.entities.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
}
