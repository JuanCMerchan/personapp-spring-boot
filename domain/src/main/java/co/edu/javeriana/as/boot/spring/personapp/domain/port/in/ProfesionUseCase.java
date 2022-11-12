package co.edu.javeriana.as.boot.spring.personapp.domain.port.in;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;

public interface ProfesionUseCase {

    Profesion consultar(Integer id , Integer bandera);

    boolean agregar(Profesion profesion, Integer bandera);

    boolean editar(Integer id, Profesion profesion, Integer bandera);

    boolean eliminar(Integer id, Integer bandera);

    Integer count( Integer bandera);
    
    List<Profesion> findAll( Integer bandera);
}
