package com.sumanth.projects.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.projects.model.User;
import com.sumanth.projects.service.RedisUserService;

@RestController
@RequestMapping("/redis")
public class RedisUserController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(RedisUserController.class);
	
	private RedisUserService redisUserService;

	@Autowired
	public void setRedisUserService(RedisUserService redisUserService) {
		this.redisUserService = redisUserService;
	}

	@RequestMapping("/get/{id}")
	public User getUser(@PathVariable("id") String id) {
		return redisUserService.getUserById(Integer.parseInt(id));
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addUser(@RequestBody User user) {
		redisUserService.addUser(user);
	}
	
	@RequestMapping("/delete/{id}") 
	public void deleteUserById(@PathVariable("id") Integer id) {
		redisUserService.deleteUserById(id);
	}

}
