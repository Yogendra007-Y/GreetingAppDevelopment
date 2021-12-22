package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;
import com.example.demo.model.User;
@Service
public interface IGreetingService {
	 Greeting greetingMessage();
	    
		String greetingMessageByName(UserData userData);
		public Greeting getById(long id);

}