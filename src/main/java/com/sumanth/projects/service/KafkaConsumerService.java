package com.sumanth.projects.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.sumanth.projects.model.User;

@Service
public class KafkaConsumerService {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);


	@KafkaListener(topics="${kafka.topic.name}")
	public void listen(User user) {
		LOGGER.info(user.toString());
	}

}
