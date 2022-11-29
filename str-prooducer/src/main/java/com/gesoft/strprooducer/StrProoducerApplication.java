package com.gesoft.strprooducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class StrProoducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StrProoducerApplication.class, args);
	}

}
