package com.threads;

import com.exceptions.InvalidAmountException;
import com.specs.BankAccount;

public class DepositerThread implements Runnable{

	private BankAccount acc;
	private double amt;
	
	public DepositerThread(BankAccount acc, double amt) {
		this.acc = acc;
		this.amt = amt;
		
		Thread th = new Thread(this);
		th.start();
	}
	
	@Override
	public void run() {
		try {
			
			acc.deposit(amt);
			
			System.out.print(amt + " credited in the your account "+ acc.getAccNum() + 
						" available balance is: ");
			acc.currentBalance();
			
		}catch(InvalidAmountException e) {
			System.out.println(e.getMessage());
		}
	}
}
