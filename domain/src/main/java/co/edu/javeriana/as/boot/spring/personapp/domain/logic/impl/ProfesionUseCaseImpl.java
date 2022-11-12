package co.edu.javeriana.as.boot.spring.personapp.domain.logic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.in.ProfesionUseCase;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.ProfesionPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.ProfesionPortOutMongo;

@Service
public class ProfesionUseCaseImpl implements ProfesionUseCase {

    //@Autowired
    //private ProfesionPortOutMongo profesionPortOutMongo;

    @Autowired
    private ProfesionPortOutMaria profesionPortOutMaria;

    @Override
    public Profesion consultar(Integer id, Integer bandera) {
        switch (bandera) {
            case 0:
                //return profesionPortOutMongo.consultar(id);
            case 1:
                return profesionPortOutMaria.consultar(id);
            default:
                Profesion mongo = profesionPortOutMaria.consultar(id);
                return mongo;  
        }
    }

    @Override
    public boolean agregar(Profesion profesion, Integer bandera) {
        switch (bandera) {
            case 0:
                //return profesionPortOutMongo.agregar(profesion);
            case 1:
                return profesionPortOutMaria.agregar(profesion);
            default:
            /*
                Boolean mongo = profesionPortOutMongo.agregar(profesion);
                Boolean maria = profesionPortOutMaria.agregar(profesion);
                if(mongo && maria) {
                    return true;
                } else {

                }
                */
                break;
        }
        return false;
    }

    @Override
    public boolean editar(Integer id, Profesion profesion, Integer bandera) {
        switch (bandera) {
            case 0:
                //return profesionPortOutMongo.editar(id, profesion);
            case 1:
                return profesionPortOutMaria.editar(id, profesion);
            default:
            /*
                Boolean mongo = profesionPortOutMongo.editar(id, profesion);
                Boolean maria = profesionPortOutMaria.editar(id, profesion);
                if(mongo && maria) {
                    return true;
                } else {

                }
                */
                break;
        }
        return false;
    }

    @Override
    public boolean eliminar(Integer id, Integer bandera) {
        switch (bandera) {
            case 0:
                //return profesionPortOutMongo.eliminar(id);
            case 1:
                return profesionPortOutMaria.eliminar(id);
            default:
            /*
                Boolean mongo = profesionPortOutMongo.eliminar(id);
                Boolean maria = profesionPortOutMaria.eliminar(id);
                if(mongo && maria) {
                    return true;
                } else {

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
                //return profesionPortOutMongo.count();
            case 1:
                return profesionPortOutMaria.count();
            default:
            /*
                Integer mongo = profesionPortOutMongo.count();
                Integer maria = profesionPortOutMaria.count();
                if(mongo == maria) {
                    return mongo;
                } else {
                    
                }
                */
                break;
        }
        return 0;
    }

    @Override
    public List<Profesion> findAll(Integer bandera) {
        switch (bandera) {
            case 0:
                //return profesionPortOutMongo.findAll();
            case 1:
                return profesionPortOutMaria.findAll();
            default:
                return profesionPortOutMaria.findAll();
        } 
    }
}
