package com.example.myportfolio.services;

import com.example.myportfolio.entities.Proyecto;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.repositories.IProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {
    private IProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoService(IProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }


    public Proyecto save(Proyecto proyecto) throws ResourceNotFoundException {
        if(proyecto.getTitulo().isEmpty()||proyecto.getDescripcion().isEmpty()){
            throw new ResourceNotFoundException("Hay campos vacíos");
        }
        else{
            return proyectoRepository.save(proyecto);
        }
    }


    public Optional<Proyecto> findById(Long id) throws ResourceNotFoundException {
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);
        if (proyecto.isPresent()) {
            return proyecto;
        } else {
            throw new ResourceNotFoundException("El proyecto con id: "+id+" NO fue encontrado");
        }
    }


    public List<Proyecto> listAll() {
        return proyectoRepository.findAll();
    }


    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Proyecto> proyecto = proyectoRepository.findById(id);
        if(proyecto.isPresent()){
            proyectoRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("El proyecto con id "+id+" no existe y no pudo ser eliminado");
        }
    }

    public Proyecto update(Proyecto proyecto) throws ResourceNotFoundException {
        Optional<Proyecto> proyectoActualizar = proyectoRepository.findById(proyecto.getId());
        if(proyectoActualizar.isPresent()){
            return proyectoRepository.save(proyecto);
        }
        else{
            throw new ResourceNotFoundException("El proyecto con id "+proyecto.getId()+" no existe y no pudo ser actualizado");
        }
    }
}
