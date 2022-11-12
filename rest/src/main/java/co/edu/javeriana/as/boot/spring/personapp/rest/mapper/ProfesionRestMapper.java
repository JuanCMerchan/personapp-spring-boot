package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Profesion;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.ProfesionRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.ProfesionResponse;

@Component
public class ProfesionRestMapper {

    public List<ProfesionResponse> fromListProfesionesToListProfesionesPostResponse(List<Profesion> profesiones) {
        List<ProfesionResponse> personaResponses = new ArrayList<ProfesionResponse>();
        for( Profesion profesion : profesiones){
            ProfesionResponse profesionPostResponse = new ProfesionResponse();
            profesionPostResponse.setId(profesion.getId());
            profesionPostResponse.setNom(profesion.getNom());
            profesionPostResponse.setDes(profesion.getDes());
            personaResponses.add(profesionPostResponse);
        }
        return personaResponses;
    }

    public Profesion fromProfesionPostRequestToProfesion(ProfesionRequest profesionRequest) {
        Profesion profesion = new Profesion();
        profesion.setId(profesionRequest.getId());
        profesion.setNom(profesionRequest.getNom());
        profesion.setDes(profesionRequest.getDes());
        return profesion;
    }

    public ProfesionResponse fromProfesionToProfesionPostResponse(Profesion pe) {
        ProfesionResponse profesionResponse = new ProfesionResponse();
        profesionResponse.setId(profesionResponse.getId());
        profesionResponse.setNom(profesionResponse.getNom());
        profesionResponse.setDes(profesionResponse.getDes());
        return profesionResponse;
    }
    
}
