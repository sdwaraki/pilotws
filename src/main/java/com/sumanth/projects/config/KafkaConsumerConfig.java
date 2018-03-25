package com.sumanth.projects.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.sumanth.projects.model.User;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
	
	@Value(value="${kafka.server.address}")
	private String kafkaServerAddress; 
	
	@SuppressWarnings("unchecked")
	@Bean
	public ConsumerFactory<Integer, User> consumerFactory() {
		Map<String,Object> configProps = new HashMap<>();
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerAddress);
		configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "json");
		return new DefaultKafkaConsumerFactory<>(configProps,	new StringDeserializer(),new JsonDeserializer(User.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<Integer, User> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<Integer, User> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
}
