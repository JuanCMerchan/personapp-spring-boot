package co.edu.javeriana.as.boot.spring.personapp.mongo.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.domain.port.out.mongo.ProfesionPortOutMongo;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.ProfesionMongoEntity;
import co.edu.javeriana.as.boot.spring.personapp.mongo.mapper.ProfesionMongoMapper;
import co.edu.javeriana.as.boot.spring.personapp.mongo.repository.ProfesionMongoRepository;

@Component
public class ProfesionMongoPersistenceAdapter implements ProfesionPortOutMongo {

    @Autowired
    private ProfesionMongoRepository profesionRepository;

    @Autowired
    private ProfesionMongoMapper profesionMapper;

    @Override
    public Profesion consultar(Integer id) {
        Optional<ProfesionMongoEntity> profesionEntityOptional = profesionRepository.findById(id);
        if(profesionEntityOptional.isPresent()) {
            return profesionMapper.toProfesionFromProfesionEntity(profesionEntityOptional.get());
        }
        return null;
    }

    @Override
    public boolean agregar(Profesion profesion) {
        if (profesion.getId() != null) {
            if(profesionRepository.findById(profesion.getId()).isPresent()) {
                return false;
            }
        } else {
            profesion.setId(generateId());
        }
        ProfesionMongoEntity profesionEntity = profesionMapper.toProfesionEntityFromProfesion(profesion);
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
        Optional<ProfesionMongoEntity> profesionEntityOptional = profesionRepository.findById(id);
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

    public Integer generateId() {
        List<ProfesionMongoEntity> profesionEntities = profesionRepository.findAll();
        Integer max = 0;
        for (ProfesionMongoEntity profesionMongoEntity : profesionEntities) {
            if (profesionMongoEntity.getId() > max) {
                max = profesionMongoEntity.getId();
            }
        }
        return max + 1;
    }
}
