package com.threads;

import com.exceptions.InsufficientFundsException;
import com.exceptions.InvalidAmountException;
import com.specs.BankAccount;

public class WithdraweeThread implements Runnable{
	
	private BankAccount acc;
	private double amt;
	
	public WithdraweeThread(BankAccount acc, double amt) {
		this.acc = acc;
		this.amt = amt;
		
		Thread th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		try {
			acc.withdraw(amt);
			
			System.out.print(amt + " debited in the your account "+ acc.getAccNum() + 
					" available balance is: ");
			acc.currentBalance();
			
		}catch(InvalidAmountException e) {
			System.out.println(e.getMessage());
		}catch(InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
			
	}
	
	
}
