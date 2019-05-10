package com.capgemini.accountservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.accountservice.entity.BankAccount;
import com.capgemini.accountservice.service.BankAccountService;

@RestController
public class AccountController {
	@Autowired
	private BankAccountService service;
	
	@PostMapping("/account")
	public ResponseEntity<BankAccount> addNewAccount(@RequestBody BankAccount account){
		BankAccount a = service.addNewAccount(account);
		return new ResponseEntity<BankAccount>(a, HttpStatus.CREATED);
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<BankAccount> getAccountById(@PathVariable("id") int id){
		Optional<BankAccount> account = service.findAccountById(id);
		if(!account.isPresent()) {
			return new ResponseEntity<BankAccount>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BankAccount>(account.get(), HttpStatus.OK);
	}
	
	@GetMapping("/account")
	public ResponseEntity<List<BankAccount>> getAllAccounts(){
		List<BankAccount> account = service.getAllAccounts();
		return new ResponseEntity<List<BankAccount>>(account, HttpStatus.OK);
	}
	
	@PutMapping("/account")
	public ResponseEntity<BankAccount> updateAccount(@RequestBody BankAccount account){
		if(!service.updateAccount(account)) {
			return new ResponseEntity<BankAccount>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BankAccount>(account, HttpStatus.OK);
	}
	
	@DeleteMapping("/account/{id}")
	public ResponseEntity<BankAccount> deleteAccount(@PathVariable("id") int id){
		if(!service.deleteAccount(id)) {
			return new ResponseEntity<BankAccount>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<BankAccount>(HttpStatus.OK);
	}
	
	
}
