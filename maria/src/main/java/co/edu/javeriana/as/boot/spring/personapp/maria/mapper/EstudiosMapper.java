package co.edu.javeriana.as.boot.spring.personapp.maria.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Estudios;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.EstudiosEntity;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.EstudiosPK;
import co.edu.javeriana.as.boot.spring.personapp.maria.entity.PersonaEntity;


@Component
public class EstudiosMapper {

    @Autowired
    ProfesionMapper profesionMapper;

    public Estudios toEstudiosFromEstudiosEntity(EstudiosEntity estudiosEntity){
        Estudios estudios = new Estudios();
        estudios.setFecha(estudiosEntity.getFecha());
        estudios.setUniver(estudiosEntity.getUniver());
        estudios.setProfesion(profesionMapper.toProfesionFromProfesionEntity(estudiosEntity.getProfesion()));
        return estudios;
    }
    
    public EstudiosEntity toEstudiosEntityFromEstudios(Estudios estudios, PersonaEntity personaEntity) {
        EstudiosPK estudiosPK = new EstudiosPK();
        estudiosPK.setCcPer(personaEntity.getCc());
        estudiosPK.setIdProf(estudios.getProfesion().getId());
        EstudiosEntity estudiosEntity = new EstudiosEntity();
        estudiosEntity.setEstudiosPK(estudiosPK);
        estudiosEntity.setFecha(estudios.getFecha());
        estudiosEntity.setUniver(estudios.getUniver());
        estudiosEntity.setProfesion(profesionMapper.toProfesionEntityFromProfesion(estudios.getProfesion()));
        estudiosEntity.getProfesion();
        estudiosEntity.setPersona(personaEntity);
        return estudiosEntity;
    }

    public List<Estudios> toListEstudiosFromListEstudiosEntity(List<EstudiosEntity> estudiosEntities) {
        List<Estudios> estudios = new ArrayList<>();
        for (EstudiosEntity estudiosEntity : estudiosEntities) {
            estudios.add(toEstudiosFromEstudiosEntity(estudiosEntity));
        }
        return estudios;
    }

    public List<EstudiosEntity> toListEstudiosEntityFromListEstudios(List<Estudios> estudioss, PersonaEntity personaEntity) {
        List<EstudiosEntity> estudiosEntities = new ArrayList<>();
        for(Estudios estudios : estudioss) {
            estudiosEntities.add(toEstudiosEntityFromEstudios(estudios, personaEntity));
        }
        return estudiosEntities;
    }
}
