package com.example.demo.service;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;

public interface IGreetingService {
	 Greeting greetingMessage();
	    
		String greetingMessageByName(UserData userData);

}