package com.sumanth.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.sumanth.projects.model.User;
import com.sumanth.projects.repository.RedisUserRepository;

@Service
public class RedisUserServiceImpl implements RedisUserService {
	
	private RedisUserRepository redisUserRepository;
	
	@Autowired
	public RedisUserServiceImpl(RedisUserRepository redisUserRepository) {
		this.redisUserRepository = redisUserRepository;
	}

	@Override
	public User getUserById(Integer id) {
		return redisUserRepository.getUser(id);
	}

	@Override
	public void addUser(User user) {
		redisUserRepository.addUser(user);
		return;
	}

	@Override
	public void deleteUserById(Integer id) {
		redisUserRepository.deleteUser(id);
		return;
	}
	
	
}
