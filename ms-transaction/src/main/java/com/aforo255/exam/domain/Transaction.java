package com.aforo255.exam.domain;

import java.time.LocalDateTime;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "transaction")
public class Transaction {

	@BsonId
	private String id;
	private double amount;
	private int invoiceId;
	private LocalDateTime date;

}