package com.example.demo.service;

import java.util.List;
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
	private IGreetingRepository greetingRepository;

	/**
	 * Call method to save the message in the repository
	 */
	@Override
	public Greeting greetingMessage() {
		return greetingRepository.save(new Greeting(counter.incrementAndGet(), String.format(template)));
	}

	@Override
	public String gettingMessageByName(UserData userData) {
		User user = new User();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userData, user);
		return ("Hello" + " " + user.getFirstName() + " " + user.getLastName() + "...");
	}

	/**
	 * Call method to find the message by message Id
	 */
	@Override
	public Greeting findById(long messId) {
		return greetingRepository.findById(messId).get();
	}

	/**
	 * Call method to list all the messages
	 */
	@Override
	public List<Greeting> getMessages() {
		return greetingRepository.findAll();
	}

	/**
	 * Call method to edit message
	 */
	@Override
	public Greeting editMessage(Greeting greeting) {
		return greetingRepository.save(new Greeting(2, "Hello Yogendr..."));
	}

	@Override
	public Greeting deleteMessage(Long messId) {
		Optional<Greeting> isPresent = greetingRepository.findById(messId);
		if (isPresent.isPresent()) {
			greetingRepository.delete(isPresent.get());
			return isPresent.get();
		} else
			return null;

	}
}