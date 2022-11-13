/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.PersonaRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PersonaResponse;

@Component
public class PersonaRestMapper {

    @Autowired
    TelefonoRestMapper telefonoRestMapper;

    @Autowired
    EstudiosRestMapper estudiosRestMapper;

    public List<PersonaResponse> fromListPersonaToListPersonaResponse(List<Persona> personas) {
        List<PersonaResponse> personasResponses = new ArrayList<PersonaResponse>();
        for (Persona persona : personas) {

            personasResponses.add(fromPersonaToPersonaResponse(persona));
        }
        return personasResponses;
    }

    public Persona fromPersonaRequestToPersona(PersonaRequest personaRequest) {
        if (personaRequest == null) {
            return null;
        }
        Persona persona = new Persona();
        persona.setCc(personaRequest.getCc());
        persona.setNombre(personaRequest.getNombre());
        persona.setApellido(personaRequest.getApellido());
        persona.setEdad(personaRequest.getEdad());
        persona.setGenero(personaRequest.getGenero());
        persona.setEstudios(estudiosRestMapper.fromListEstudiosRequestToListEstudios(personaRequest.getEstudios()));
        persona.setTelefonos(telefonoRestMapper.fromListTelefonoRequestToListTelefono(personaRequest.getTelefonos()));
        return persona;
    }

    public PersonaResponse fromPersonaToPersonaResponse(Persona persona) {
        if (persona == null) {
            return null;
        }
        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setCc(persona.getCc());
        personaResponse.setNombre(persona.getNombre());
        personaResponse.setApellido(persona.getApellido());
        personaResponse.setEdad(persona.getEdad());
        personaResponse.setGenero(persona.getGenero());
        personaResponse.setEstudios(estudiosRestMapper.fromListEstudiosToListEstudiosResponse(persona.getEstudios()));
        personaResponse.setTelefonos(telefonoRestMapper.fromListTelefonoToListTelefonoResponse(persona.getTelefonos()));
        return personaResponse;
    }
}
