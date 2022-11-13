package co.edu.javeriana.as.boot.spring.personapp.mongo.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("profesion")
public class ProfesionMongoEntity {
    @Id
    private Integer id;
    private String nom;
    private String des;
}
