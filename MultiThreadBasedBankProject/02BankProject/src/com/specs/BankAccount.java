package com.specs;

import com.exceptions.InsufficientFundsException;
import com.exceptions.InvalidAmountException;

public interface BankAccount {
	
	public long getAccNum();
	public void deposit(double amt) throws InvalidAmountException;
	public void withdraw(double amt) throws InvalidAmountException, InsufficientFundsException;
	public void currentBalance();
	
}

