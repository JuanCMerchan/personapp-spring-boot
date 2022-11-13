package co.edu.javeriana.as.boot.spring.personapp.mongo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("estudios")
public class EstudiosMongoEntity {
    @Id
    private String id;
    private LocalDate fecha;
    private String univer;
    @DBRef
    private ProfesionMongoEntity profesion;
}
