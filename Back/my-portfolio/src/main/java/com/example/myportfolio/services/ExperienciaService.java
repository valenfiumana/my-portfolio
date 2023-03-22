package com.example.myportfolio.services;

import com.example.myportfolio.entities.Experiencia;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.repositories.IExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService{
    private IExperienciaRepository experienciaRepository;

    @Autowired
    public ExperienciaService(IExperienciaRepository experienciaRepository) {
        this.experienciaRepository = experienciaRepository;
    }


    public Experiencia save(Experiencia experiencia) throws ResourceNotFoundException {
        if(experiencia.getPuesto().isEmpty()||experiencia.getDescripcion().isEmpty()){
            throw new ResourceNotFoundException("Hay campos vacíos");
        }
        else{
            return experienciaRepository.save(experiencia);
        }
    }


    public Optional<Experiencia> findById(Long id) throws ResourceNotFoundException {
        Optional<Experiencia> experiencia = experienciaRepository.findById(id);
        if (experiencia.isPresent()) {
            return experiencia;
        } else {
            throw new ResourceNotFoundException("La experiencia con id: "+id+" NO fue encontrada");
        }
    }


    public List<Experiencia> listAll() {
        return experienciaRepository.findAll();
    }


    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Experiencia> experiencia = experienciaRepository.findById(id);
        if(experiencia.isPresent()){
            experienciaRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("La experiencia con id "+id+" no existe y no pudo ser eliminado");
        }
    }

    public Experiencia update(Experiencia experiencia) throws ResourceNotFoundException {
        Optional<Experiencia> experienciaActualizar = experienciaRepository.findById(experiencia.getId());
        if(experienciaActualizar.isPresent()){
            return experienciaRepository.save(experiencia);
        }
        else{
            throw new ResourceNotFoundException("La experiencia con id "+experiencia.getId()+" no existe y no pudo ser actualizado");
        }
    }


}