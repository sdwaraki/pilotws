package com.sumanth.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sumanth.projects.model.User;

@Service
public class KafkaMessageProducerService {
	
	@Value(value="${kafka.topic.name}")
	private String topicName;
	
	@Autowired
	private KafkaTemplate<Integer, User> kafkaTemplate;
	
	public void send(User user) {
		kafkaTemplate.send(topicName, user);
	}
}
