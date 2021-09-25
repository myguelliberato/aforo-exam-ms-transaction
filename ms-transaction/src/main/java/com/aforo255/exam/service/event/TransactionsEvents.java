package com.aforo255.exam.service.event;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.exam.domain.Transaction;
import com.aforo255.exam.service.TransactionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class TransactionsEvents {

	@Autowired
	private TransactionService transactionService;
	private Logger log = LoggerFactory.getLogger(TransactionsEvents.class);
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord ) throws JsonMappingException, JsonProcessingException {
		Transaction event = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("transactionEvent : {}", event.getInvoiceId());		
		transactionService.save(event);
	}
	
}