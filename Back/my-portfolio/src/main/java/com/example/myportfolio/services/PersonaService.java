package com.example.myportfolio.services;

import com.example.myportfolio.entities.Persona;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.repositories.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService{
    private IPersonaRepository personaRepository;

    @Autowired
    public PersonaService(IPersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }


    @Override
    public Persona save(Persona persona) throws ResourceNotFoundException {
        if(persona.getNombre().isEmpty()||persona.getApellido().isEmpty()){
            throw new ResourceNotFoundException("Hay campos vacíos");
        }
        else{
            return personaRepository.save(persona);
        }
    }

    @Override
    public Optional<Persona> findById(Long id) throws ResourceNotFoundException {
        Optional<Persona> persona = personaRepository.findById(id);
        if (persona.isPresent()) {
            return persona;
        } else {
            throw new ResourceNotFoundException("La persona con id: "+id+" NO fue encontrada");
        }
    }

    @Override
    public List<Persona> listAll() {
        return personaRepository.findAll();
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Persona> persona = personaRepository.findById(id);
        if(persona.isPresent()){
            personaRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("La persona con id "+id+" no existe y no pudo ser eliminado");
        }
    }

    @Override
    public Persona update(Persona persona) throws ResourceNotFoundException {
        Optional<Persona> personaActualizar = personaRepository.findById(persona.getId());
        if(personaActualizar.isPresent()){
            return personaRepository.save(persona);
        }
        else{
            throw new ResourceNotFoundException("La persona con id "+persona.getId()+" no existe y no pudo ser actualizado");
        }
    }
}
