package com.example.myportfolio.services;

import com.example.myportfolio.entities.Educacion;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.repositories.IEducacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducacionService {
    private IEducacionRepository educacionRepository;

    @Autowired
    public EducacionService(IEducacionRepository educacionRepository) {
        this.educacionRepository = educacionRepository;
    }


    public Educacion save(Educacion educacion) throws ResourceNotFoundException {
        if(educacion.getTitulo().isEmpty()||educacion.getDescripcion().isEmpty()){
            throw new ResourceNotFoundException("Hay campos vacíos");
        }
        else{
            return educacionRepository.save(educacion);
        }
    }


    public Optional<Educacion> findById(Long id) throws ResourceNotFoundException {
        Optional<Educacion> educacion = educacionRepository.findById(id);
        if (educacion.isPresent()) {
            return educacion;
        } else {
            throw new ResourceNotFoundException("La educacion con id: "+id+" NO fue encontrada");
        }
    }


    public List<Educacion> listAll() {
        return educacionRepository.findAll();
    }


    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Educacion> educacion = educacionRepository.findById(id);
        if(educacion.isPresent()){
            educacionRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("La educacion con id "+id+" no existe y no pudo ser eliminado");
        }
    }

    public Educacion update(Educacion educacion) throws ResourceNotFoundException {
        Optional<Educacion> educacionActualizar = educacionRepository.findById(educacion.getId());
        if(educacionActualizar.isPresent()){
            return educacionRepository.save(educacion);
        }
        else{
            throw new ResourceNotFoundException("La educacion con id "+educacion.getId()+" no existe y no pudo ser actualizado");
        }
    }
}
