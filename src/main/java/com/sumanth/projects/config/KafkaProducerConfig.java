package com.sumanth.projects.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.sumanth.projects.model.User;

@Configuration
public class KafkaProducerConfig {
	
	@Value(value = "${kafka.server.address}")
	private String bootstrapAddress;

	@Bean
	public ProducerFactory<Integer, User> producerFactory() {
		Map<String, Object> configProperties = new HashMap<String, Object>();
		configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProperties);
	}
	
	@Bean
	public KafkaTemplate<Integer,User> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
}
