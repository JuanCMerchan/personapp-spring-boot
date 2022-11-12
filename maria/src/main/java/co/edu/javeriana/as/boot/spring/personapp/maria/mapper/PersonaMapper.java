/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonaEntity;

/**
 *
 * @author aasanchez
 */
@Component
public class PersonaMapper {

    @Autowired
    TelefonoMapper telefonoMapper;

    @Autowired
    EstudiosMapper estudiosMapper;

    public PersonaEntity toPersonaEntityFromPersona(Persona persona){
        PersonaEntity personaEntity = new PersonaEntity();
        personaEntity.setCc(persona.getCc());
        personaEntity.setNombre(persona.getNombre());
        personaEntity.setApellido(persona.getApellido());
        personaEntity.setGenero(persona.getGenero());
        personaEntity.setEdad(persona.getEdad());
        personaEntity.setTelefonos(telefonoMapper.toListTelefonoEntityFromListTelefono(persona.getTelefonos(), personaEntity));
        personaEntity.setEstudios(estudiosMapper.toListEstudiosEntityFromListEstudios(persona.getEstudios(), personaEntity));
        return personaEntity;
    }

    public Persona toPersonaFromPersonaEntity(PersonaEntity personaEntity) {
        Persona persona = new Persona();
        persona.setCc(personaEntity.getCc());
        persona.setApellido(personaEntity.getApellido());
        persona.setNombre(personaEntity.getNombre());
        persona.setGenero(personaEntity.getGenero());
        persona.setEdad(personaEntity.getEdad());
        persona.setTelefonos(telefonoMapper.toListTelefonoFromListTelefonoEntity(personaEntity.getTelefonos()));
        persona.setEstudios(estudiosMapper.toListEstudiosFromListEstudiosEntity(personaEntity.getEstudios()));

        return persona;
    }

    public List<Persona> toListPersonaFromListPersonaEntity(List<PersonaEntity> personaEntities) {
        List<Persona> personas = new ArrayList<Persona>();
        for ( PersonaEntity personaEntity : personaEntities){
            personas.add(toPersonaFromPersonaEntity(personaEntity));
        }
        return personas;
    }
}
