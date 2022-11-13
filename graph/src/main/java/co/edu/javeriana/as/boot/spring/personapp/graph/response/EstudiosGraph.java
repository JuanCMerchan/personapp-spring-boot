package co.edu.javeriana.as.boot.spring.personapp.graph.response;

import lombok.Data;

@Data
public class EstudiosGraph {
    private String fecha;
    private String univer;
    private ProfesionGraph profesion;
}
