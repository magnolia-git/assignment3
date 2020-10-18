package com.meritamerica.assignment3;

import com.meritamerica.assignment3.AccountHolder;

public class MeritAmericaBankApp {
	public static void main(String[] args) {
		MeritBank.readFromFile("src/test/testMeritBank_good.txt");
		System.out.println("Hello Merit America!");
		
		
		MeritBank.setCDOfferings(initialCDOfferings());
					
		
		AccountHolder newAcc1 = new AccountHolder("Jackie", "Chan", "Chan","1234567891");
					
		
		newAcc1.addCheckingAccount(new CheckingAccount(1000.00));
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addSavingsAccount(new SavingsAccount(10000.00));
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addCheckingAccount(5000.00);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addSavingsAccount(50000.00);
					System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addCheckingAccount(50000.00);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addSavingsAccount(500000);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addCheckingAccount(5000.00);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		newAcc1.addSavingsAccount(50000.00);
		System.out.println(newAcc1.getCombinedBalance());
					
		
		System.out.println(newAcc1.getNumberOfCheckingAccounts());
		System.out.println(newAcc1.getNumberOfSavingsAccounts());
		System.out.println(newAcc1.getCheckingBalance() + newAcc1.getSavingsBalance());
					
		CDOffering bestCDOffering = MeritBank.getBestCDOffering(100);
		CDAccount aCDAccount = new CDAccount(bestCDOffering, 100);
		System.out.println("aCDAccount's balance: " + aCDAccount.getBalance());

		newAcc1.addCDAccount(aCDAccount);
		
		System.out.println("Accessing aCDAccount from newAcc1... " + newAcc1.getCDBalance());

	}
	
	public static CDOffering[] initialCDOfferings() {
		CDOffering[] cdOfferings = new CDOffering[5];
		cdOfferings[0] = new CDOffering(1, 1.8 / 100);
		cdOfferings[1] = new CDOffering(2, 1.9 / 100);
		cdOfferings[2] = new CDOffering(3, 2.0 / 100);
		cdOfferings[3] = new CDOffering(5, 2.5 / 100);
		cdOfferings[4] = new CDOffering(10, 2.2 / 100);

		return cdOfferings;
	}
	
}