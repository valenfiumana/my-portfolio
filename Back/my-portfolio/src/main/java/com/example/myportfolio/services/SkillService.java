package com.example.myportfolio.services;

import com.example.myportfolio.entities.Skill;
import com.example.myportfolio.exceptions.ResourceNotFoundException;
import com.example.myportfolio.repositories.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {
    private ISkillRepository skillRepository;

    @Autowired
    public SkillService(ISkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }


    public Skill save(Skill skill) throws ResourceNotFoundException {
        if(skill.getNombre().isEmpty()||skill.getPorcentaje().equals(null)){
            throw new ResourceNotFoundException("Hay campos vacíos");
        }
        else{
            return skillRepository.save(skill);
        }
    }


    public Optional<Skill> findById(Long id) throws ResourceNotFoundException {
        Optional<Skill> skill = skillRepository.findById(id);
        if (skill.isPresent()) {
            return skill;
        } else {
            throw new ResourceNotFoundException("El skill con id: "+id+" NO fue encontrada");
        }
    }


    public List<Skill> listAll() {
        return skillRepository.findAll();
    }


    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Skill> skill = skillRepository.findById(id);
        if(skill.isPresent()){
            skillRepository.deleteById(id);
        }
        else{
            throw new ResourceNotFoundException("El skill con id "+id+" no existe y no pudo ser eliminado");
        }
    }

    public Skill update(Skill skill) throws ResourceNotFoundException {
        Optional<Skill> skillActualizar = skillRepository.findById(skill.getId());
        if(skillActualizar.isPresent()){
            return skillRepository.save(skill);
        }
        else{
            throw new ResourceNotFoundException("El skill con id "+skill.getId()+" no existe y no pudo ser actualizado");
        }
    }
}
