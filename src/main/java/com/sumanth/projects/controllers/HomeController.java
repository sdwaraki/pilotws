package com.sumanth.projects.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.projects.model.User;

@RestController
@RequestMapping("/")
public class HomeController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/greeting")
	public String getGreeting() {
		LOGGER.info("Inside the greeting method");
		return "This is your new greeting";
	}
	
	@RequestMapping("/json/trial")
	public User getUser() {
		User user = new User();
		user.setAge(25);
		user.setTitle("Software Dev");
		user.setUserName("Sumanth");
		return user;
	}
}
