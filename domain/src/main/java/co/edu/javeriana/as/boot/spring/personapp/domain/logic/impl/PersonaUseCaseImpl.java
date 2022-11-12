/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.PersonaUseCase;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.PersonaPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.PersonaPortOutMongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaUseCaseImpl implements PersonaUseCase {

    //private PersonaPortOutMongo personaPortOutMongo = null;

    @Autowired
    private PersonaPortOutMaria personaPortOutMaria;

    @Override
    public Persona consultar(Integer cc, Integer bandera) {
        switch (bandera) {
            case 0:
                //return personaPortOutMongo.consultar(cc);
                break;
            case 1:
                return personaPortOutMaria.consultar(cc);
            default:
                //Persona mongo = personaPortOutMongo.consultar(cc);
                //Persona maria = personaPortOutMaria.consultar(cc);
                //if(mongo.getCc() ==  maria.getCc()){
                    //return mongo;
                //}
            break;
        }
        return null;
    }

    @Override
    public boolean agregar(Persona persona, Integer bandera) {
        //0->mongo
        //1->maria
        switch (bandera) {
            case 0:
                //return personaPortOutMongo.agregar(persona);
            case 1:
                return personaPortOutMaria.agregar(persona);
        
            default:
            /*
                Boolean mongo = personaPortOutMongo.agregar(persona);
                Boolean maria = personaPortOutMaria.agregar(persona);
                if(mongo ==  maria && mongo){
                    return mongo;
                }else{
                    //aqui faltan cosas
                }
                */
            break;
        }
        return false;
    }

    @Override
    public boolean editar(Integer cc, Persona persona, Integer bandera) {
        switch (bandera) {
            case 0:
                //return personaPortOutMongo.editar(cc,persona);
            case 1:
                return personaPortOutMaria.editar(cc,persona);
        
            default:
            /*
                Boolean mongo = personaPortOutMongo.editar(cc,persona);
                Boolean maria = personaPortOutMaria.editar(cc,persona);
                if(maria && mongo){
                    return mongo;
                }
                */
            break;
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer cc, Integer bandera) {
        switch (bandera) {
            case 0:
                //return personaPortOutMongo.eliminar(cc);
            case 1:
                return personaPortOutMaria.eliminar(cc);
        
            default:
            /*
                Boolean mongo = personaPortOutMongo.eliminar(cc);
                Boolean maria = personaPortOutMaria.eliminar(cc);
                if(mongo ==  maria && mongo){
                    return mongo;
                }else{
                    //aqui faltan cosas
                }
                */
            break;
        }
        return false;
    }

    @Override
    public Integer count(Integer bandera) {
        switch (bandera) {
            case 0:
                //return personaPortOutMongo.count();
            case 1:
                return personaPortOutMaria.count();
        
            default:
            /*
                Integer mongo = personaPortOutMongo.count();
                Integer maria = personaPortOutMaria.count();
                if(mongo ==  maria){
                    return mongo;
                }
                */
            break;
        }
        return 0;
    }

    @Override
    public List<Persona> findAll(Integer bandera) {
        boolean prueba = false;
        switch (bandera) {
            case 0:
                //return personaPortOutMongo.findAll();
            case 1:
                return personaPortOutMaria.findAll();
        
            default:
                return personaPortOutMaria.findAll();
        }
    }
}
