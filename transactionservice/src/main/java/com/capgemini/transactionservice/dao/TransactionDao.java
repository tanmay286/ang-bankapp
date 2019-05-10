package com.capgemini.transactionservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.transactionservice.entity.BankAccountTransaction;

public interface TransactionDao extends JpaRepository<BankAccountTransaction, Integer> {

}
