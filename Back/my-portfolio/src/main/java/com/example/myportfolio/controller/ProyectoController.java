package com.example.myportfolio.controller;

import com.example.myportfolio.entities.Proyecto;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://myportfolio-frontend.web.app")
@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
    ProyectoService proyectoService;

    @Autowired
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }

    //GUARDAR
    @PostMapping
    public ResponseEntity<Object> guardarProyecto(@RequestBody Proyecto proyecto) throws ResourceNotFoundException {
        return ResponseEntity.ok(proyectoService.save(proyecto));
    }

    //FIND BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Proyecto> findById(@PathVariable Long id) throws ResourceNotFoundException {
        Optional<Proyecto> proyecto = proyectoService.findById(id);
        if(proyecto.isPresent()){
            return ResponseEntity.ok(proyecto.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //LIST ALL
    @GetMapping
    public ResponseEntity<List<Proyecto>> listAll() {
        return ResponseEntity.ok(proyectoService.listAll());
    }

    //BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarProyecto(@PathVariable Long id) throws  ResourceNotFoundException {
        Optional<Proyecto> proyecto = proyectoService.findById(id);
        if(proyecto.isPresent()){
            proyectoService.delete(id);
            return ResponseEntity.ok("El proyecto con id "+id+" fue eliminadp");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El proyecto con id "+id+" no existe");
        }

    }

    //ACTUALIZAR
    @PutMapping
    public ResponseEntity<Proyecto> actualizarProyecto(@RequestBody Proyecto proyecto) throws ResourceNotFoundException {
        Optional<Proyecto> proyectoPedido = proyectoService.findById(proyecto.getId());
        if(proyectoPedido.isPresent()){
            Proyecto proyectoActualizado = proyectoService.update(proyecto);
            return ResponseEntity.ok(proyectoActualizado);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
