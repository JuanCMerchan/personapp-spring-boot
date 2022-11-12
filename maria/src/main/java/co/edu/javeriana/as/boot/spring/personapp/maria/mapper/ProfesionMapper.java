package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.ProfesionEntity;

@Component
public class ProfesionMapper {

    public ProfesionEntity toProfesionEntityFromProfesion(Profesion profesion){
        ProfesionEntity profesionEntity = new ProfesionEntity();
        profesionEntity.setId(profesion.getId());
        profesionEntity.setNom(profesion.getNom());
        profesionEntity.setDes(profesion.getDes()); 
        return profesionEntity;
    }

    public Profesion toProfesionFromProfesionEntity(ProfesionEntity profesionEntity) {
        Profesion profesion = new Profesion();
        profesion.setId(profesionEntity.getId());
        profesion.setNom(profesionEntity.getNom());
        profesion.setDes(profesionEntity.getDes());
        return profesion;
    }

    public List<Profesion> toListProfesionFromListProfesionEntity(List<ProfesionEntity> profesionEntities) {
        List<Profesion> Profesions = new ArrayList<Profesion>();
        for ( ProfesionEntity ProfesionEntity : profesionEntities){
            Profesions.add(toProfesionFromProfesionEntity(ProfesionEntity));
        }
        return Profesions;
    }
}
