package com.sumanth.projects.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

public class RediUserKeyExpirationListener extends KeyExpirationEventMessageListener {

	public RediUserKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
		super(listenerContainer);
	}
	
	@Override
	protected void doHandleMessage(Message message) {
		System.out.println(message.getBody());
	}

}
