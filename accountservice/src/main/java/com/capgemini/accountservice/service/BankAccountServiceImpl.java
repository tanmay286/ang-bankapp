package com.capgemini.accountservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.accountservice.dao.BankAccountDao;
import com.capgemini.accountservice.entity.BankAccount;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private BankAccountDao dao;
	
	@Override
	public BankAccount addNewAccount(BankAccount account) {
		BankAccount a = dao.save(account);
		return a;
	}

	@Override
	public Optional<BankAccount> findAccountById(int id) {
		Optional<BankAccount> account = dao.findById(id);
		return account;
	}

	@Override
	public boolean updateAccount(BankAccount account) {
		Optional<BankAccount> a = dao.findById(account.getAccountNumber());
		if(a.isPresent()) {
			dao.save(account);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAccount(int id) {
		Optional<BankAccount> a = dao.findById(id);
		if(a.isPresent()) {
			dao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<BankAccount> getAllAccounts() {
		return dao.findAll();
	}

}
