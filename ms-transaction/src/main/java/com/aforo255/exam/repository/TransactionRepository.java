package com.aforo255.exam.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.aforo255.exam.domain.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

	@Query("{'invoicedId':?0}")
	public Iterable<Transaction> findByInvoicedId(Integer invoicedId);
}
