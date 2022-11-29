package com.gesoft.strconsumer.exceptions;

import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Component
public class ErrorCustomHnadler implements KafkaListenerErrorHandler {

	/*
	 * @Override public Object handleError(Message<?> message,
	 * ListenerExecutionFailedException exception, Consumer<?,?> consumer) { // TODO
	 * Auto-generated method stub return
	 * KafkaListenerErrorHandler.super.handleError(message, exception,consumer); }
	 */

	@Override
	public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
		log.info("EXCEPTION ::: Capturei um erro");
		log.info("Payload ::: {}", message.getPayload());
		log.info("Headers ::: {}", message.getHeaders());
		log.info("Offset ::: {}", message.getHeaders().get("kafka_offset"));
		log.info("Message exception ::: {}", exception.getMessage() );
		return null;
	}

}
