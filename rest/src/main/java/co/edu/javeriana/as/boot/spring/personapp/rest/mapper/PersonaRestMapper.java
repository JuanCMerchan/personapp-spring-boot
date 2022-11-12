/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.PersonaRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PersonaResponse;

@Component
public class PersonaRestMapper {

    public List<PersonaResponse> fromListPersonaToListPersonaResponse(List<Persona> personas) {
        List<PersonaResponse> personasResponses = new ArrayList<PersonaResponse>();
        for( Persona persona : personas){
            PersonaResponse personaPostResponse = new PersonaResponse();
            personaPostResponse.setCc(persona.getCc());
            personaPostResponse.setNombre(persona.getNombre());
            personaPostResponse.setApellido(persona.getApellido());
            personaPostResponse.setEdad(persona.getEdad());
            personaPostResponse.setGenero(persona.getGenero());
            personasResponses.add(personaPostResponse);
        }
        return personasResponses;
    }

    public Persona fromPersonaPostRequestToPersona(PersonaRequest personaRequest) {
        Persona persona = new Persona();
        persona.setCc(personaRequest.getCc());
        persona.setNombre(personaRequest.getNombre());
        persona.setApellido(personaRequest.getApellido());
        persona.setEdad(personaRequest.getEdad());
        persona.setGenero(personaRequest.getGenero());
        return persona;
    }

    public PersonaResponse fromPersonaToPersonaPostResponse(Persona persona) {
        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setCc(persona.getCc());
        personaResponse.setNombre(persona.getNombre());
        personaResponse.setApellido(persona.getApellido());
        personaResponse.setEdad(persona.getEdad());
        personaResponse.setGenero(persona.getGenero());
        return personaResponse;
    }


    
}
