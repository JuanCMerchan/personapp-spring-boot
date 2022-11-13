package co.edu.javeriana.as.boot.spring.personapp.mongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.ProfesionMongoEntity;

@Repository
public interface ProfesionMongoRepository extends MongoRepository<ProfesionMongoEntity, Integer> {
    public Optional<ProfesionMongoEntity> findById(Integer cc);
}
