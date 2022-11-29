package com.gesoft.strconsumer.listenes;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import com.gesoft.strconsumer.custom.StrConsumerCustomListener;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Component
public class StrConsumerListener {

	/*@KafkaListener(groupId = "group-1", 
			       topicPartitions = {
			    		   @TopicPartition(topic = "str-topic",partitions = {"0"})
			    		   }, 
			       containerFactory = "strContainerFactory")*/
	//lombook - Throws Exception 
	@SneakyThrows
	@StrConsumerCustomListener(groupId = "group-1")
	public void create(String message) {
		log.info("CREATE-Rebeu amensagem: "+message);
		throw new IllegalArgumentException("Exeption....");
	}
	
	/*@KafkaListener(groupId = "group-1",  topicPartitions = {
 		           @TopicPartition(topic = "str-topic",partitions = {"1"})
 		           },
			       containerFactory = "strContainerFactory")*/
	@StrConsumerCustomListener(groupId = "group-1")
	public void log(String message) {
		log.info("LOG - Rebeu amensagem: "+message);
	}
	
	@KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
	
//	@StrConsumerCustomListener(groupId = "group-2")
	public void history(String message) {
		log.info("HISTORY - Rebeu amensagem: "+message);
	}
}
