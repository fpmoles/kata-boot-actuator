package com.frankmoley.kata;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController{

    private final PresidentRepository presidentRepository;
    Counter greetingCounter;
    Timer timer;

    public ApiController(PresidentRepository presidentRepository, MeterRegistry meterRegistry){
        this.presidentRepository = presidentRepository;
        greetingCounter = Counter.builder("api.greeting").register(meterRegistry);
    }

    @RequestMapping("greeting")
    public String getGreeting(){
        greetingCounter.increment();
        return "Hello World";
    }

    @RequestMapping("presidents")
    @Timed(value = "api.getAllPresidents")
    public List<President> getAllPresidents(){
        List<President> presidents = new ArrayList<>();
        this.presidentRepository.findAll().forEach(presidents::add);
        return presidents;
    }
}