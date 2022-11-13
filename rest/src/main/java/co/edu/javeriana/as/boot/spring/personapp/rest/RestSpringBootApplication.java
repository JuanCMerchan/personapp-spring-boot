package co.edu.javeriana.as.boot.spring.personapp.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = "co.edu.javeriana.as.boot.spring.personapp")
@EnableAutoConfiguration
@EnableJpaRepositories("co.edu.javeriana.as.boot.spring.personapp.maria.repository")
@EnableMongoRepositories("co.edu.javeriana.as.boot.spring.personapp.mongo.repository")
@EntityScan(basePackages = {"co.edu.javeriana.as.boot.spring.personapp.maria.entity", "co.edu.javeriana.as.boot.spring.personapp.mongo.entity"})
public class RestSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestSpringBootApplication.class, args);
    }
}
