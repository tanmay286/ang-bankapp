package com.capgemini.transactionservice.service;

public interface TransactionService {
	public double getBalance();
	public double deposit(int accountNumber, double amount);
	public double withdraw(int accountNumber, double amount);
	public double fundTransfer(int senderNumber, int reciverNumber, double amount);
}
