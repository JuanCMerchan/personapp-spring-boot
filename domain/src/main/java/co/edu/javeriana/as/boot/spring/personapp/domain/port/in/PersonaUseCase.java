/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;


public interface PersonaUseCase {

    Persona consultar(Integer cc,Integer bandera);

    boolean agregar(Persona persona, Integer bandera);

    boolean editar(Integer cc, Persona persona, Integer bandera);

    boolean eliminar(Integer cc, Integer bandera);

    Integer count(Integer bandera);

    List<Persona> findAll( Integer bandera);
}
