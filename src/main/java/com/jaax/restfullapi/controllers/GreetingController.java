package com.jaax.restfullapi.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jaax.restfullapi.entity.Greeting;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();
    

    @GetMapping("/greeting")
    public Greeting helloWorld(@RequestParam(value="name", defaultValue = "world") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
     
}
