package co.edu.javeriana.as.boot.spring.personapp.domain.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Estudios {
    private LocalDate fecha;
    private String univer;
    private Profesion profesion;
}
