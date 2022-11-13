package co.edu.javeriana.as.boot.spring.personapp.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("telefono")
public class TelefonoMongoEntity {
    @Id
    private String num;
    private String oper;
}
