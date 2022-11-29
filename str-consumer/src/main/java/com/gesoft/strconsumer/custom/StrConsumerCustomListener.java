package com.gesoft.strconsumer.custom;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

//inteface anotada(@) - meta anotação-produzir anotacoes
//@Retention - informandodo para o compiplador e o jvm 
//que essa anotação de estar disponível por meio de reflexão em tempo de execução
@Retention(RetentionPolicy.RUNTIME)
//definindo suas proprias anotacoes
@Target(ElementType.METHOD)
@KafkaListener
public @interface StrConsumerCustomListener {
	
	@AliasFor( annotation = KafkaListener.class,  attribute = "topics")
	String[] topics() default "str-topic";
	

	@AliasFor( annotation = KafkaListener.class,  attribute = "containerFactory")
	String containerFactory() default "strContainerFactory";
	
	
	@AliasFor( annotation = KafkaListener.class,  attribute = "groupId")
	String groupId() default "";
	
	
	@AliasFor( annotation = KafkaListener.class,  attribute = "errorHandler")
	String errorHandler() default "errorCustomHnadler";
	
	
	

}
