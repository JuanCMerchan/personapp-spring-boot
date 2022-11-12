/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Persona;
import java.util.List;


public interface PersonaPortOut {
    Persona consultar(Integer cc);

    boolean agregar(Persona persona);

    boolean editar(Integer cc, Persona persona);

    boolean eliminar(Integer cc);

    Integer count();

    List<Persona> findAll();

}
