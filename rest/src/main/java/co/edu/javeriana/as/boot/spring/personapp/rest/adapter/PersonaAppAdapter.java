/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.rest.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonaUseCase;


public class PersonaAppAdapter{

    private PersonaUseCase personaUseCase;

    public Persona consultar(Integer cc, Integer bandera) {
        return personaUseCase.consultar(cc, bandera);
    }

    public boolean agregar(Persona persona, Integer bandera) {
        return personaUseCase.agregar(persona, bandera);
    }

    public boolean editar(Integer cc, Persona persona, Integer bandera) {
        return personaUseCase.editar(cc, persona, bandera);
    }

    public boolean eliminar(Integer cc, Integer bandera) {
        return personaUseCase.eliminar(cc, bandera);
    }

    public Integer count(Integer bandera) {
        return personaUseCase.count(bandera);
    }

    public List<Persona> findAll(Integer bandera) {
        return personaUseCase.findAll(bandera);
    }
   
}
