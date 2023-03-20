package com.example.myportfolio.services;

import com.example.myportfolio.entities.Persona;
import com.example.myportfolio.exceptions.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public Persona save(Persona persona) throws ResourceNotFoundException;
    public Optional<Persona> findById(Long id) throws ResourceNotFoundException;
    public List<Persona> listAll();
    public void delete(Long id) throws ResourceNotFoundException;
    public Persona update(Persona persona) throws ResourceNotFoundException;
}
