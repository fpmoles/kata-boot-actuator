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

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KataBootActuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(KataBootActuatorApplication.class, args);
    }


    @RestController
    @RequestMapping("api")
    public class ApiController{

        private final UserRepository userRepository;

        public ApiController(UserRepository userRepository){
            this.userRepository = userRepository;
        }

        @RequestMapping("greeting")
        public String getGreeting(){
            return "Hello World";
        }

        @RequestMapping("users")
        public List<User> getAllUsers(){
            List<User> users = new ArrayList<>();
            this.userRepository.findAll().forEach(user -> users.add(user));
            return users;
        }
    }

    @Data
    @Entity
    @Table(name="USER")
    public class User{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name="USER_ID")
        private long id;
        @Column(name="FIRST_NAME")
        private String firstName;
        @Column(name="LAST_NAME")
        private String lastName;
        @Column(name="EMAIL_ADDRESS")
        private String emailAddress;
    }

    @Repository
    public interface UserRepository extends CrudRepository<User, Long>{

    }


}
