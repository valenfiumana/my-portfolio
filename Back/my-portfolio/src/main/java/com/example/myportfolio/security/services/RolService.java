package com.example.myportfolio.security.services;

import com.example.myportfolio.security.entities.Rol;
import com.example.myportfolio.security.enums.RolNombre;
import com.example.myportfolio.security.repositories.IRolRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    IRolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
