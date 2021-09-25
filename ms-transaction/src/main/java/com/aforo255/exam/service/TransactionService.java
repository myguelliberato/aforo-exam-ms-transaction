package com.aforo255.exam.service;

import com.aforo255.exam.domain.Transaction;

public interface TransactionService {
	public Transaction save(Transaction transaction);

	public Iterable<Transaction> findByInvoiceId(Integer invoiceId);

	public Iterable<Transaction> findAll();
}
