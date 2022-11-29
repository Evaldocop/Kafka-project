package com.gesoft.jsonconsumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.gesoft.jsonconsumer.model.Payment;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Component
public class JsonListener {
	@SneakyThrows
	@KafkaListener(topics = "payment-topic",groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void antiFraude(@Payload Payment payment) {
		
		
		log.info("Recebi pagamentoa {}",payment.toString());
		Thread.sleep(2000);
		
		
		log.info("Validando fraude....");
		Thread.sleep(2000);
		
		log.info("Compra aprovada");
		Thread.sleep(2000);
		
	}
	
	@SneakyThrows
	@KafkaListener(topics = "payment-topic",groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pdfGenerator() {
		
		log.info("Gerando pdf....");
		Thread.sleep(2000);
		
	}
	
	@SneakyThrows
	@KafkaListener(topics = "payment-topic",groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmai() {
		
		log.info("Enviando email de confirmação...");
	
		
	}

}
