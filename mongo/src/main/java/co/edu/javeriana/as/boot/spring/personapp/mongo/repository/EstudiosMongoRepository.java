package co.edu.javeriana.as.boot.spring.personapp.mongo.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.as.boot.spring.personapp.mongo.entity.EstudiosMongoEntity;

@Repository
public interface EstudiosMongoRepository extends MongoRepository<EstudiosMongoEntity, Integer> {
    
}