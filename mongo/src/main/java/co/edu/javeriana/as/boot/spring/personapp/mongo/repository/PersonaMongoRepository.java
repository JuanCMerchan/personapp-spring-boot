package co.edu.javeriana.as.boot.spring.personapp.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.PersonaMongoEntity;

@Repository
public interface PersonaMongoRepository extends MongoRepository<PersonaMongoEntity, Integer> {
}
