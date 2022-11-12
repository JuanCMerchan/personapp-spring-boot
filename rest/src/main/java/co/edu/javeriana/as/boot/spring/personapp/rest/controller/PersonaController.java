/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import co.edu.javeriana.as.boot.spring.personapp.rest.request.PersonaRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.PersonaResponse;


public interface PersonaController  {

    @GetMapping
    public List<PersonaResponse> buscar();

    @PutMapping
    public Boolean agregar(PersonaRequest personaPostRequest);

    @PostMapping
    public Boolean actualizar(Integer cc, PersonaRequest personaPostRequest);

    @DeleteMapping
    public Boolean eliminar ( Integer Cc);

    @GetMapping
    public PersonaResponse consultar(Integer Cc);
    
}
