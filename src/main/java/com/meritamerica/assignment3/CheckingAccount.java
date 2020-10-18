package com.meritamerica.assignment3;

import java.text.ParseException;


	public class CheckingAccount extends BankAccount {
	
		public CheckingAccount(double openingBalance) {
			super(openingBalance);
		}
		
		public double getInterestRate() {return 0.0001;}
		
		public static CheckingAccount readFromString(String accountData) throws ParseException {
			return null;
		}
}