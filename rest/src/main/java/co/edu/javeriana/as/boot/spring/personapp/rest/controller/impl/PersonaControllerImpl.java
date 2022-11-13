/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.rest.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonaUseCase;
import co.edu.javeriana.as.boot.spring.personapp.rest.controller.PersonaController;
import co.edu.javeriana.as.boot.spring.personapp.rest.mapper.PersonaRestMapper;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.PersonaRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PersonaResponse;

@RestController
@RequestMapping("/persona")
public class PersonaControllerImpl implements PersonaController {

    @Value("${bandera.Db}")
    private int bandera;
    
    @Autowired
    private PersonaUseCase personaAppAdapter;

    @Autowired
    private PersonaRestMapper personaRestMapper;

  

    @Override
    @GetMapping
    public List<PersonaResponse> buscar() {
       List<Persona> personas = personaAppAdapter.findAll(0);
        return personaRestMapper.fromListPersonaToListPersonaResponse(personas);
    }

    @Override
    @PutMapping("/{cc}")
    public Boolean actualizar(@PathVariable("cc") Integer cc, @RequestBody PersonaRequest personaPostRequest) {
        Persona persona = personaRestMapper.fromPersonaRequestToPersona(personaPostRequest);
        Boolean salida = personaAppAdapter.editar(persona.getCc(), persona, bandera);
        return salida;
    }

    @Override
    @PostMapping
    public Boolean agregar(@RequestBody PersonaRequest personaPostRequest) {
        Persona persona = personaRestMapper.fromPersonaRequestToPersona(personaPostRequest);
        Boolean salida = personaAppAdapter.agregar(persona, bandera);
        return salida;
    }

    @Override
    @DeleteMapping("/{cc}")
    public Boolean eliminar(@PathVariable("cc") Integer cc) {
        Boolean salida = personaAppAdapter.eliminar(cc, bandera);
        return salida;
    }

    @Override
    @GetMapping("/{cc}")
    public PersonaResponse consultar(@PathVariable("cc") Integer Cc) {
        Persona persona = personaAppAdapter.consultar(Cc, bandera);
        PersonaResponse personaResponse = personaRestMapper.fromPersonaToPersonaResponse(persona);
        return personaResponse;
    }
    
}
