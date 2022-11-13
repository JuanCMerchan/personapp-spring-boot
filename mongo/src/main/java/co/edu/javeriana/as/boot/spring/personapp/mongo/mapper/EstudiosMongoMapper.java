package co.edu.javeriana.as.boot.spring.personapp.mongo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Estudios;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.EstudiosMongoEntity;
import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.PersonaMongoEntity;

@Component
public class EstudiosMongoMapper {
    @Autowired
    ProfesionMongoMapper profesionMapper;

    public Estudios toEstudiosFromEstudiosEntity(EstudiosMongoEntity estudiosEntity){
        Estudios estudios = new Estudios();
        estudios.setFecha(estudiosEntity.getFecha());
        estudios.setUniver(estudiosEntity.getUniver());
        estudios.setProfesion(profesionMapper.toProfesionFromProfesionEntity(estudiosEntity.getProfesion()));
        return estudios;
    }
    
    public EstudiosMongoEntity toEstudiosEntityFromEstudios(Estudios estudios, PersonaMongoEntity personaEntity) {
        EstudiosMongoEntity estudiosEntity = new EstudiosMongoEntity();
        estudiosEntity.setFecha(estudios.getFecha());
        estudiosEntity.setUniver(estudios.getUniver());
        estudiosEntity.setProfesion(profesionMapper.toProfesionEntityFromProfesion(estudios.getProfesion()));
        estudiosEntity.getProfesion();
        return estudiosEntity;
    }

    public List<Estudios> toListEstudiosFromListEstudiosEntity(List<EstudiosMongoEntity> estudiosEntities) {
        List<Estudios> estudios = new ArrayList<>();
        for (EstudiosMongoEntity estudiosEntity : estudiosEntities) {
            estudios.add(toEstudiosFromEstudiosEntity(estudiosEntity));
        }
        return estudios;
    }

    public List<EstudiosMongoEntity> toListEstudiosEntityFromListEstudios(List<Estudios> estudioss, PersonaMongoEntity personaEntity) {
        List<EstudiosMongoEntity> estudiosEntities = new ArrayList<>();
        for(Estudios estudios : estudioss) {
            estudiosEntities.add(toEstudiosEntityFromEstudios(estudios, personaEntity));
        }
        return estudiosEntities;
    }
}
