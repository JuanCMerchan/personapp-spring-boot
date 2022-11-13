/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.adapter;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.PersonaPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonaEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.mapper.PersonaMapper;
import co.edu.javeriana.as.boot.spring.personapp.maria.repository.PersonaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonaPersistenceAdapter implements PersonaPortOutMaria{

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;

    @Override
    public Persona consultar(Integer cc) {
        Optional<PersonaEntity> personaEntityOptional = personaRepository.findById(cc);
        if(personaEntityOptional.isPresent()) {
            return personaMapper.toPersonaFromPersonaEntity(personaEntityOptional.get());
        }
        return null;
    }

    @Override
    public boolean agregar(Persona persona) {
        if(personaRepository.findById(persona.getCc()).isPresent()) {
            return false;
        }
        if (persona.getEstudios() == null) {
            persona.setEstudios(new ArrayList<>());
        }
        if(persona.getTelefonos() == null) {
            persona.setEstudios(new ArrayList<>());
        }
        PersonaEntity personaEntity  = personaMapper.toPersonaEntityFromPersona(persona);
        personaRepository.save(personaEntity);
        return true;
        
    }

    @Override
    public boolean editar(Integer cc, Persona persona) {
        if(!personaRepository.findById(cc).isPresent()) {
            return false;
        }
        if(persona.getCc() != cc) {
            eliminar(cc);
        }
        personaRepository.save(personaMapper.toPersonaEntityFromPersona(persona));
        return true;
    }

    @Override
    public boolean eliminar(Integer cc) {
        Optional<PersonaEntity> personaEntityOptional = personaRepository.findById(cc);
        if(personaEntityOptional.isPresent()) {
            personaRepository.delete(personaEntityOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Integer count() {
        return personaRepository.findAll().size();
    }

    @Override
    public List<Persona> findAll() {
        return personaMapper.toListPersonaFromListPersonaEntity(personaRepository.findAll());
    }

  
    
}
