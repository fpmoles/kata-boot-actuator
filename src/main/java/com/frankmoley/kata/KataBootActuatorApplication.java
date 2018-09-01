package com.frankmoley.kata;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class KataBootActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataBootActuatorApplication.class, args);
    }


    @RestController
    @RequestMapping("api")
    public class ApiController{

        @RequestMapping("greeting")
        public String getGreeting(){
            return "Hello World";
        }
    }

    @Data
    @Entity
    public class User{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String firstName;
        private String lastName;
        private String emailAddress;
    }

    @Repository
    public interface UserRepository extends CrudRepository<User, Long>{

    }


}
