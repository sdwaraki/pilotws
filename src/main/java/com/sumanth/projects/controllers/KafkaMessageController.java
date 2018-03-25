package com.sumanth.projects.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sumanth.projects.model.User;
import com.sumanth.projects.service.KafkaMessageProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaMessageController {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageController.class);
	
	@Autowired
	private KafkaMessageProducerService kafkaMessageProducerService;
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public void sendMessage(@RequestBody User user) {
		LOGGER.info("Inside the send kafka message controller");
		kafkaMessageProducerService.send(user);
	}
}
