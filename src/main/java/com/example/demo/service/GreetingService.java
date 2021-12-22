package com.example.demo.service;

import java.util.Optional;

import java.util.concurrent.atomic.AtomicLong;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.model.repository.IGreetingRepository;


@Service
public class GreetingService implements IGreetingService {
	 private static final String template = "Hello world";
	    private final AtomicLong counter = new AtomicLong();

	    @Autowired
	    private IGreetingRepository greetingService;
	    
	    @Override 
	 public Greeting greetingMessage() {
	        return new Greeting(counter.incrementAndGet(), String.format(template));
	    }
	    
	 public String greetingMessageByName(UserData userData) {
	        User user = new User();
	        ModelMapper modelMapper = new ModelMapper();
	        modelMapper.map(userData, user);
	        return ("Hello " + user.getFirstName() + " " + user.getLastName());
	    }
	    @Override
	    public Greeting getById(long id) {
	        return greetingService.findById(id).get();
}
}