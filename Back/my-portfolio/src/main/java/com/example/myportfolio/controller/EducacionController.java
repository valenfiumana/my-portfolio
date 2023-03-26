package com.example.myportfolio.controller;

import com.example.myportfolio.entities.Educacion;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.services.EducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/educacion")
public class EducacionController {
    EducacionService educacionService;

    @Autowired
    public EducacionController(EducacionService educacionService) {
        this.educacionService = educacionService;
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Object> guardarEducacion(@RequestBody Educacion educacion) throws ResourceNotFoundException {
        return ResponseEntity.ok(educacionService.save(educacion));
    }

    //FIND BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Educacion> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Educacion> educacion = educacionService.findById(id);
        if(educacion.isPresent()){
            return ResponseEntity.ok(educacion.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //LIST ALL
    @GetMapping
    public ResponseEntity<List<Educacion>> listAll() {
        return ResponseEntity.ok(educacionService.listAll());
    }

    //BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarEducacion(@PathVariable Long id) throws  ResourceNotFoundException {
        Optional<Educacion> educacion = educacionService.findById(id);
        if(educacion.isPresent()){
            educacionService.delete(id);
            return ResponseEntity.ok("La educacion con id "+id+" fue eliminada");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La educacion con id "+id+" no existe");
        }

    }

    //ACTUALIZAR
    @PutMapping
    public ResponseEntity<Educacion> actualizarEducacion(@RequestBody Educacion educacion) throws ResourceNotFoundException {
        Optional<Educacion> educacionPedida = educacionService.findById(educacion.getId());
        if(educacionPedida.isPresent()){
            Educacion educacionActualizada = educacionService.update(educacion);
            return ResponseEntity.ok(educacionActualizada);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
