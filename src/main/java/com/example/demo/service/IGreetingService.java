package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;
@Service
public interface IGreetingService {
	 Greeting greetingMessage();
	    
		String greetingMessageByName(UserData userData);

}