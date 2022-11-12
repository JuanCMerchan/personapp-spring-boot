package co.edu.javeriana.as.boot.spring.personapp.rest.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import co.edu.javeriana.as.boot.spring.personapp.rest.request.ProfesionRequest;
import co.edu.javeriana.as.boot.spring.personapp.rest.response.ProfesionResponse;

public interface ProfesionController {

    @GetMapping
    public List<ProfesionResponse> buscar();

    @PutMapping
    public Boolean agregar(ProfesionRequest profesionPostRequest);

    @PostMapping
    public Boolean actualizar(Integer id, ProfesionRequest ProfesionPostRequest);

    @DeleteMapping
    public Boolean eliminar ( Integer Cc);

    @GetMapping
    public ProfesionResponse consultar(Integer Cc);
    
}
