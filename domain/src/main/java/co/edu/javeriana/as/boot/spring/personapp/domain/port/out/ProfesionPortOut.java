package co.edu.javeriana.as.boot.spring.personapp.domain.port.out;

import java.util.List;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;

public interface ProfesionPortOut {
    Profesion consultar(Integer id);

    boolean agregar(Profesion profesion);

    boolean editar(Integer id, Profesion profesion);

    boolean eliminar(Integer id);

    Integer count();

    List<Profesion> findAll();
}
