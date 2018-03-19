package com.sumanth.projects.repository;

import com.sumanth.projects.model.User;

public interface RedisUserRepository {
	
	public void addUser(User user);
	
	public void deleteUser(Integer id);
	
	public User getUser(Integer id);

}
