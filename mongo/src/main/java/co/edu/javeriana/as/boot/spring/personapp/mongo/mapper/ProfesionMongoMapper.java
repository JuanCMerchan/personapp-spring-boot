package co.edu.javeriana.as.boot.spring.personapp.mongo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.ProfesionMongoEntity;

@Component
public class ProfesionMongoMapper {
    public ProfesionMongoEntity toProfesionEntityFromProfesion(Profesion profesion){
        ProfesionMongoEntity profesionEntity = new ProfesionMongoEntity();
        if(profesion.getId() != null) {
            profesionEntity.setId(profesion.getId());
        }
        profesionEntity.setNom(profesion.getNom());
        profesionEntity.setDes(profesion.getDes()); 
        return profesionEntity;
    }

    public Profesion toProfesionFromProfesionEntity(ProfesionMongoEntity profesionEntity) {
        Profesion profesion = new Profesion();
        profesion.setId(profesionEntity.getId());
        profesion.setNom(profesionEntity.getNom());
        profesion.setDes(profesionEntity.getDes());
        return profesion;
    }

    public List<Profesion> toListProfesionFromListProfesionEntity(List<ProfesionMongoEntity> profesionEntities) {
        List<Profesion> Profesions = new ArrayList<Profesion>();
        for ( ProfesionMongoEntity ProfesionEntity : profesionEntities){
            Profesions.add(toProfesionFromProfesionEntity(ProfesionEntity));
        }
        return Profesions;
    }
}
