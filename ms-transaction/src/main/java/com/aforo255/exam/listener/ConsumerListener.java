package com.aforo255.exam.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.aforo255.exam.service.event.TransactionsEvents;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ConsumerListener {
	@Autowired
	private TransactionsEvents transactionsEvents;
	
	@KafkaListener(topics = { "transaction-events" })
	public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info(":::::::::::::: CONSUME TX ::::::::::::::");
		log.info("ConsumerRecord : {}", consumerRecord.value());
		transactionsEvents.processTransactionEvent(consumerRecord);
	}
}