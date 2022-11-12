package co.edu.javeriana.as.boot.spring.personapp.maria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.javeriana.as.boot.spring.personapp.maria.entity.TelefonoEntity;

@Repository
public interface TelefonoRepository extends JpaRepository<TelefonoEntity, Integer>{
    
}
