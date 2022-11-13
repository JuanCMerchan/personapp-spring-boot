package co.edu.javeriana.as.boot.spring.personapp.mongo.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.PersonaPortOutMongo;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.PersonaMongoEntity;
import co.edu.javeriana.as.boot.spring.personapp.mongo.mapper.PersonaMongoMapper;
import co.edu.javeriana.as.boot.spring.personapp.mongo.repository.PersonaMongoRepository;

@Component
public class PersonaMongoPersistenceAdapter implements PersonaPortOutMongo {
    
    @Autowired
    private PersonaMongoRepository personaRepository;

    @Autowired
    private PersonaMongoMapper personaMapper;

    @Override
    public Persona consultar(Integer cc) {
        Optional<PersonaMongoEntity> personaEntityOptional = personaRepository.findById(cc);
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
        PersonaMongoEntity personaEntity  = personaMapper.toPersonaEntityFromPersona(persona);
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
        Optional<PersonaMongoEntity> personaEntityOptional = personaRepository.findById(cc);
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
