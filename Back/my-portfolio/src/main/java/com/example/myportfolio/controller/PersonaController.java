package com.example.myportfolio.controller;

import com.example.myportfolio.entities.Persona;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/personas")
public class PersonaController {
    private PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Object> guardarPersona(@RequestBody Persona persona) throws ResourceNotFoundException{
        return ResponseEntity.ok(personaService.save(persona));
    }

    //FIND BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Persona> persona = personaService.findById(id);
        if(persona.isPresent()){
            return ResponseEntity.ok(persona.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //LIST ALL
    @GetMapping
    public ResponseEntity<List<Persona>> listAll() {
        return ResponseEntity.ok(personaService.listAll());
    }

    //BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPersona(@PathVariable Long id) throws  ResourceNotFoundException {
        Optional<Persona> persona = personaService.findById(id);
        if(persona.isPresent()){
            personaService.delete(id);
            return ResponseEntity.ok("La persona con id "+id+" fue eliminada");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La persona con id "+id+" no existe");
        }

    }

    //ACTUALIZAR
    @PutMapping
    public ResponseEntity<Persona> actualizarPersona(@RequestBody Persona persona) throws ResourceNotFoundException {
        Optional<Persona> personaPedida = personaService.findById(persona.getId());
        if(personaPedida.isPresent()){
            Persona personaActualizada = personaService.update(persona);
            return ResponseEntity.ok(personaActualizada);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
