package com.aforo255.exam.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.exam.domain.Transaction;
import com.aforo255.exam.service.TransactionService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class HistoricalController {

	@Autowired
	private TransactionService transactionService ;	
	
	@GetMapping("/v1/load")	
	public List<Transaction> load (){
		log.info("load");
		return ( List<Transaction>)transactionService.findAll();
	}
	
	@GetMapping ("/transaction/{invoiceId}")
	public ResponseEntity<?> getByInvoiceId (@PathVariable Integer invoiceId){
		log.info("getByInvoiceId:::{}",invoiceId);
		Iterable< Transaction> transaction= transactionService.findByInvoiceId(invoiceId);
		return ResponseEntity.ok(transaction);
	}	
}