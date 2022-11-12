package co.edu.javeriana.as.boot.spring.personapp.rest.adapter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.ProfesionUseCase;

public class ProfesionAppAdapter {

    private ProfesionUseCase profesionUseCase;

    public Profesion consultar(Integer id, Integer bandera) {
        
        return profesionUseCase.consultar(id, bandera);
    }

    public boolean agregar(Profesion profesion, Integer bandera) {
        
        return profesionUseCase.agregar(profesion, bandera);
    }

    public boolean editar(Integer id, Profesion profesion, Integer bandera) {
        return profesionUseCase.editar(id, profesion, bandera);
    }

    public boolean eliminar(Integer id, Integer bandera) {
     
        return profesionUseCase.eliminar(id, bandera);
    }

    public Integer count(Integer bandera) {
        return profesionUseCase.count(bandera);
    }

    public List<Profesion> findAll(Integer bandera) {
        return profesionUseCase.findAll(bandera);
    }
    
}
