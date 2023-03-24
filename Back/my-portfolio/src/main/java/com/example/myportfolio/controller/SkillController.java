package com.example.myportfolio.controller;

import com.example.myportfolio.entities.Skill;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/skills")
public class SkillController {
    SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Object> guardarSkill(@RequestBody Skill skill) throws ResourceNotFoundException {
        return ResponseEntity.ok(skillService.save(skill));
    }

    //FIND BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Skill> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Skill> skill = skillService.findById(id);
        if(skill.isPresent()){
            return ResponseEntity.ok(skill.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //LIST ALL
    @GetMapping
    public ResponseEntity<List<Skill>> listAll() {
        return ResponseEntity.ok(skillService.listAll());
    }

    //BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarSkill(@PathVariable Long id) throws  ResourceNotFoundException {
        Optional<Skill> skill = skillService.findById(id);
        if(skill.isPresent()){
            skillService.delete(id);
            return ResponseEntity.ok("El skill con id "+id+" fue eliminada");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El skill con id "+id+" no existe");
        }

    }

    //ACTUALIZAR
    @PutMapping
    public ResponseEntity<Skill> actualizarSkill(@RequestBody Skill experiencia) throws ResourceNotFoundException {
        Optional<Skill> skillPedido = skillService.findById(experiencia.getId());
        if(skillPedido.isPresent()){
            Skill skillActualizado = skillService.update(experiencia);
            return ResponseEntity.ok(skillActualizado);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
