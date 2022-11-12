package co.edu.javeriana.as.boot.spring.personapp.maria.adapter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.maria.ProfesionPortOutMaria;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.ProfesionEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.mapper.ProfesionMapper;
import co.edu.javeriana.as.boot.spring.personapp.maria.repository.ProfesionRepository;

@Component
public class ProfesionPersistenceAdapter implements ProfesionPortOutMaria {

    @Autowired
    private ProfesionRepository profesionRepository;

    @Autowired
    private ProfesionMapper profesionMapper;

    @Override
    public Profesion consultar(Integer id) {
        Optional<ProfesionEntity> profesionEntityOptional = profesionRepository.findById(id);
        if(profesionEntityOptional.isPresent()) {
            return profesionMapper.toProfesionFromProfesionEntity(profesionEntityOptional.get());
        }
        return null;
    }

    @Override
    public boolean agregar(Profesion profesion) {
        if(profesionRepository.findById(profesion.getId()).isPresent()) {
            return false;
        }
        ProfesionEntity profesionEntity = profesionMapper.toProfesionEntityFromProfesion(profesion);
        profesionRepository.save(profesionEntity);
        return true;
    }

    @Override
    public boolean editar(Integer id, Profesion profesion) {
        if(!profesionRepository.findById(id). isPresent()) {
            return false;
        }
        if(profesion.getId() != id) {
            eliminar(id);
        }
        profesionRepository.save(profesionMapper.toProfesionEntityFromProfesion(profesion));
        return true;
    }

    @Override
    public boolean eliminar(Integer id) {
        Optional<ProfesionEntity> profesionEntityOptional = profesionRepository.findById(id);
        if(profesionEntityOptional.isPresent()) {
            profesionRepository.delete(profesionEntityOptional.get());
            return true;
        }
        return false;
    }

    @Override
    public Integer count() {
        return profesionRepository.findAll().size();
    }

    @Override
    public List<Profesion> findAll() {
        return profesionMapper.toListProfesionFromListProfesionEntity(profesionRepository.findAll());
    }


}
