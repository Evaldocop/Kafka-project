package com.gesoft.strprooducer.config;

import java.util.HashMap;
import java.util.Properties;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class StringProducerFactoryConfigs {
	
	private final KafkaProperties proprerties;
	
	@Bean
	public ProducerFactory<String,String> producerFactory(){
		
		var configs = new HashMap<String, Object>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, proprerties.getBootstrapServers());
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	
	@Bean
	public KafkaTemplate<String, String> kafkatemplate(ProducerFactory<String,String> producerFactory){
		return new KafkaTemplate<>(producerFactory);
	}

}
