/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.graph.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.graph.response.PersonaGraph;

@Component
public class PersonaGraphMapper {

    @Autowired
    TelefonoGraphMapper telefonoGraphMapper;

    @Autowired
    EstudiosGraphMapper estudiosGraphMapper;

    public List<PersonaGraph> fromListPersonaToListPersonaGraph(List<Persona> personas) {
        List<PersonaGraph> PersonaGraphs = new ArrayList<PersonaGraph>();
        for (Persona persona : personas) {

            PersonaGraphs.add(fromPersonaToPersonaGraph(persona));
        }
        return PersonaGraphs;
    }

    public Persona fromPersonaGraphToPersona(PersonaGraph personaGraph) {
        if (personaGraph == null) {
            return null;
        }
        Persona persona = new Persona();
        persona.setCc(personaGraph.getCc());
        persona.setNombre(personaGraph.getNombre());
        persona.setApellido(personaGraph.getApellido());
        persona.setEdad(personaGraph.getEdad());
        persona.setGenero(personaGraph.getGenero());
        if (personaGraph.getEstudios() == null) {
            persona.setEstudios(new ArrayList<>());
        } else {
            persona.setEstudios(estudiosGraphMapper.fromListEstudiosGraphToListEstudios(personaGraph.getEstudios()));
        }
        if (personaGraph.getTelefonos() == null) {
            persona.setTelefonos(new ArrayList<>());
        } else {
            persona.setTelefonos(telefonoGraphMapper.fromListTelefonoGraphToListTelefono(personaGraph.getTelefonos()));
        }
        return persona;
    }

    public PersonaGraph fromPersonaToPersonaGraph(Persona persona) {
        if (persona == null) {
            return null;
        }
        PersonaGraph personaGraph = new PersonaGraph();
        personaGraph.setCc(persona.getCc());
        personaGraph.setNombre(persona.getNombre());
        personaGraph.setApellido(persona.getApellido());
        personaGraph.setEdad(persona.getEdad());
        personaGraph.setGenero(persona.getGenero());
        personaGraph.setEstudios(estudiosGraphMapper.fromListEstudiosToListEstudiosGraph(persona.getEstudios()));
        personaGraph.setTelefonos(telefonoGraphMapper.fromListTelefonoToListTelefonoGraph(persona.getTelefonos()));
        return personaGraph;
    }
}
