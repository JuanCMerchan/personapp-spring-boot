package co.edu.javeriana.as.boot.spring.personapp.rest.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.javeriana.as.boot.spring.personapp.domain.model.Estudios;
import co.edu.javeriana.as.boot.spring.personapp.rest.request.EstudiosRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.EstudiosResponse;

@Component
public class EstudiosRestMapper {

    @Autowired
    ProfesionRestMapper profesionRestMapper;

    public Estudios fromEstudiosRequestToEstudios(EstudiosRequest estudiosRequest) {
        if (estudiosRequest == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Estudios estudios = new Estudios();
        estudios.setFecha(LocalDate.parse(estudiosRequest.getFecha(), formatter));
        estudios.setUniver(estudiosRequest.getUniver());
        estudios.setProfesion(profesionRestMapper.fromProfesionRequestToProfesion(estudiosRequest.getProfesion()));
        return estudios;
    }

    public EstudiosResponse fromEstudiosToEstudiosResponse(Estudios estudios) {
        if (estudios == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        EstudiosResponse estudiosResponse = new EstudiosResponse();
        estudiosResponse.setFecha(estudios.getFecha().format(formatter));
        estudiosResponse.setUniver(estudios.getUniver());
        estudiosResponse.setProfesion(profesionRestMapper.fromProfesionToProfesionResponse(estudios.getProfesion()));
        return estudiosResponse;
    }

    public List<Estudios> fromListEstudiosRequestToListEstudios(List<EstudiosRequest> estudiosRequests) {
        List<Estudios> estudios = new ArrayList<>();
        for (EstudiosRequest estudiosRequest : estudiosRequests) {
            estudios.add(fromEstudiosRequestToEstudios(estudiosRequest));
        }
        return estudios;
    }

    public List<EstudiosResponse> fromListEstudiosToListEstudiosResponse(List<Estudios> estudioss) {
        List<EstudiosResponse> estudiosResponses = new ArrayList<>();
        for (Estudios estudios : estudioss) {
            estudiosResponses.add(fromEstudiosToEstudiosResponse(estudios));
        }
        return estudiosResponses;
    }
}
