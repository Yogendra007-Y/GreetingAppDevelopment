package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.UserData;
import com.example.demo.model.Greeting;
import com.example.demo.service.IGreetingService;


@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * Call Get method to return JSON
	 * @param name
	 * @return
	 */
	@GetMapping(value = {"","/","/home"})
	public Greeting greeting (@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting (counter.incrementAndGet(),String.format(template, name));
	}
	
	/**
	 * Call post method to post details through JSON
	 * @param name
	 * @return
	 */
	@PostMapping("/postDetails")
	public Greeting greetings(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting (counter.incrementAndGet(),String.format(template, name));
	}
	
	/**
	 * Call put method to update details of JSON file
	 * @param name
	 * @return
	 */
	@PutMapping("/update")
	public Greeting greet(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting (counter.incrementAndGet(),String.format(template, name));
	}
	
	/**
	 * Use service layer 
	 */
	@Autowired
	private IGreetingService greetingService;
	
	
	@GetMapping("/service")
	public Greeting greeting() {
	     return greetingService.greetingMessage();
	}
	
	@PostMapping("/greet")
	public String greetingMessageByName(@RequestBody UserData userData) {
		return greetingService.gettingMessageByName(userData);
	}
	
	@GetMapping("/service/{Id}")
	public Greeting findById(@PathVariable String Id) {
		return this.greetingService.findById(Long.parseLong(Id));
	}
	@GetMapping("/services")
	public List<Greeting>getMessages(){
		return this.greetingService.getMessages();
	}
	
}