package com.aforo255.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.aforo255.exam.domain.Transaction;
import com.aforo255.exam.repository.TransactionRepository;
import com.aforo255.exam.service.TransactionService;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	@Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED,rollbackFor = Exception.class)
	public Transaction save(Transaction t) {
		log.info("save:::{}",new Gson().toJson(t));
		return transactionRepository.save(t);
	}

	@Override
	public Iterable<Transaction> findByInvoiceId(Integer invoiceId) {
		
		return transactionRepository.findByInvoicedId(invoiceId);
	}

	@Override
	public Iterable<Transaction> findAll() {
		
		return transactionRepository.findAll();
	}

}
