package com.capgemini.transactionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.transactionservice.entity.BankAccountTransaction;
import com.capgemini.transactionservice.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	TransactionService service;
	
	@GetMapping("/transaction/deposit/{id}/{amount}")
	public ResponseEntity<BankAccountTransaction> deposit(@PathVariable("id") int accountNumber, @PathVariable("amount") double amount){
		return new ResponseEntity(service.deposit(accountNumber, amount), HttpStatus.OK);
	}
	
	@GetMapping("/transaction/{id}/{amount}")
	public ResponseEntity<BankAccountTransaction> withdraw(@PathVariable("id") int accountNumber, @PathVariable("amount") double amount) {
		return new ResponseEntity(service.withdraw(accountNumber, amount), HttpStatus.OK);
	}

	@GetMapping("/transaction/{senderId}/{reciverId}/{amount}")
	public ResponseEntity<BankAccountTransaction> fundTransfer(@PathVariable("senderId") int senderId, @PathVariable("receiverId") int reciverId,
			@PathVariable("amount") double amount) {
		return new ResponseEntity(service.fundTransfer(senderId, reciverId, amount), HttpStatus.OK);
	}
	
}
