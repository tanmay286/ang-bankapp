package com.capgemini.accountservice.entity;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
public class SavingAccount extends BankAccount {
	
	private boolean salary;

	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(String accountHolderName, double accountBalance, String accountType, boolean salary) {
		super(accountHolderName, accountBalance, accountType);
		this.salary = salary;
	}

	
	
	public boolean isSalary() {
		return salary;
	}

	public void setSalary(boolean salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SavingAccount [salary=" + salary + "]";
	}
	
	
	
	

}
