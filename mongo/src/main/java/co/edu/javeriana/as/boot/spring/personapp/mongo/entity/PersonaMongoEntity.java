package co.edu.javeriana.as.boot.spring.personapp.mongo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("persona")
public class PersonaMongoEntity {
    @Id
    private Integer cc;
    private String nombre;
    private String apellido;
    private String genero;
    private Integer edad;
    @DBRef
    private List<TelefonoMongoEntity> telefonos;
    @DBRef
    private List<EstudiosMongoEntity> estudios;
}
