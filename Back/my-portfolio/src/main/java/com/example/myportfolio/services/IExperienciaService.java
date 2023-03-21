package com.example.myportfolio.services;

import com.example.myportfolio.entities.Experiencia;
import com.example.myportfolio.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    public Experiencia save(Experiencia experiencia) throws ResourceNotFoundException;
    public Optional<Experiencia> findById(Long id) throws ResourceNotFoundException;
    public List<Experiencia> listAll();
    public void delete(Long id) throws ResourceNotFoundException;
    public Experiencia update(Experiencia experiencia) throws ResourceNotFoundException;
}
