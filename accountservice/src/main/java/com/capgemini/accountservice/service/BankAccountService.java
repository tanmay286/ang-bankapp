package com.capgemini.accountservice.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.accountservice.entity.BankAccount;

public interface BankAccountService {	
	public BankAccount addNewAccount(BankAccount account);
	public Optional<BankAccount> findAccountById(int id);
	public List<BankAccount> getAllAccounts();
	public boolean updateAccount(BankAccount account);
	public boolean deleteAccount(int id); 
}
