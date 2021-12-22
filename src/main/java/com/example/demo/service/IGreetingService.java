package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.UserData;

import com.example.demo.model.Greeting;

@Service
public interface IGreetingService {
	Greeting greetingMessage();

	String gettingMessageByName(UserData userData);

	Greeting findById(long Id);

	List<Greeting> getMessages();

	Greeting editMessage(Greeting greeting);

	Greeting deleteMessage(Long messId);

}