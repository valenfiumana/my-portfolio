package com.example.myportfolio.controller;

import com.example.myportfolio.entities.Experiencia;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.services.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/experiencia")
public class ExperienciaController {
    ExperienciaService experienciaService;

    @Autowired
    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Object> guardarExperiencia(@RequestBody Experiencia experiencia) throws ResourceNotFoundException {
        return ResponseEntity.ok(experienciaService.save(experiencia));
    }

    //FIND BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Experiencia> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Experiencia> experiencia = experienciaService.findById(id);
        if(experiencia.isPresent()){
            return ResponseEntity.ok(experiencia.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //LIST ALL
    @GetMapping
    public ResponseEntity<List<Experiencia>> listAll() {
        return ResponseEntity.ok(experienciaService.listAll());
    }

    //BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarExperiencia(@PathVariable Long id) throws  ResourceNotFoundException {
        Optional<Experiencia> experiencia = experienciaService.findById(id);
        if(experiencia.isPresent()){
            experienciaService.delete(id);
            return ResponseEntity.ok("La experiencia con id "+id+" fue eliminada");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La experiencia con id "+id+" no existe");
        }

    }

    //ACTUALIZAR
    @PutMapping
    public ResponseEntity<Experiencia> actualizarExperiencia(@RequestBody Experiencia experiencia) throws ResourceNotFoundException {
        Optional<Experiencia> experienciaPedida = experienciaService.findById(experiencia.getId());
        if(experienciaPedida.isPresent()){
            Experiencia experienciaActualizada = experienciaService.update(experiencia);
            return ResponseEntity.ok(experienciaActualizada);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}