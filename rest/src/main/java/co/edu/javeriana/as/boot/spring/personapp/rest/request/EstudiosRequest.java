package co.edu.javeriana.as.boot.spring.personapp.rest.request;

import lombok.Data;

@Data
public class EstudiosRequest {
    private String fecha;
    private String univer;
    private ProfesionRequest profesion;
}
