package com.blogic;

import com.exceptions.InsufficientFundsException;
import com.exceptions.InvalidAmountException;
import com.specs.BankAccount;

public class HDFCBankAccount implements BankAccount {
	
	private long accNum;
	private String accHName;
	private double balance;

	public HDFCBankAccount() {	}
	
	public HDFCBankAccount(long accNum, String accHName, double balance) {
		this.accNum = accNum;
		this.accHName = accHName;
		this.balance = balance;
	}

	@Override
	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public String getAccHName() {
		return accHName;
	}

	public void setAccHName(String accHName) {
		this.accHName = accHName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void deposit(double amt) throws InvalidAmountException{
		if(amt <= 0)
			throw new InvalidAmountException("Do not pass -ve amount");
		
		this.balance = this.balance + amt;
	}
	
	@Override
	public void withdraw(double amt) throws InvalidAmountException, InsufficientFundsException {
		if(amt <= 0) 
			throw new InvalidAmountException("Do not pass -ve amount");

		if(amt > balance) 
			throw new InsufficientFundsException("balance is low");
		
		this.balance = this.balance-amt;
	}
	
	@Override
	public void currentBalance() {
		System.out.println(balance);
	}
	
	@Override
	public String toString() {
		return "BankAccount(" + accNum + ", " + accHName + ", " + balance + ")";
	}
	
}
