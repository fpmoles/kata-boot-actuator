package com.frankmoley.kata;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
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



}
