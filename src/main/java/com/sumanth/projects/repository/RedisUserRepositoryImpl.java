package com.sumanth.projects.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.sumanth.projects.model.User;

@Component
public class RedisUserRepositoryImpl implements RedisUserRepository {
	
	private RedisTemplate<Integer, Object> redisTemplate;
	
	private JedisConnectionFactory jedisConnectionFactory;
	
	@Autowired
	public RedisUserRepositoryImpl(RedisTemplate redisTemplate, JedisConnectionFactory jedisConnectionFactory) {
		this.redisTemplate = redisTemplate;
		this.jedisConnectionFactory = jedisConnectionFactory;
	}

	@Override
	public void addUser(User user) {
		redisTemplate.opsForValue().set(user.getId(), user);
	}

	@Override
	public void deleteUser(Integer id) {
		redisTemplate.delete(id);
	}

	@Override
	public User getUser(Integer id) {
		return (User)redisTemplate.opsForValue().get(id);
	}

}
