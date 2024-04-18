package com.user;

import com.blogic.HDFCBankAccount;
import com.specs.BankAccount;
import com.threads.DepositerThread;
import com.threads.WithdraweeThread;

public class Bank {
	public static void main(String[] args) throws InterruptedException {
		
		BankAccount acc1 = new HDFCBankAccount(1234, "HK", 10000);
		BankAccount acc2 = new HDFCBankAccount(5678, "BK", 20000);
		BankAccount acc3 = new HDFCBankAccount(4563, "PK", 30000);
		
		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println(acc3);
		System.out.println();
		
		DepositerThread dt1 = new DepositerThread(acc1, 5000);
		DepositerThread dt2 = new DepositerThread(acc2, 3000);
		WithdraweeThread wt1 = new WithdraweeThread(acc3, 7000);
		

		Thread.sleep(1000);
		
		System.out.println();
		System.out.println(acc1);
		System.out.println(acc2);
		System.out.println(acc3);
		System.out.println();
		
	}
}
