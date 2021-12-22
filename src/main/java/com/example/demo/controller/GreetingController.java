package com.example.demo.controller;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
     localhost:8080/greeting
     @return={id =1 , content="hello world!}
     
     localhost:8080/greeting?name=Yogendra
     * @return= { id=2, content="hello Yogendra
     */
    @GetMapping(value = {"/greeting", "/greeting/", "/greeting/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    /*
     localhost:8080/greeting/Yogendra
     
    @return={id =1 , content="hello Yogendra!}
     */
    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private IGreetingService greetingService;

    /*
       localhost:8080/greeting/service
       
       @return={id =1 , content="hello world!}
        */
    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();

    }
    
    @PostMapping("/greeting")
    public String greetingMessage(@RequestBody UserData userData) {
        return greetingService.greetingMessageByName(userData);
    }
    @GetMapping("/find")
    public Greeting findGreetById(@RequestParam long id) {
        return greetingService.getById(id);
    }

}