package com.spec;

import com.customexception.InsufficientFundsException;
import com.customexception.InvalidAmountException;
import com.pojo.BankAccountDetails;

public interface BankAccount {
	
	public void init(BankAccountDetails accDetails);
	
	public void deposit(double amt) 
			throws InvalidAmountException;
	
	public void withdraw(double amt) 
			throws InvalidAmountException, InsufficientFundsException ;
	
	public void currentBalance();
	
	public void transferMoney(BankAccount destAcc, double amt)
			throws InvalidAmountException, InsufficientFundsException;
	
}

//1) multiple type inheritance
//2) high cohesion
//3) strong encapsulation
//4) loose coupling
//5) runtime polymorphism
//6) Extensible
//7) scalable

