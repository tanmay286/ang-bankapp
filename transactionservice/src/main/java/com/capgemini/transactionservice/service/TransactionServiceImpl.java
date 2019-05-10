package com.capgemini.transactionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import com.capgemini.accountservice.entity.BankAccount;
import com.capgemini.transactionservice.dao.TransactionDao;
import com.capgemini.transactionservice.entity.BankAccountTransaction;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionDao dao;
	
	String baseUrl = "http://localhost:8080/account";
	
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposit(int accountNumber, double amount) {
		RestTemplate restTemplate = new RestTemplate();
		BankAccount account = restTemplate.getForObject(baseUrl + "/" + accountNumber, BankAccount.class);
		double newBalance = account.getAccountBalance()+amount;
		System.out.println("newBalance: "+newBalance);
		account.setAccountBalance(newBalance);
		restTemplate.put(baseUrl, account, BankAccount.class);
		BankAccountTransaction transaction = new BankAccountTransaction(account.getAccountHolderName(), account.getAccountType());
		dao.save(transaction);
		return account.getAccountBalance();
	}

	@Override
	public double withdraw(int accountNumber, double amount) {
		RestTemplate restTemplate = new RestTemplate();
		BankAccount account = restTemplate.getForObject(baseUrl + "/" + accountNumber, BankAccount.class);
		double currentBalance = account.getAccountBalance();
		if(currentBalance >= amount)
		{
			currentBalance = currentBalance - amount;
			account.setAccountBalance(currentBalance);
			restTemplate.put(baseUrl,account, BankAccount.class);
		}
		BankAccountTransaction transaction = new BankAccountTransaction(account.getAccountHolderName(), account.getAccountType());
		dao.save(transaction);
		return currentBalance;
	}

	@Override
	public double fundTransfer(int senderNumber, int reciverNumber, double amount) {
		double balance = withdraw(senderNumber, amount);
		deposit(reciverNumber, amount);
		return balance;
	}

}
