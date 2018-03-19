package com.sumanth.projects.service;

import org.springframework.context.annotation.Bean;

import com.sumanth.projects.model.User;

public interface RedisUserService {
	
	public User getUserById(Integer id);
	
	public void addUser(User user);
	
	public void deleteUserById(Integer id);
	

}
